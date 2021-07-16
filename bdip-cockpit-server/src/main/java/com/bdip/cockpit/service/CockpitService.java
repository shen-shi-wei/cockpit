package com.bdip.cockpit.service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ssw
 * @Date: 2021/07/08/17:58
 * @Description:
 */
public interface CockpitService {

    /**
     * 获取所有项目
     * @return
     */
    List<Map> getAllProjects(String userid);

    /**
     * 获取安全数量
     * @param table1
     * @param field1
     * @param table2
     * @param field2
     * @param type
     * @return
     */
    Map<String,Object> getSaftyData(String table1, String field1, String table2, String field2, String type);

    List<Map> getWorkflowData(String table, String field);

    String getModelTree(String projectid, String userid);
}
