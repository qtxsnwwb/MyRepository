package com.application.selfass.action;

import com.application.login.action.*;

/**
 * 
 * @Description ��������DAO�ӿ�
 *
 */
public interface SelfassDao {
	/**
	 * @Description �����������
	 * @param secontent ����
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String secontent, final User user);
	
	/**
	 * @Description ��������
	 * @param secontent ����
	 * @param selfass ��ǰselfass����
	 * @return
	 */
	public boolean update(final String secontent, final Selfass selfass);
}
