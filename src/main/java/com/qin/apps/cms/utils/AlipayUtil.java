package com.qin.apps.cms.utils;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

public class AlipayUtil {
	public static String connect(AlipayBean alipayBean) throws AlipayApiException {
		
		
		
        //1、获得初始化的AlipayClient
		 AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",//支付宝网关
	               "2016092500596849",//appid
	                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCPGE06Jiv340RSW8Z4m+TPutxYsXOIXd+2mRX/MzZ0V8O6uKK6W523TOrEk+U0OVROJONwLKF3k9JG8YzsTTOM1oDSYdk77DoBXLy184l9TaMF+bjlQbOkmkrZDMJD5lrZiKIemJ4yKNN+PD6d7E+/hAVUmlErsXPldW6OP8dyy20ufC+Cwmi0GOCmq2ixrR61ykHSVzEBTFOhvFnKmsET9O9jppy1u3yrHboJsBEglWb+l3xYvmrQxGZ7yWIdbZ+xQdMQ3O/U8vxeE/WorHySSak84hdMMPH1fuGJOMB8gEET5Vhr9EbYwLHsRuk82v+jFwxb7TfuA6YmDvNLMRVlAgMBAAECggEARVvMIwFZkn/QH/NoEhHOKHo0T7FDhLertgAhz17taBsaPik8hwPdQHnB2aKuGFApcu8iZr7bTPCTndt7KRaKhBt8uXzAJPFtdDeVKMRwwhGdkUnnuwfLoV9AJFCw4OSI6KP3oMjs9Pcg/DELUNS4GuZNByL9cSZEPNZczgpQDG2gO9ioOl0xWD+T+MA6N/YQsYpmkrooQWHlHnywTmdRKMp5PmDXsCdyHE8gWD4/71kHNuWFYYSifYS7Wgc/H1NEmPz7Xffd0ZxbanzvG4pRiXJTpWzI5nTe9RqlfgjeDMhjLhgzW1xMUcTc7VqZeX3Yh1zqWRoGRscelojCVVUiSQKBgQDHjkk1qpRL1TdJ9F28K8j+zsy4nu4vzFx5w7daTU6wOl/d8tVrFG5QgfHGRjMJ5Tk1uzDpErmtVTsVs3vSSApe9+E1g81MAS0FyMF9zHMoIJoI2ZkVLlzxDSJHdqySDMwk6fjLSGDJhs+TneyBTvM/RxCVwJPrKRPT0guVzgF8twKBgQC3kbfVu3JXj23HsTCOp7Q/0aAZixXggeHjkS/t+gUqt93fSolbJEQctK2M+A9ggw+MJwsezCa3b+fS3RL20nN78Gg8f2paXcHDqP/Njhr0gzDuaplmy3e7x0JCrQjN1CWD/bvdGmyJBWecfbYT49pr+QSID/Vj6Hcm+2Ljhj+awwKBgQCTzqIPK/+Xg5/mGSfsnonLoiUkgiNuJ/I/BmYibqxf/3zOinTlUUa8PuNztr9LDwum7rW1jPcWmdCfrEeEY3O7D+MxniRLrXtJk38tzGdnS26MK5AljietK8s+H3qG2w/CL8Ll3wBBhKbvccOhq3akYeC46uElB1H2TNfj56hWVQKBgEcnYYWkOcb83oWoBfVVxgVywMcF5X33elKWRWjOH9CWIpdZsfI1FX22/wqEYJl9U7p0q9fNNDioVMikTqSDoKXq4syIavYKH4Ay8qx/p60daQsRINL6jTepHeLwZVg7IiuOX5JtmqJmCOpcxAXjrRdrF7mRzgFi60Sd7o/YyrC3AoGAC3i6bOadYoY72hcB42jF83WtfOY4V0eFiCzVWJnpj5ZG5iy05oqXGnHMzPAwFlbv/c2uCxKWhJZTPoA8RbjlysHClTjGM+cVJZhXwieUzhLE86rBHQoi5LDKU5yym+9hw6UHrH8WPEDXl4RZl2zEDP35ThUE/U62XyPm+cmPC5o=",//商户私钥
	                "json",
	               "utf-8",//字符编码格式
	                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwas2+HPNCKExTLvFeERwSjfP8yZ8JePRMVjLZIdAYzE2bD5RlqrQben9dqqJzHSrPNmpjedN/jqTA8FT0lEMFEb/aO7Q8bMVlY9N/zMn/eO0RcoWM+w+sJsn8J3+HD4OZSp82AC0dSqF+8y6DmKdarc7pbWgLMRRE8dnTZ8FH8wJWIOoQcU/SFPsxKT11Rfgb1OEUZGPYSa02k9KZ2NW29u+enzNgt+z9NUDMSyls/08j4CuZ5jyMBeQpvsso229vvYOQR/uOf+/dLIj8ycS/WcoQKSQR/8Ghf038A9PYAPw7HgPnUvzkosFNZXQumP7Wol8cZIJqBBOG4L4/t7PawIDAQAB",//支付宝公钥
	                "RSA2"//签名方式
				 );
		//2、设置请求参数
	        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	      //页面跳转同步通知页面路径
	        alipayRequest.setReturnUrl("http://www.baidu.com");
	        // 服务器异步通知页面路径
	      //  alipayRequest.setNotifyUrl(PropertiesConfig.getKey("notify_url"));
	      //封装参数
	        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
	      //3、请求支付宝进行付款，并获取支付结果
	        //System.out.println( "tttttt" +  alipayClient.pageExecute(alipayRequest) );
	        //System.out.println(alipayClient +  "----------");
	        //System.out.println(alipayClient.pageExecute(alipayRequest) +  "----------");
	        
	        String result = alipayClient.pageExecute(alipayRequest).getBody();
	      //返回付款信息
	        return  result;

	}
	        
}
