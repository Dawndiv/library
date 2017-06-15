package com.dawn.library.type.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dawn.library.type.bean.Type;
import com.dawn.library.type.dao.TypeDao;

// 服务，用于注解业务逻辑层
@Service
public class TypeServiceImpl implements TypeService {
	// 依赖资源
	@Resource
	private TypeDao typeDao;

	@Override
	public void addType(Type type) {
		typeDao.add(type);
	}

	@Override
	public void deleteType(Type type) {
		typeDao.delete(type);
	}
	
	// getter & setter

	public TypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

	@Override
	public Type findById(Integer id) {
		// TODO Auto-generated method stub
		return typeDao.findById(id);
	}

	@Override
	public List<Type> findAll() {
		// TODO Auto-generated method stub
		return typeDao.findAll();
	}

}
