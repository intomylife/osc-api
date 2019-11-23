package com.zwc.base.controller;

import com.zwc.base.service.VisitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName VisitController
 * @Desc TODO   访问记录 - 前端控制器
 * @Date 2019/11/1 4:54 PM
 * @Version 1.0
 */
@RestController
@RequestMapping("/visit")
@Api(value = "访问接口", description = "记录用户访问信息接口")
public class VisitController {

    @Autowired
    private VisitService visitService;

    /*
      * @ClassName VisitController
      * @Desc TODO  记录用户访问信息
      * @Date 2019/11/1 4:57 PM
      * @Version 1.0
     */
    @GetMapping(value = "/toVisit")
    @ApiOperation(value = "访问接口 - 记录用户访问信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public String toVisit(HttpServletRequest request) {
        try {
            // 调用访问逻辑
            return visitService.toVisit(request.getSession().getId());
        } catch (Exception e) {
            e.printStackTrace();
            // 出错了返回 error
            return "error";
        }
    }

}
