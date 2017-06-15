package com.dawn.library.book.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.dawn.library.type.bean.Type;

@Entity
// 此实体类映射的数据表
@Table(name = "TBL_BOOK")
public class Book {
	private Integer id;
	private String no;
	private String name;
	private Type type;
	private String author;
	private double price;
	private int amount;
	private String publisher;
	private String remark;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "SEQ_BOOK")
	@Column(name = "BOOK_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "BOOK_NO")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@Column(name = "BOOK_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Author")
	public String getAuthor() {
		return author;
	}

	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "PRICE")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "AMOUNT")
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name = "PUBLISHER")
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
