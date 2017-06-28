package com.application.login.action;

import java.util.List;

/**
 * 
 * @Description �û�DAO�ӿ�
 *
 */
public interface UserDao {
	/**
	 * @Description ��¼��֤����
	 * @param userName �û���
	 * @param userPass ����
	 * @return ��ѯ���
	 */
	public List<User> login(final String userName, final String userPass);
	
	/**
	 * @Description ִ��ע�᷽��
	 * @param userName �û���
	 * @param userPass ����
	 * @return �����Ƿ�ɹ�
	 */
	public boolean register(final String userName, final String userPass);
}
