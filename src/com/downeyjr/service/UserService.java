package com.downeyjr.service;

import java.util.List;

import com.downeyjr.entity.User;

public interface UserService {

	public User checkLogin(String username, String password);

	public int insertMultiUserFail(List<User> userList) throws Exception;

	public int insertMultiUserSuccess(List<User> userList) throws Exception;

}
