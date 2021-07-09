package com.bdip.cockpit.service.impl;

import com.bdip.cockpit.dao.CockpitMapper;
import com.bdip.cockpit.service.CockpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Map> getAllProjects() {
        return mapper.getAllProjects();
    }

    @Override
    public List<Map> getSaftyData(String table1, String field1, String table2, String field2) {
        return mapper.getSaftyData(table1, field1, table2, field2, getDate(0), getDate(1), getDate(2), getDate(3), getDate(4), getDate(5), getDate(6), getDate(7));
    }

    private String getDate(int num) {
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-num);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        return sp.format(d);
    }
}
