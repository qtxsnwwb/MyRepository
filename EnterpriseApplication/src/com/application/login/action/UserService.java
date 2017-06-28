package com.application.login.action;

import java.util.*;

/**
 * 
 * @Description �û�ҵ����
 *
 */
public class UserService{
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * @Description ��¼��֤����
	 * @param userName �û���
	 * @param userPass ����
	 * @return ��ѯ���
	 */
	public List<User> login(String userName, String userPass){
		return userDao.login(userName, userPass);
	}
	
	/**
	 * @Description ִ��ע�᷽��
	 * @param userName �û���
	 * @param userPass ����
	 * @return �����ɹ����
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
