package com.qin.apps.cms.service.impl;

import com.qin.apps.cms.bean.Role;
import com.qin.apps.cms.bean.RoleExample;
import com.qin.apps.cms.bean.RolePrivilege;
import com.qin.apps.cms.bean.RolePrivilegeExample;
import com.qin.apps.cms.bean.extend.RoleExtend;
import com.qin.apps.cms.dao.RolePrivilegeMapper;
import com.qin.apps.cms.dao.extend.RoleExtendMapper;
import com.qin.apps.cms.service.IRoleService;
import com.qin.apps.cms.utils.CustomerException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleExtendMapper roleExtendMapper;
    @Autowired
    private RolePrivilegeMapper rolePrivilegeMapper;
    @Override
    public List<Role> findAllRole() {
        return roleExtendMapper.selectByExample(new RoleExample());
    }

    @Override
    public List<RoleExtend> findAllRoleExtend() {
        return roleExtendMapper.findAllRoleExtend();
    }

    @Override
    public void saveOrUpdateRole(Role role) {
        if(role.getId()!=null){
            roleExtendMapper.updateByPrimaryKey(role);
        }else {
            roleExtendMapper.insert(role);
        }
    }

    @Override
    public void deleteRoleById(long id) {
        Role role = roleExtendMapper.selectByPrimaryKey(id);
        if (role==null){
            throw new CustomerException("所要删除的角色不存在！");
        }
        roleExtendMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void authorization(long roleId, List<Long> privilegeIds) {
        // 根据roleid查询出所有的权限
        RolePrivilegeExample example = new RolePrivilegeExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<RolePrivilege> list = rolePrivilegeMapper.selectByExample(example);
        // 将list转换为privilegeIDs的集合
        List<Long> old_privilegeIds = new ArrayList<>();
        for(RolePrivilege rp : list){
            old_privilegeIds.add(rp.getPrivilegeId());
        }
        // 依次判断privilegeIds 是否存在old_privilegeIds，如果不在则插入
        for(long privilegeId : privilegeIds){
            if (!old_privilegeIds.contains(privilegeId)) {
                RolePrivilege rp = new RolePrivilege();
                rp.setRoleId(roleId);
                rp.setPrivilegeId(privilegeId);
                rolePrivilegeMapper.insert(rp);
            }
        }
        // 依次判断 是否存在old_privilegeIds 是否存在privilegeIds，如果不存在删除
        for(long privilegeId: old_privilegeIds){
            if(!privilegeIds.contains(privilegeId)){
                // 根据privilegeId 从桥表中删除
                example.clear();
                example.createCriteria()
                        .andRoleIdEqualTo(roleId)
                        .andPrivilegeIdEqualTo(privilegeId);
                rolePrivilegeMapper.deleteByExample(example);
            }
        }

    }

}
