package com.xzt.ts.service.impl.gbw;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.xzt.ts.entity.gbw.OrderInfo;
import com.xzt.ts.mapper.gbw.OrderInfoMapper;
import com.xzt.ts.service.gbw.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 投保单信息 服务实现类
 * </p>
 *
 * @author xzt
 * @since 2022-06-27
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    public String hello(String name) {
//这个一定要放在第一行,否则无法进行分页
        PageHelper.startPage(1,10);
        List<OrderInfo> list = this.list();
        return JSONUtil.toJsonStr(list);
    }

}
