package com.bdip.cockpit.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.bdip.cockpit.dao.CockpitMapper;
import com.bdip.cockpit.service.CockpitService;
import com.bdip.cockpit.util.SFilePathHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ssw
 * @Date: 2021/07/08/17:58
 * @Description:
 */
@Service("CockpitService")
public class CockpitServiceImpl implements CockpitService {

    @Autowired
    private CockpitMapper mapper;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Map> getAllProjects(String userid) {
        return mapper.getAllProjects(userid);
    }

    @Override
    public Map<String,Object> getSaftyData(String table1, String field1, String table2, String field2, String type) {
        List<Map> data = mapper.getSaftyData(table1, field1, table2, field2, beforeMonth48(0), beforeMonth48(1), beforeMonth48(2), beforeMonth48(3), beforeMonth48(4), beforeMonth48(5), beforeMonth48(6), beforeMonth48(7), beforeMonth48(8), beforeMonth48(9), beforeMonth48(10), beforeMonth48(11));
        Map<String,Object> map = new HashMap<>();
        List<String> categories = new ArrayList<>();
        List<Map<String,Object>> series = new ArrayList<>();
        List<String> num = new ArrayList<>();
        List<String> deal = new ArrayList<>();
        data.stream().forEach(s->{
            categories.add((String) s.get("rq"));
            num.add(s.get("num")+"");
            deal.add(s.get("deal")+"");
        });
        Map<String,Object> n = new HashMap<>();
        n.put("name",type+"累计数量");
        n.put("data",num);
        series.add(n);
        Map<String,Object> d = new HashMap<>();
        d.put("name",type+"解决累计数量");
        d.put("data",deal);
        series.add(d);
        map.put("categories",categories);
        map.put("series",series);
        return map;
    }

    @Override
    public List<Map> getWorkflowData(String table, String field) {
        return mapper.getWorkflowData(table, field);
    }

    @Override
    public String getModelTree(String projectid, String userid) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(SFilePathHelper.dataMap.get("model_tree_url")+"/filebim/setTreeMenu.action5?projectid="+projectid+"&userid="+userid, String.class);

        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();

        System.out.println("body:" + body);
        System.out.println("statusCode:" + statusCode);
        System.out.println("statusCodeValue" + statusCodeValue);
        System.out.println("headers" + headers);

        return body;
    }

    private String getDate(int num) {
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-num);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        return sp.format(d);
    }

    /**
     * 查找上n个月
     * @param num
     * @return
     */
    public static String beforeMonth48(int num){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter sdf =  DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth yearMonth = YearMonth.parse(localDate.format(sdf));
        String s = yearMonth.minus(num, ChronoUnit.MONTHS).toString();
        System.out.println("yearMonth.minus(1, ChronoUnit.MONTHS).toString() = " + s);
        return s;
    }
}
