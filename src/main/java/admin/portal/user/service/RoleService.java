package admin.portal.user.service;

import admin.portal.user.entities.Role;
import admin.portal.user.enums.RoleType;

import java.util.List;

public interface RoleService {

    void initialise();
    Role find(RoleType roleType);
    List<Role> findAll();
}
