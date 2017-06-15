package com.dawn.library.type.service;

import java.util.List;

import com.dawn.library.type.bean.Type;

public interface TypeService {
	void addType(Type type);
	
	void deleteType(Type type);

	Type findById(Integer id);

	List<Type> findAll();

}
