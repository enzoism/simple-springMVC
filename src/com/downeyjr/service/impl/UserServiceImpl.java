package com.downeyjr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.downeyjr.dao.UserDao;
import com.downeyjr.entity.User;
import com.downeyjr.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
	private UserDao userDao;

   /**
    * 登陆验证
    * @param
    */
	public User checkLogin(String username, String password) {
		
		User user=userDao.findUserByName(username);
		System.out.println("-------------------dao:"+user);
		if(user!=null&&user.getPassword().equals(password)){
			return user;
		}
		return null;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class},timeout=30,isolation=Isolation.DEFAULT)  
	public int insertMultiUserFail(List<User> userList)throws Exception  {
		int num = -1;
		int insertNum = userDao.insertMultiUser(userList);
		if (insertNum == userList.size()) {
			num = -1;//模拟数据库失败
			throw new Exception();
		}
		return num;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class},timeout=30,isolation=Isolation.DEFAULT)  
	public int insertMultiUserSuccess(List<User> userList)throws Exception   {
		int num = -1;
			int insertNum = userDao.insertMultiUser(userList);
			if (insertNum == userList.size()) {
				num = insertNum;//模拟数据库成功
			}
		return num;
	}

}
