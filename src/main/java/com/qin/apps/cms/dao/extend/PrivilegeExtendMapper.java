package com.qin.apps.cms.dao.extend;

import com.qin.apps.cms.bean.Privilege;
import com.qin.apps.cms.dao.PrivilegeMapper;
import com.qin.apps.cms.vm.PrivilegeTree;

import java.util.List;

public interface PrivilegeExtendMapper extends PrivilegeMapper {
    List<PrivilegeTree> findAllPrivilegeTree();
    List<Privilege> findPrivilegeByUserId(long userId);
}
