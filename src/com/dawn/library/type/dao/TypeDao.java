package com.dawn.library.type.dao;
import java.util.List;

import com.dawn.library.type.bean.Type;

public interface TypeDao {
	void add(Type type);

	void delete(Type type);

	Type findById(Integer id);

	List<Type> findAll();

 
	

	
}
