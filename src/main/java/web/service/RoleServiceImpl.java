package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public List<Role> getAllRolesByName() {
        return roleDao.getAllRolesByName();
    }

    @Override
    @Transactional
    public List<Role> getRolesByName(String[] role) {
        return roleDao.getRolesByName(role);
    }

}
