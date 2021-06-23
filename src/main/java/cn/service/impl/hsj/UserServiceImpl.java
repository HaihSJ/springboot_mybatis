package cn.service.impl.hsj;

import cn.entity.User;
import cn.mapper.hsj.RoleMapper;
import cn.mapper.hsj.UserMapper;
import cn.service.hsj.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findUserByCondition(String userNickName, String tel, Integer roleId, Integer pageId) {
        //开启自动分页功能
        PageHelper.startPage(pageId,5);
        List<User> userList = userMapper.selectUserByCondition(userNickName, tel, roleId);
        for (User user : userList) {
            user.setRole(roleMapper.selectRoleById(user.getRoleId()));
        }
        //将查询结果包装成分页对象
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        //返回分页对象
        return pageInfo;
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.insertUser(user)>0;
    }

    @Override
    public boolean removeUser(Integer userId) {
        return userMapper.deleteUser(userId)>0;
    }

    @Override
    public boolean modifyUser(User user) {
        return userMapper.updateUser(user)>0;
    }

    @Override
    public User findUserByNickName(String userNickName) {
        User user = userMapper.selectUserByNickName(userNickName);
        user.setRole(roleMapper.selectRoleById(user.getRoleId()));
        return user;
    }

    @Override
    public User findUserByTel(String tel) {
        User user = userMapper.selectUserByTel(tel);
        user.setRole(roleMapper.selectRoleById(user.getRoleId()));
        return user;
    }

    @Override
    public User findUserById(Integer userId) {
        User user = userMapper.selectUserById(userId);
        user.setRole(roleMapper.selectRoleById(user.getRoleId()));
        return user;
    }
}
