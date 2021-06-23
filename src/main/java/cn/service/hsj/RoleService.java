package cn.service.hsj;

import cn.entity.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findRoleAll();
    public Role findRoleById(Integer roleId);

}
