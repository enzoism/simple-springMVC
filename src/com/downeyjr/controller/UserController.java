package com.downeyjr.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.downeyjr.*;
import com.downeyjr.entity.User;
import com.downeyjr.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@Scope(value="prototype")
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,Model model) throws Exception {
		user=userService.checkLogin(user.getUsername(), user.getPassword());
		System.out.println(user);
		if(user!=null){
			model.addAttribute(user);
			return "success";			
		}
		return "error";
	}


	@ResponseBody
	@RequestMapping(value="/testAjax",method=RequestMethod.POST)
	public String  testAjax(String user,String temp) throws Exception {

		return "成功";
	}
	
	
	@RequestMapping(value="/insertMultiUserFail")
	public String insertMultiUserFail(Model model) {
		List<User> list = new ArrayList<>(100);
		for (int i = 0; i < 100; i++) {
			User user = new User("TT_"+i, "123456");
			list.add(user);			
		}
		String page = "error";
		//将数据插入数据库
		int num = -1;
		try {
			num = userService.insertMultiUserFail(list);
		} catch (Exception e) {
			System.out.println("数据库操作异常");
		}
		System.out.println("----------用户插入数据："+num);
		page = num!=-1?"success":"error";
		return page;
	}	
	
	
	@RequestMapping(value="/insertMultiUserSuccess")
	public String insertMultiUserSuccess(Model model) {
		List<User> list = new ArrayList<>(100);
		for (int i = 0; i < 100; i++) {
			User user = new User("TT_"+i, "123456");
			list.add(user);			
		}
		String page = "error";
		//将数据插入数据库
		int num = -1;
		try {
			num = userService.insertMultiUserSuccess(list);
		} catch (Exception e) {
			System.out.println("数据库操作异常");
		}
		System.out.println("----------用户插入数据："+num);
		page = num!=-1?"success":"error";
		return page;
	}	
	
}
