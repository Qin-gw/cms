package com.qin.apps.cms.service.impl;

import com.alipay.api.AlipayApiException;
import com.qin.apps.cms.service.IAlipayService;
import com.qin.apps.cms.utils.AlipayBean;
import com.qin.apps.cms.utils.AlipayUtil;
import com.qin.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

@Service
public class AliPayServiceImpl  implements IAlipayService {
    @Override
    public String aliPay(AlipayBean alipayBean) {
        try {
            return AlipayUtil.connect(alipayBean);
        } catch (AlipayApiException e) {
            throw new CustomerException("支付异常！");
        }
    }
}
