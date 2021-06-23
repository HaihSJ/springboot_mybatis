package cn.mapper.hsj;

import cn.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public int insertUser(User user);

    public int deleteUser(Integer userId);

    public int updateUser(User user);

/*    public int countRowsByCondition(@Param("userNickName") String userNickName,
                                    @Param("tel") String tel,
                                    @Param("roleId") Integer roleId);*/

/*    public List<User> selectUserByCondition(@Param("userNickName") String userNickName,
                                            @Param("tel") String tel,
                                            @Param("pageId") Integer pageId,
                                            @Param("pageSize") Integer pageSize);*/

    public List<User> selectUserByCondition(@Param("userNickName") String userNickName,
                                            @Param("tel") String tel,
                                            @Param("roleId") Integer roleId);

    public User selectUserByNickName(String userNickName);

    public User selectUserByTel(String tel);

    public User selectUserById(Integer userId);
}
