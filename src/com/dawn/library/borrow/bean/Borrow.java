package com.dawn.library.borrow.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="tbl_borrow")
@Entity
public class Borrow {
	private Integer borrowId;
	private String bookNo;
	private String readerNo;
	private Date borrowDate;
	private Date returnDate;
	private String oper;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	// 定义序列生成器，"generator"与上一行对应，并指定序列名称
	@SequenceGenerator(name = "generator", sequenceName = "SEQ_BORROW")
	// 此属性在数据表中的映射字段
	@Column(name="borrow_id")
	public Integer getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(Integer borrowId) {
		this.borrowId = borrowId;
	}
	@Column(name="book_no")
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	@Column(name="reader_no")
	public String getReaderNo() {
		return readerNo;
	}
	public void setReaderNo(String readerNo) {
		this.readerNo = readerNo;
	}
	@Column(name="borrow_date")
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	@Column(name="return_date")
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	@Column(name="oper")
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
}
