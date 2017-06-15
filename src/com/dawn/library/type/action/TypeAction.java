package com.dawn.library.type.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.dawn.library.type.bean.Type;
import com.dawn.library.type.service.TypeService;
import com.opensymphony.xwork2.ActionSupport;

// 控制器，用于注解Action类
@Controller
// 父包（参见struts.xml文件）
@ParentPackage("ssh")
@Results({ @Result (name="delete",location="/delType.jsp")})
public class TypeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 依赖资源
	@Resource
	private TypeService typeService;
	// 该对象用于接收来自于表单的数据
	private Type type;
	private List<Type> list;

	// 定义Action
	@Action("addType")
	public String add() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			typeService.addType(type);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	@Action("toDeleteType")
	public String toDelete() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			list = typeService.findAll();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	
	@Action("deleteType")
	public String delete() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			typeService.deleteType(type);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	

	// getter & setter

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Type> getList() {
		return list;
	}

	
	
}
