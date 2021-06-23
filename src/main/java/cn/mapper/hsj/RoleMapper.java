package cn.mapper.hsj;

import cn.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    public List<Role> selectRoleAll();
    public Role selectRoleById(Integer roleId);

}
