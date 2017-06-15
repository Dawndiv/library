package com.dawn.library.user.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.dawn.library.user.bean.User;
import com.dawn.library.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

// 控制器，用于注解Action类
@Controller
// 父包（参见struts.xml文件）
@ParentPackage("ssh")
@Results({ @Result(name = "update", location = "/update2User.jsp"),
		@Result(name = "adminIndex", location = "/admin_index.jsp"),
		@Result(name = "adminLogin", location = "/admin_login.jsp") })
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	private User user;
	private String no;
	private List<User> list;
	private String msg;

	// 定义Action
	@Action("addUser")
	public String add() {
		try {
			userService.addUser(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("delUser")
	public String del() {
		try {
			User u = userService.findUserByNo(no);
			if (u == null) {
				return "failure";
			} else {
				userService.deleteUser(u);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("toUpdateUser")
	public String toUpdate() {
		try {
			user = userService.findUserByNo(no);
			if (user == null) {
				return "failure";
			} else {
				userService.updateUser(user);
				return "update";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("updateUser")
	public String update() {
		try {
			userService.updateUser(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("login")
	public String login() {
		try {
			if (userService.validate(user)) {
				ActionContext ctx = ActionContext.getContext();
				ctx.getSession().put("user_name", user.getName());
				return "adminIndex";
			} else {
				msg = "用户名或密码错误！";
				return "adminLogin";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// getter & setter

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
