package com.dawn.library.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dawn.library.user.bean.User;
import com.dawn.library.user.dao.UserDao;

// 服务，用于注解业务逻辑层
@Service
public class UserServiceImpl implements UserService {
	// 依赖资源
	@Resource
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.add(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public User findUserById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public User findUserByNo(String no) {
		// TODO Auto-generated method stub
		return userDao.findByNo(no);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAll();
	}

	@Override
	public boolean validate(User user) {
		User u = userDao.findByName(user.getName());
		if (u == null) {
			return false;
		}
		if (u.getPwd().equals(user.getPwd())) {
			return true;
		} else {
			return false;
		}
	}

	// getter & setter

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
