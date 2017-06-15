package com.dawn.library.reader.service;

import java.util.List;

import com.dawn.library.reader.bean.Reader;

public interface ReaderService {
	void addReader(Reader reader);

	void updateReader(Reader reader);

	void deleteReader(Reader reader);

	Reader findUserById(Integer id);

	Reader findReaderByNo(String no);

	List<Reader> findAllReader();
}
