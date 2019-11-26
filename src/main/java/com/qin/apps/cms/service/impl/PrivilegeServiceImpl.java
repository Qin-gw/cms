package com.qin.apps.cms.service.impl;

import com.qin.apps.cms.bean.ArticleExample;
import com.qin.apps.cms.bean.Privilege;
import com.qin.apps.cms.bean.PrivilegeExample;
import com.qin.apps.cms.dao.ArticleMapper;
import com.qin.apps.cms.dao.PrivilegeMapper;
import com.qin.apps.cms.dao.extend.PrivilegeExtendMapper;
import com.qin.apps.cms.service.IPrivilegeService;
import com.qin.apps.cms.vm.PrivilegeTree;
import io.swagger.annotations.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrivilegeServiceImpl implements IPrivilegeService {
    @Autowired
    private PrivilegeExtendMapper privilegeMapper;
    @Override
    public void saveOrUpdatePrivilege(Privilege privilege) {
        if (privilege.getId()!=null){
            privilegeMapper.updateByPrimaryKey(privilege);
        }else{
            privilegeMapper.insert(privilege);
        }
    }
    @Override
    public void deletePrivilege(Long id) {
        privilegeMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void deleteBatchPrivilege(List<Long> ids) {
        for (Long id:ids) {
            this.deletePrivilege(id);
        }
    }
    @Override
    public List<Privilege> fiandAllPrivilege() {
        return privilegeMapper.selectByExample(new PrivilegeExample());
    }

    @Override
    public List<Privilege> fiandPrivilegeByParentId(Long parentId) {
        PrivilegeExample example = new PrivilegeExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        return privilegeMapper.selectByExample(example);
    }

    @Override
    public List<PrivilegeTree> findAllPrivilegeTree() {
        return privilegeMapper.findAllPrivilegeTree();
    }

    @Override
    public List<Privilege> fiandPrivilegeByUserId(Long userId) {
        return privilegeMapper.findPrivilegeByUserId(userId);
    }
}
