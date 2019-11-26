package com.qin.apps.cms.web.controller;

import com.qin.apps.cms.service.IAlipayService;
import com.qin.apps.cms.utils.AlipayBean;
import com.qin.apps.cms.utils.Message;
import com.qin.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description ="支付宝支付")
@RestController
@RequestMapping("/AliPayController")
public class AliPayController {
    @Autowired
    private IAlipayService alipayService;
    @ApiOperation(value="支付宝扫码支付",notes="注意！测试的时候请将地址粘贴到浏览器地址栏测试")
    @GetMapping("aliPay")
    public String aliPay(Double total_amount){
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setBody("给作者打赏！");
        alipayBean.setSubject("打赏");
        alipayBean.setTotal_amount(total_amount);
        Integer no=(int)(Math.random()*10000)+1000;
        String s = String.valueOf(no);
        alipayBean.setOut_trade_no(s);
        String msg= alipayService.aliPay(alipayBean);
        System.out.println("调用后："+msg);
        return msg;
    }
}
