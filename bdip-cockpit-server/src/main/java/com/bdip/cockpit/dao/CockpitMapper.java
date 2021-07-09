package com.bdip.cockpit.dao;

import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ssw
 * @Date: 2021/07/08/18:06
 * @Description:
 */
@Mapper
public interface CockpitMapper {

    @Select("select id,name from prj_projectinfo")
    List<Map> getAllProjects();

    @Select("select b.rq,(case when c.count is null or c.count = '' then 0 else c.count end)num,(case when f.count is null or f.count = '' then 0 else f.count end)deal from (select #{rq1} rq union all select #{rq2} rq union all select #{rq3} rq union all select #{rq4} rq union all select #{rq5} rq union all select #{rq6} rq union all select #{rq7} rq union all select #{rq8} rq)b\n" +
            "left join (select count(1)count,d.${field1} from (select a.${field1},(select currentnodetype from workflow_requestbase where requestid = a.requestId)currenttype from ${table1} a)d where d.currenttype = 3 group by d.${field1}) c on b.rq = c.${field1}\n" +
            "left join (select count(1)count,d.${field2} from (select a.${field2},(select currentnodetype from workflow_requestbase where requestid = a.requestId)currenttype from ${table2} a)d where d.currenttype = 3 group by d.${field2}) f on b.rq = f.${field2}")
    List<Map> getSaftyData(String table1, String field1, String table2, String field2
            ,String rq1 ,String rq2 ,String rq3 ,String rq4 ,String rq5 ,String rq6 ,String rq7 ,String rq8 );
}
