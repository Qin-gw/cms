package com.qin.apps.cms.service;

import com.qin.apps.cms.bean.Role;
import com.qin.apps.cms.bean.extend.RoleExtend;

import java.util.List;

public interface IRoleService {
    List<Role> findAllRole();
    List<RoleExtend> findAllRoleExtend();
    void saveOrUpdateRole(Role role);
    void deleteRoleById(long id);
    void authorization(long roleId,List<Long> privilegeIds);
}
