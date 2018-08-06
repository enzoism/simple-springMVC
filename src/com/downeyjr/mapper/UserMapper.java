package com.downeyjr.mapper;

import java.util.List;

import com.downeyjr.entity.User;

public interface UserMapper {
	
	public User getUserByName(String username);
	public int insertMultiUser(List<User> userList);

}
