package com.dawn.library.borrow.service;

import java.util.List;

import com.dawn.library.borrow.bean.Borrow;
import com.dawn.library.borrow.bean.BorrowResult;

public interface BorrowService {

	void addBorrow(Borrow borrow);

	void addReturn(Borrow borrow);

	void addRenew(Borrow oldBorrow, Borrow newBorrow);

	Borrow findBorrowByBookNoAndReaderNo(String bookNo, String readerNo);

	BorrowResult findBorrowResultByBookNoAndReaderNo(String bookNo,
			String readerNo);

	List<BorrowResult> findBorrowResultByBookNo(String bookNo);

	List<BorrowResult> findBorrowResultByReaderNo(String readerNo);
}
