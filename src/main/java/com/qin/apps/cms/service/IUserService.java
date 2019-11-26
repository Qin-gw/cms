package com.qin.apps.cms.service;

import com.qin.apps.cms.bean.User;
import com.qin.apps.cms.bean.extend.UserExtend;
import com.qin.apps.cms.utils.CustomerException;
import com.qin.apps.cms.vm.UserRoleVM;
import com.qin.apps.cms.vm.UserVM;

import java.util.List;

public interface IUserService {
    void saveOrUpdateUser(User user);
    List<User> findUserByName(String name)throws CustomerException;
    List<User> findAllUser();
    List<UserExtend> findAllUserExtend();
    UserExtend findUserExtendById(Long id);
    void deleteUserById(Long id);
    void setRoles(UserRoleVM userRoleVM);
    User login(UserVM userVM);
}
