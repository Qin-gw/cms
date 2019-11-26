package com.qin.apps.cms.bean.extend;

import com.qin.apps.cms.bean.Role;
import com.qin.apps.cms.bean.User;

import java.util.List;

public class UserExtend extends User {
    public static final String STATUS_NORMAL="正常";
    public static final String STATUS_FORBIDDEN="禁用";
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
