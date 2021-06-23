package cn.controller.hsj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;

import cn.entity.User;
import cn.service.hsj.RoleService;
import cn.service.hsj.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
//@RequestParam(value="pageIndex",required=true,defaultValue="2") Integer pageId

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@GetMapping(value="/show1/{pageIndex}",produces="application/json;charset=utf-8")
	@ResponseBody
	public String show(@RequestParam(value="queryNickName",required=false) String userNickName,
					   @RequestParam(value="queryTel",required=false) String tel,
					   @RequestParam(value="queryRole",required=false) Integer roleId,
					   @PathVariable(value="pageIndex") Integer pageId)throws Exception {

		PageInfo<User> pageInfo = userService.findUserByCondition(userNickName, tel, roleId, pageId);
		String json = JSONObject.toJSONString(pageInfo);
		return json;
	}
/*
	@GetMapping(value = "/show")
	public String show(@RequestParam(value="queryNickName",required=false) String userNickName,
					   @RequestParam(value="queryTel",required=false) String tel,
					   @RequestParam(value="queryRole",required=false) Integer roleId,
					   @RequestParam(value="pageId",required=true,defaultValue="1") Integer pageId,
					   Model model)throws Exception {
		
		PageBean<User> pageBean = userService.searchUserByCondition(userNickName,tel,pageId);

		model.addAttribute("pageBean", pageBean);

		return "user/userlist";
	}
	
	@RequestMapping("/addBefore")
	public String addUserBefore(Model model)throws Exception{
		return "user/useradd";
	}
	
	@RequestMapping("/add")
	public String addUser(@ModelAttribute("newUser") @Valid User user,
						  BindingResult bindingResult)throws Exception{

		//model.addAttribute("newUser", user);
		//如果服务端校验不通过则回到添加页面
		if (bindingResult.hasErrors()) {
			return "user/useradd";
		}

		//保存用户
		boolean ok = userService.addUser(user);
		
		if(ok){
			return "redirect:show";
		}else{
			return "redirect:addBefore";
		}
	}
	
	@RequestMapping("/exists1")
	@ResponseBody
	public String existsUserNickName(@RequestParam String userNickName){
		User user = userService.findUserByNickName(userNickName);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(user!=null){
			map.put("exist", true);
		}else{
			map.put("exist", false);
		}
		String json = JSONObject.toJSONString(map);
		return json;
	}

	@RequestMapping("/exists2")
	@ResponseBody
	public String existsTel(@RequestParam String tel){
		User user = userService.findUserByTel(tel);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(user!=null){
			map.put("exist", true);
		}else{
			map.put("exist", false);
		}
		String json = JSONObject.toJSONString(map);
		return json;
	}

	@RequestMapping("/exists3")
	@ResponseBody
	public String existsUserNickName1(@RequestParam String userNickName,
									  @RequestParam Integer userId){

		User user = userService.findUserByNickName(userNickName);

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(user==null || user.getUserId()==userId){
			map.put("exist", false);
		}else{
			map.put("exist", true);
		}
		String json = JSONObject.toJSONString(map);
		return json;
	}

	@RequestMapping("/exists4")
	@ResponseBody
	public String existsTel1(@RequestParam String tel,
							 @RequestParam Integer userId){
		User user = userService.findUserByTel(tel);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(user==null || user.getUserId()==userId){
			map.put("exist", false);
		}else{
			map.put("exist", true);
		}
		String json = JSONObject.toJSONString(map);
		return json;
	}
	
	@RequestMapping(value="/view",produces="application/json;charset=utf-8")
	@ResponseBody
	public String showUser(@RequestParam(value="userId") Integer userId){
		User user = userService.findUserById(userId);
		String json = JSONObject.toJSONString(user);
		return json;
	}
	
	@RequestMapping("/remove")
	@ResponseBody
	public Map<String, Object> removeUser(@RequestParam(value="userId") Integer userId){
		boolean success =  userService.removeUser(userId);
		Map<String, Object> map = new HashMap<>();
		map.put("success", success);
		return map;
	}
	
	@RequestMapping("/modifyBefore")
	public String modifyUserBefore(@RequestParam(value="userId") Integer userId,Model model)throws Exception{
		User user1 = userService.findUserById(userId);
		model.addAttribute("user1", user1);
		
		*//*
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birthday = sdf.format(user1.getBirthday());
		model.addAttribute("birthday", birthday);
		*//*
		
		return "user/usermodify";
	}
	
	@RequestMapping("/modify")
	public String modifyUser(@ModelAttribute("user1") @Valid User user,
							 BindingResult bindingResult, 
							 HttpSession session){
		//如果服务端校验不通过则回到添加页面
		if (bindingResult.hasErrors()) {
			//return "user/usermodify";
			return "redirect:modifyBefore?userId="+user.getUserId();
		}

		//修改用户
		boolean ok = userService.modifyUser(user);
		if(ok){
			return "redirect:show";
		}else{
			//return "redirect:show";
			return "user/modifyBefore";
		}	
	}
	*/
}
