package cn.service.hsj;

import cn.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

    public PageInfo<User> findUserByCondition(String userNickName, String tel, Integer roleId, Integer pageId);

    public boolean addUser(User user);

    public boolean removeUser(Integer userId);

    public boolean modifyUser(User user);

    public User findUserByNickName(String userNickName);

    public User findUserByTel(String tel);

    public User findUserById(Integer userId);

}
