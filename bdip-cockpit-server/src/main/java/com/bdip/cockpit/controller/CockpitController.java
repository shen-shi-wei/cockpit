package com.bdip.cockpit.controller;

import com.bdip.cockpit.constant.ApiResult;
import com.bdip.cockpit.service.CockpitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
@RequestMapping("/ssw")
public class CockpitController {

    @Autowired
    private CockpitService service;

    @GetMapping("/getAllProjects")
    @ApiOperation("获取所有项目")
    public ApiResult getAllProjects() {
        return ApiResult.success(service.getAllProjects());
    }

//    @GetMapping("/getProjectById")
//    @ApiOperation("根据项目id获取项目信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "projectId", value = "项目id",required = true,dataType = "int", defaultValue = "3")
//    })
//    public ApiResult getProjectById(@RequestParam(value = "projectId")int projectId) {
//        return ApiResult.success(projectId);
//    }

    @GetMapping("/getSaftyData")
    @ApiOperation("获取安全数量")
    public ApiResult getSaftyData(@RequestParam(value = "table1",required = true) String table1
            ,@RequestParam(value = "field1",required = true) String field1
            ,@RequestParam(value = "table2",required = true) String table2
            ,@RequestParam(value = "field2",required = true) String field2) {
        return ApiResult.success(service.getSaftyData(table1, field1, table2, field2));
    }


}
