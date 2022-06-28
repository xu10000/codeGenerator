package com.xzt.ts.controller.gbw;


import com.xzt.ts.service.impl.gbw.OrderInfoServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 投保单信息 前端控制器
 * </p>
 *
 * @author xzt
 * @since 2022-06-27
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {
    @Resource
    OrderInfoServiceImpl orderInfoServiceImpl;
    @GetMapping(value = "/order")
    public String hello() {
        return orderInfoServiceImpl.hello("xzt");
    }


}

