package com.dawn.library.user.dao;

import java.util.List;

import com.dawn.library.user.bean.User;

public interface UserDao {

	void add(User user);

	void update(User user);

	void delete(User user);

	User findById(Integer id);

	User findByNo(String no);

	List<User> findAll();

	User findByName(String name);
}
