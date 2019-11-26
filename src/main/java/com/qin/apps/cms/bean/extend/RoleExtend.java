package com.qin.apps.cms.bean.extend;

import com.qin.apps.cms.bean.Privilege;
import com.qin.apps.cms.bean.Role;

import java.util.List;

public class RoleExtend extends Role {
    List<Privilege> privileges;

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
