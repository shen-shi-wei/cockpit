package com.bdip.cockpit.controller;

import com.bdip.cockpit.constant.ApiResult;
import com.bdip.cockpit.service.CockpitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ssw
 * @Date: 2021/07/08/10:44
 * @Description:
 */
@RestController()
@Api(tags = "可配置驾驶舱Api")
@RequestMapping("/ssw/cockpit")
public class CockpitController {

    @Autowired
    private CockpitService service;

    @GetMapping("/getAllProjects")
    @ApiOperation("获取所有项目")
    public Object getAllProjects(@RequestParam(value = "userid",required = true) String userid,@RequestParam(value = "data") String data) {
        if ("1".equals(data)) {
            return service.getAllProjects(userid);
        } else {
            return ApiResult.success(service.getAllProjects(userid));
        }
    }

    @GetMapping("/getSaftyData")
    @ApiOperation("获取安全或质量的数量统计")
    public Object getSaftyData(@RequestParam(value = "table1",required = true) String table1
            ,@RequestParam(value = "field1",required = true) String field1
            ,@RequestParam(value = "table2",required = true) String table2
            ,@RequestParam(value = "field2",required = true) String field2
            ,@RequestParam(value = "data") String data
            ,@RequestParam(value = "type",required = true) String type) {
        if ("1".equals(data)) {
            return service.getSaftyData(table1, field1, table2, field2, type);
        }else {
            return ApiResult.success(service.getSaftyData(table1, field1, table2, field2, type));
        }
    }

    @GetMapping("/getWorkflowData")
    @ApiOperation("获取流程数据")
    public Object getWorkflowData(@RequestParam(value = "table",required = true) String table
            ,@RequestParam(value = "field",required = true) String field,@RequestParam(value = "data") String data) {
        if ("1".equals(data)) {
            return service.getWorkflowData(table, field);
        } else {
            return ApiResult.success(service.getWorkflowData(table, field));
        }
    }

    @GetMapping("/getModelTree")
    @ApiOperation("获取模型树数据")
    public Object getModelTree(@RequestParam(value = "projectid",required = true) String projectid
            ,@RequestParam(value = "userid",required = true) String userid,@RequestParam(value = "data") String data) {
        if ("1".equals(data)) {
            return service.getModelTree(projectid, userid);
        } else {
            return ApiResult.success(service.getModelTree(projectid, userid));
        }
    }


}
