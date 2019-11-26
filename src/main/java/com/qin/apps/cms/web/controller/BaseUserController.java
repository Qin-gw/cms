package com.qin.apps.cms.web.controller;


import com.qin.apps.cms.bean.User;
import com.qin.apps.cms.bean.extend.UserExtend;
import com.qin.apps.cms.service.IUserService;
import com.qin.apps.cms.utils.Message;
import com.qin.apps.cms.utils.MessageUtil;
import com.qin.apps.cms.vm.UserRoleVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description ="用户管理相关接口")
@RestController
@RequestMapping("/UserController")
public class BaseUserController {
    @Autowired
    private IUserService userService;
    @ApiOperation("添加或修改用户信息")
    @PostMapping("saveOrUpdateUser")
    public Message saveOrUpdateUser(User user){
        userService.saveOrUpdateUser(user);
        return MessageUtil.success("用户更新成功！");
    }
    @ApiOperation("通过用户名查询用户信息")
    @GetMapping("findUserByName")
    public Message checkUserByName(String name){
        userService.findUserByName(name);
        return MessageUtil.success("用户名不存在！");
    }
    @ApiOperation("查询所有用户信息")
    @GetMapping("findAllUser")
    public Message findAllUser(){
        List<User> users = userService.findAllUser();
        return MessageUtil.success("查询成功！",users);
    }
    @ApiOperation(value = "查询所有用户信息",notes = "级联查询")
    @GetMapping("findAllUserExtend")
    public Message findAllUserExtend(){
        List<UserExtend> userExtends = userService.findAllUserExtend();
        return MessageUtil.success("查询成功！",userExtends);
    }
    @ApiOperation(value="通过ID查询用户信息",notes = "级联查询")
    @GetMapping("findUserExtendById")
    public Message findUserExtendById(Long id){
        UserExtend userExtend = userService.findUserExtendById(id);
        return MessageUtil.success("查询成功！",userExtend);
    }
    @ApiOperation(value="通过ID删除用户信息")
    @GetMapping("deleteUserById")
    public Message deleteUserById(Long id){
        userService.deleteUserById(id);
        return MessageUtil.success("删除成功！");
    }
    @ApiOperation(value="为用户授权")
    @PostMapping("setRoles")
    public Message setRoles(UserRoleVM userRoleVM){
        userService.setRoles(userRoleVM);
        return MessageUtil.success("授权成功！");
    }

}
