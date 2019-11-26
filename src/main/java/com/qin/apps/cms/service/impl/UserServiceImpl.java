package com.qin.apps.cms.service.impl;

import com.qin.apps.cms.bean.User;
import com.qin.apps.cms.bean.UserExample;
import com.qin.apps.cms.bean.UserRole;
import com.qin.apps.cms.bean.UserRoleExample;
import com.qin.apps.cms.bean.extend.UserExtend;
import com.qin.apps.cms.dao.UserRoleMapper;
import com.qin.apps.cms.dao.extend.UserExtendMapper;
import com.qin.apps.cms.service.IUserService;
import com.qin.apps.cms.utils.CustomerException;
import com.qin.apps.cms.utils.MD5Util;
import com.qin.apps.cms.vm.UserRoleVM;
import com.qin.apps.cms.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserExtendMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public void saveOrUpdateUser(User user) {
        if (user.getId()!=null){
            userMapper.updateByPrimaryKey(user);
        }else {
            UserExample example = new UserExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername());
            List<User> users = userMapper.selectByExample(example);
            if (users.size()>0){
                throw  new CustomerException("用户名已存在");
            }
            user.setRegisterTime(new Date().getTime());
            user.setStatus(UserExtend.STATUS_NORMAL);
            userMapper.insert(user);
        }
    }
    @Override
    public List<User> findUserByName(String name) throws CustomerException{
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(name);
        List<User> users = userMapper.selectByExample(example);
        if (users.size()>0){
            throw  new CustomerException("用户名已存在");
        }
        return users;
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public List<UserExtend> findAllUserExtend() {
        return userMapper.findAllUserExtend();
    }

    @Override
    public UserExtend findUserExtendById(Long id) {
        return userMapper.findUserExtendById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void setRoles(UserRoleVM userRoleVM) {
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(userRoleVM.getId());
        userRoleMapper.deleteByExample(example);
        for (Long id:userRoleVM.getRoles()) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userRoleVM.getId());
            userRole.setRoleId(id);
            userRoleMapper.insert(userRole);
        }
    }

    @Override
    public User login(UserVM userVM) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(userVM.getUsername());
        List<User> list = userMapper.selectByExample(example);
        if(list.size()<=0){
            throw new CustomerException("该用户不存在");
        }
        User user = list.get(0);
        if(!user.getPassword().equals(userVM.getPassword())){
            throw new CustomerException("密码不匹配");
        }
        return user;
    }
}
