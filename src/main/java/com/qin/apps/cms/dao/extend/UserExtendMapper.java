package com.qin.apps.cms.dao.extend;

import com.qin.apps.cms.bean.extend.UserExtend;
import com.qin.apps.cms.dao.UserMapper;

import java.util.List;

public interface UserExtendMapper extends UserMapper {
    UserExtend findUserExtendByUserName(String userName);
    List<UserExtend> findAllUserExtend();
    UserExtend findUserExtendById(Long id);
}
