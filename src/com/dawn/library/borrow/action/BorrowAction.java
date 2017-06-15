package com.dawn.library.borrow.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

import com.dawn.library.borrow.bean.Borrow;
import com.dawn.library.borrow.bean.BorrowResult;
import com.dawn.library.borrow.service.BorrowService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

// 控制器，用于注解Action类
@Controller
// 父包（参见struts.xml文件）
@ParentPackage("ssh")
@Results({ @Result(name = "addResultBorrow", location = "/addResultBorrow.jsp"),
		@Result(name = "returnResult1", location = "/returnResult1Borrow.jsp"),
		@Result(name = "returnResult2", location = "/returnResult2Borrow.jsp"),
		@Result(name = "renewResult1", location = "/renewResult1Borrow.jsp"),
		@Result(name = "renewResult2", location = "/renewResult2Borrow.jsp"),
		@Result(name = "queryResult", location = "/queryResultBorrow.jsp") })
public class BorrowAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Resource
	private BorrowService borrowService;
	private Borrow borrow;
	private BorrowResult br;
	private List<BorrowResult> brList;

	@Action("addBorrow")
	public String addBorrow() {
		try {
			borrow.setBorrowDate(new Date());
			String oper;
			ActionContext ctx = ActionContext.getContext();
			oper = (String) ctx.getSession().get("user_name");
			borrow.setOper(oper);
			borrowService.addBorrow(borrow);
			br = borrowService.findBorrowResultByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());
			return "addResultBorrow";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("toAddReturn")
	public String toAddReturn() {
		try {
			brList = borrowService.findBorrowResultByBookNo(borrow.getBookNo());
			return "returnResult1";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("addReturn")
	public String addReturn() {
		try {
			String oper;
			ActionContext ctx = ActionContext.getContext();
			oper = (String) ctx.getSession().get("user_name");
			borrow.setOper(oper);
			br = borrowService.findBorrowResultByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());
			br.setReturnDate(new Date());
			borrow = borrowService.findBorrowByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());
			borrow.setReturnDate(new Date());
			borrowService.addReturn(borrow);
			return "returnResult2";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("toAddRenew")
	public String toAddRenew() {
		try {
			brList = borrowService.findBorrowResultByBookNo(borrow.getBookNo());
			return "renewResult1";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("addRenew")
	public String addRenew() {
		try {
			Borrow oldBorrow = borrowService.findBorrowByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());
			Borrow newBorrow = new Borrow();
			BeanUtils.copyProperties(oldBorrow, newBorrow);
			oldBorrow.setReturnDate(new Date());
			newBorrow.setBorrowDate(new Date());
			String oper;
			ActionContext ctx = ActionContext.getContext();
			oper = (String) ctx.getSession().get("user_name");
			newBorrow.setOper(oper);
			borrowService.addRenew(oldBorrow, newBorrow);
			br = borrowService.findBorrowResultByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());
			return "renewResult2";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("listBorrow")
	public String listBorrow() {
		try {
			brList = borrowService.findBorrowResultByReaderNo(borrow
					.getReaderNo());
			return "queryResult";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// getter & setter

	public BorrowService getBorrowService() {
		return borrowService;
	}

	public void setBorrowService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}

	public BorrowResult getBr() {
		return br;
	}

	public void setBr(BorrowResult br) {
		this.br = br;
	}

	public List<BorrowResult> getBrList() {
		return brList;
	}

	public void setBrList(List<BorrowResult> brList) {
		this.brList = brList;
	}
}
