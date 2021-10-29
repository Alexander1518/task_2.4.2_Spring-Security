package web.dao;

import web.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<Role> listRoles();
    Set<Role> getRoleById(List<Long> idRole);
}