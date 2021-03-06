package com.dawn.library.type.dao;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dawn.library.type.bean.Type;

// 仓库，用于注解DAO类
@Repository
// DAO类通常继承自HibernateDaoSupport类
// HibernateDaoSupport类提供了大多数常用的数据操作
public class TypeDaoImpl extends HibernateDaoSupport implements TypeDao {
	// HibernateDaoSupport类依赖于SessionFactory
	// 需要提供set方法并加上依赖资源的注解
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void add(Type type) {
		this.getHibernateTemplate().save(type);
	}

	@Override
	public void delete(Type type) {
		this.getHibernateTemplate().delete(type);
	}



	
	@Override
	public Type findById(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Type.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> findAll() {
		return this.getHibernateTemplate().find("from Type");
	}
}
