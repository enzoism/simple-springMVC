package com.downeyjr.dao;

import java.util.List;

import com.downeyjr.entity.User;


public interface UserDao {

	public User findUserByName(String username);

	public int insertMultiUser(List<User> userList);
}
