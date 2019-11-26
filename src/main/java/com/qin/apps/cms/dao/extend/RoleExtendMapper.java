package com.qin.apps.cms.dao.extend;

import com.qin.apps.cms.bean.Role;
import com.qin.apps.cms.bean.extend.RoleExtend;
import com.qin.apps.cms.dao.RoleMapper;

import java.util.List;

public interface RoleExtendMapper extends RoleMapper {
    Role findRoletByUserId(Long id);
    List<RoleExtend> findAllRoleExtend();
}
