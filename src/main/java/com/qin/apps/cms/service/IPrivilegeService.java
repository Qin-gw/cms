package com.qin.apps.cms.service;

import com.qin.apps.cms.bean.Privilege;
import com.qin.apps.cms.vm.PrivilegeTree;

import java.util.List;

public interface IPrivilegeService {
    void saveOrUpdatePrivilege(Privilege privilege);
    void deletePrivilege(Long id);
    void deleteBatchPrivilege(List<Long> ids);
    List<Privilege> fiandAllPrivilege();
    List<Privilege> fiandPrivilegeByParentId(Long parentId);
    List<PrivilegeTree> findAllPrivilegeTree();
    List<Privilege> fiandPrivilegeByUserId(Long userId);
}
