package com.dawn.library.borrow.dao;

import java.util.List;

import com.dawn.library.borrow.bean.Borrow;
import com.dawn.library.borrow.bean.BorrowResult;

public interface BorrowDao {

	void add(Borrow borrow);

	void update(Borrow borrow);

	void delete(Borrow borrow);

	Borrow findById(Integer id);

	Borrow findByBookNoAndReaderNo(String bookNo, String readerNo);

	BorrowResult findResultByBookNoAndReaderNo(String bookNo, String readerNo);

	List<BorrowResult> findResultByBookNo(String bookNo);

	List<BorrowResult> findResultByReaderNo(String readerNo);
}
