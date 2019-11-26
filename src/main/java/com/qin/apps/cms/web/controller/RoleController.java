package com.qin.apps.cms.web.controller;

import com.qin.apps.cms.bean.Role;
import com.qin.apps.cms.bean.RolePrivilege;
import com.qin.apps.cms.bean.extend.RoleExtend;
import com.qin.apps.cms.service.IRoleService;
import com.qin.apps.cms.utils.Message;
import com.qin.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Api(description ="角色相关接口")
@RestController
@RequestMapping("/RoleController")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @ApiOperation("添加或修改角色")
    @PostMapping("saveOrUpdateRole")
    public Message saveOrUpdateRole(Role role){
        roleService.saveOrUpdateRole(role);
        return MessageUtil.success("更新成功！");
    }
    @ApiOperation("删除角色")
    @GetMapping("deleteRoleById")
    public Message deleteRolePrivilege(Long id){
        roleService.deleteRoleById(id);
        return MessageUtil.success("删除成功！");
    }
    @ApiOperation("查询所有角色")
    @GetMapping("findAllRole")
    public Message findAllRole(){
        List<Role> roles = roleService.findAllRole();
        return MessageUtil.success("查询成功！",roles);
    }
    @ApiOperation(value="查询所有角色",notes = "级联查询权限表")
    @GetMapping("findAllRoleExtend")
    public Message findAllRoleExtend(){
        List<RoleExtend> roleExtends = roleService.findAllRoleExtend();
        return MessageUtil.success("查询成功！",roleExtends);
    }
    @ApiOperation(value = "为角色授权")
    @PostMapping(value = "authorization")
    public Message authorization(long id,Long[] privileges){
        List<Long> ids = Arrays.asList(privileges);
        roleService.authorization(id,ids);
        return MessageUtil.success("授权成功");
    }
}
