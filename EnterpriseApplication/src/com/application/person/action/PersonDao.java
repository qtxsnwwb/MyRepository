package com.application.person.action;

import java.sql.Timestamp;

import com.application.login.action.*;

/**
 * 
 * @Description ������ϢDAO�ӿ�
 *
 */
public interface PersonDao {
	/**
	 * @Description ����û�������Ϣ
	 * @param name ��ʵ����
	 * @param sex �Ա�
	 * @param date ��������
	 * @param idCard ���֤����
	 * @param tel �绰
	 * @param status ������ò
	 * @param mail ����
	 * @param address סַ
	 * @param edu ѧ��
	 * @param pos ְλ
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String name, final String sex, final Timestamp date, final String idCard, final String tel, final String status, final String mail, final String address, final String edu, final String pos, final User user);
	
	/**
	 * @Description ��������
	 * @param name ��ʵ����
	 * @param sex �Ա�
	 * @param date ��������
	 * @param idCard ���֤����
	 * @param tel �绰
	 * @param status ������ò
	 * @param mail ����
	 * @param address סַ
	 * @param edu ѧ��
	 * @param pos ְλ
	 * @param person ��ǰ��Person����
	 * @return ���³ɹ����
	 */
	public boolean update(final String name, final String sex, final Timestamp date, final String idCard, final String tel, final String status, final String mail, final String address, final String edu, final String pos, final Person person);
	
}
