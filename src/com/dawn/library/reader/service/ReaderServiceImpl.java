package com.dawn.library.reader.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dawn.library.reader.bean.Reader;
import com.dawn.library.reader.dao.ReaderDao;

@Service
public class ReaderServiceImpl implements ReaderService {

	@Resource
	private ReaderDao readerDao;

	@Override
	public void addReader(Reader reader) {

		readerDao.add(reader);
	}

	@Override
	public void updateReader(Reader reader) {

		readerDao.update(reader);
	}

	@Override
	public void deleteReader(Reader reader) {

		readerDao.delete(reader);
	}

	@Override
	public Reader findUserById(Integer id) {
		return readerDao.findById(id);
	}

	@Override
	public List<Reader> findAllReader() {

		return readerDao.findAll();
	}

	// getter & setter
	public ReaderDao getReaderDao() {
		return readerDao;
	}

	public void setReaderDao(ReaderDao readerDao) {
		this.readerDao = readerDao;
	}

	@Override
	public Reader findReaderByNo(String no) {
		return readerDao.findByNo(no);
	}

}
