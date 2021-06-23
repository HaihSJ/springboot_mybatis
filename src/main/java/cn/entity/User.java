package cn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer userId;			//用户id
    private String userNickName;	//用户名
    private String password;		//用户密码
    private String userRealName;	//用户真实姓名
    private String sex;				//用户性别
    private String tel;				//用户电话
    private String email;			//用户邮箱
    private String userImg;			//用户头像图片
    private Integer roleId;         //用户角色id

    private Role role;
}
