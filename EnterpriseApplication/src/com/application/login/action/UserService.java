package com.application.login.action;

import java.util.*;

/**
 * 
 * @Description 用户业务类
 *
 */
public class UserService{
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * @Description 登录验证方法
	 * @param userName 用户名
	 * @param userPass 密码
	 * @return 查询结果
	 */
	public List<User> login(String userName, String userPass){
		return userDao.login(userName, userPass);
	}
	
	/**
	 * @Description 执行注册方法
	 * @param userName 用户名
	 * @param userPass 密码
	 * @return 操作成功与否
	 */
	public boolean register(String userName, String userPass){
		return userDao.register(userName, userPass);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
