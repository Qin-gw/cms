package com.qin.apps.cms.web.controller;

import com.qin.apps.cms.bean.User;
import com.qin.apps.cms.bean.extend.UserExtend;
import com.qin.apps.cms.service.IUserService;
import com.qin.apps.cms.utils.JwtTokenUtil;
import com.qin.apps.cms.utils.Message;
import com.qin.apps.cms.utils.MessageUtil;
import com.qin.apps.cms.vm.UserVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(description ="用户业务接口")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;
    @ApiOperation("用户登录")
    @PostMapping("login")
    public Message login(@RequestBody UserVM userVM){
        // 1. 认证用户的用户名和密码
        User user = userService.login(userVM);
        // 2. 如果登录成功产生token,将token缓存起来，返回
        String token = JwtTokenUtil.createJWT(user.getId(), user.getUsername());
        // 3. 如果登录失败
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return MessageUtil.success(map);
    }
    @ApiOperation("用户退出登录")
    @PostMapping("logout")
    public Message logout(UserVM userVM){

        return MessageUtil.success("退出成功！");
    }
    @ApiOperation("通过token获取用户信息")
    @GetMapping("info")
    public Message info(String token){
        // 1. 通过token获取用户信息  {id,use,gender,roles:[]}
        long id = Long.parseLong(JwtTokenUtil.getUserId(token,JwtTokenUtil.base64Secret));
        UserExtend userExtend = userService.findUserExtendById(id);
        return MessageUtil.success(userExtend);
    }
}
