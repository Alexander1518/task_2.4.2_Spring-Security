package web.service;

import web.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface RoleService {
    void addRole(Role role);
    List<Role> listRoles();
    Role getRoleByName(String name);
    HashSet<Role> getSetOfRoles(String[] roleNames);
}
