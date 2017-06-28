package com.application.person.action;

import java.sql.Timestamp;
import com.application.login.action.*;

/**
 * 
 * @Description �û�������Ϣҵ����
 *
 */
public class PersonService {
	private PersonDao personDao = new PersonDaoImpl();
	
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
	public boolean add(String name, String sex, Timestamp date, String idCard, String tel, String status, String mail, String address, String edu, String pos, User user){
		return personDao.add(name, sex, date, idCard, tel, status, mail, address, edu, pos, user);
	}
	
	public PersonDao getPersonDao(){
		return personDao;
	}
	public void setPersonDao(PersonDao personDao){
		this.personDao = personDao;
	}
}
