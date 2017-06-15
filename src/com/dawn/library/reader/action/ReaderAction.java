package com.dawn.library.reader.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.dawn.library.reader.bean.Reader;
import com.dawn.library.reader.service.ReaderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
// 父包（参见struts.xml文件）
@ParentPackage("ssh")
@Results({ @Result(name = "add", location = "/addReader.jsp"),
		@Result(name = "toAdd", location = "/addResultReader.jsp"),
		@Result(name = "update", location = "/updateResultReader.jsp"),
		@Result(name = "update_result", location = "/updateResult2Reader.jsp") })
public class ReaderAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private ReaderService readerService;
	private Reader reader;
	private String no;
	private List<Reader> list;

	@Action("toAddReader")
	public String toAdd() {

		try {
			list = readerService.findAllReader();
			return "add";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("addReader")
	public String add() {

		try {
			readerService.addReader(reader);
			return "toAdd";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 删除读者
	@Action("delReader")
	public String del() {
		try {
			Reader r = readerService.findReaderByNo(no);
			if (r == null) {
				return "failure";
			} else {
				readerService.deleteReader(r);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 修改读者
	@Action("toUpdateReader")
	public String toUpdate() {
		try {
			reader = readerService.findReaderByNo(no);
			if (reader == null) {
				return "failure";
			} else {
				readerService.updateReader(reader);
				return "update";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("updateReader")
	public String update() {
		try {
			String oper;
			ActionContext ctx = ActionContext.getContext();
			oper = (String) ctx.getSession().get("user_name");
			reader.setOper(oper);
			readerService.updateReader(reader);
			return "update_result";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public ReaderService getReaderService() {
		return readerService;
	}

	public void setReaderService(ReaderService readerService) {
		this.readerService = readerService;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public List<Reader> getList() {
		return list;
	}

	public void setList(List<Reader> list) {
		this.list = list;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
}
