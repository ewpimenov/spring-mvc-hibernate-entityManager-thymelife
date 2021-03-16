package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getAllRolesByName();

    List<Role> getRolesByName(String[] role);
}
