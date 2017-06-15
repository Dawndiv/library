package com.dawn.library.reader.dao;

import java.util.List;

import com.dawn.library.reader.bean.Reader;

public interface ReaderDao {

	void add(Reader reader);

	void update(Reader reader);

	void delete(Reader reader);

	Reader findById(Integer id);

	Reader findByNo(String no);

	List<Reader> findAll();
}
