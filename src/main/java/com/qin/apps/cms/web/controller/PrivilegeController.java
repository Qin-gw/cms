package com.qin.apps.cms.web.controller;

import com.qin.apps.cms.bean.Privilege;
import com.qin.apps.cms.service.IPrivilegeService;
import com.qin.apps.cms.utils.Message;
import com.qin.apps.cms.utils.MessageUtil;
import com.qin.apps.cms.vm.PrivilegeTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description ="权限相关接口")
@RestController
@RequestMapping("/PrivilegeController")
public class PrivilegeController {
    @Autowired
    private IPrivilegeService privilegeService;
    @ApiOperation("添加或更改权限")
    @PostMapping("saveOrUpdatePrivilege")
    public Message saveOrUpdatePrivilege(Privilege privilege){
        privilegeService.saveOrUpdatePrivilege(privilege);
        return MessageUtil.success("更新成功！");
    }
    @ApiOperation("删除权限")
    @GetMapping("deletePrivilege")
    public Message deletePrivilege(Long id){
        System.out.println(id);
        privilegeService.deletePrivilege(id);
        return MessageUtil.success("删除成功！");
    }
    @ApiOperation("批量删除权限")
    @PostMapping("deleteBatchPrivilege")
    public Message deleteBatchPrivilege(@RequestBody List<Long> ids){
        privilegeService.deleteBatchPrivilege(ids);
        return MessageUtil.success("删除成功！");
    }
    @ApiOperation("查询权限")
    @GetMapping("findAllPrivilege")
    public Message findAllPrivilege(){
        List<Privilege> privileges = privilegeService.fiandAllPrivilege();
        return MessageUtil.success("查询成功！",privileges);
    }
    @ApiOperation("通过parentId查询权限")
    @GetMapping("findPrivilegeByParentId")
    public Message findPrivilegeByParentId(Long parentId){
        List<Privilege> privileges = privilegeService.fiandPrivilegeByParentId(parentId);
        return MessageUtil.success("查询成功！",privileges);
    }
    @ApiOperation("查询权限数树")
    @GetMapping("findAllPrivilegeTree")
    public Message findAllPrivilegeTree(){
        List<PrivilegeTree> privilegeTree = privilegeService.findAllPrivilegeTree();
        return MessageUtil.success("查询成功！",privilegeTree);
    }
    @ApiOperation("通过用户Id查询用户权限")
    @GetMapping("fiandPrivilegeByUserId")
    public Message fiandPrivilegeByUserId(Long userId){
        List<Privilege> privileges = privilegeService.fiandPrivilegeByUserId(userId);
        return MessageUtil.success("查询成功！",privileges);
    }

}
