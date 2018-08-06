package com.downeyjr.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.downeyjr.dao.UserDao;
import com.downeyjr.entity.User;
import com.downeyjr.mapper.UserMapper;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Resource(name = "userMapper")
	private UserMapper userMapper;

	/**
	 * 根据用户名查找用户对象
	 * 
	 * @return User
	 */
	public User findUserByName(String username) {

		return userMapper.getUserByName(username);
	}

	@Override
	public int insertMultiUser(List<User> userList) {
		return userMapper.insertMultiUser(userList);

	}

}
