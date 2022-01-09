package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;
import java.util.HashSet;
import java.util.List;

@Component
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    @Transactional
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    @Transactional
    public List<Role> listRoles() {
        return roleDao.listRoles();
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    @Transactional
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        return roleDao.getSetOfRoles(roleNames);
    }
}