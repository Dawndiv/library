package com.dawn.library.book.action;

import java.util.List;

import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.dawn.library.book.bean.Book;
import com.dawn.library.book.service.BookService;
import com.dawn.library.type.bean.Type;
import com.dawn.library.type.service.TypeService;
import com.opensymphony.xwork2.ActionSupport;

// 控制器，用于注解Action类
@Controller
// 父包（参见struts.xml文件）
@ParentPackage("ssh")
@Results({ @Result(name = "Add", location = "/addBook.jsp"),
		@Result(name = "update", location = "/updateResultBook.jsp"),
		@Result(name = "list", location = "/queryResultBook.jsp"),
		@Result(name = "toList2", location = "/query1Book.jsp"),
		@Result(name = "list2", location = "/queryResult2Book.jsp") })
public class BookAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private BookService bookService;
	@Resource
	private TypeService typeService;
	private Book book;
	private List<Type> typeList;
	private List<Book> bookList;
	private String no;
	private int pageNo = 1;
	private int pageSize = 15;
	private int totalPages = 0;

	@Action("toAddBook")
	public String toAdd() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			typeList = typeService.findAll();
			return "Add";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("addBook")
	public String add() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			bookService.addBook(book);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("toUpdateBook")
	public String toUpdate() {
		try {
			book = bookService.findBookByNo(no);
			typeList = typeService.findAll();
			if (book == null) {
				return "failure";
			} else {
				return "update";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("updateBook")
	public String update() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			bookService.updateBook(book);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("delBook")
	public String del() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			Book b = bookService.findBookByNo(no);
			if (b == null) {
				return "failure";
			} else {
				bookService.deleteBook(b);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("listBook")
	public String list() {
		try {
			//bookList = bookService.findAllBook();
			bookList = bookService.findAllBook(pageNo, pageSize);
			totalPages = bookService.getTotalPages(pageSize);
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
		@Action("toListBook2")
		public String toList2() {
			try {
				typeList = typeService.findAll();
				return "toList2";
			} catch (Exception e) {
				e.printStackTrace();
				return "failure";
			}
		}

		@Action("listBook2")
		public String list2() {
			try {
				bookList = bookService.findAllBook(book, pageNo, pageSize);
				totalPages = bookService.getTotalPages(pageSize);
				return "list2";
			} catch (Exception e) {
				e.printStackTrace();
				return "failure";
			}
	}

	// getter & setter

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public List<Type> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
