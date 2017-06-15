package com.dawn.library.book.service;

import java.util.List;

import com.dawn.library.book.bean.Book;

public interface BookService {
	
	void addBook(Book book);

	void updateBook(Book book);

	void deleteBook(Book book);

	Book findBookById(Integer id);

	Book findBookByNo(String no);

	List<Book> findAllBook();

	List<Book> findAllBook(int pageNo, int pageSize);
	
	List<Book> findAllBook(Book condition, int pageNo, int pageSize);

	int getTotalPages(int pageSize);
}
