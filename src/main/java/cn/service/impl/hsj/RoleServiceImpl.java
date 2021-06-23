package cn.service.impl.hsj;

import cn.entity.Role;
import cn.mapper.hsj.RoleMapper;
import cn.service.hsj.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoleAll() {
        return roleMapper.selectRoleAll();
    }

    @Override
    public Role findRoleById(Integer roleId) {
        return roleMapper.selectRoleById(roleId);
    }
}
