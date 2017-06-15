package com.dawn.library.user.service;

import java.util.List;

import com.dawn.library.user.bean.User;

public interface UserService {

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	User findUserById(Integer id);

	User findUserByNo(String no);

	List<User> findAllUser();

	boolean validate(User user);
}
