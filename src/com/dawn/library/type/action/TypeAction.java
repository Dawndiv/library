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

// ������������ע��Action��
@Controller
// �������μ�struts.xml�ļ���
@ParentPackage("ssh")
@Results({ @Result (name="delete",location="/delType.jsp")})
public class TypeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// ������Դ
	@Resource
	private TypeService typeService;
	// �ö������ڽ��������ڱ���������
	private Type type;
	private List<Type> list;

	// ����Action
	@Action("addType")
	public String add() {
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
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
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
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
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
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