package com.application.login.action;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.pass.util.*;

/**
 * 
 * @Description �û�DAO����ʵ����
 *
 */
public class UserDaoImpl implements UserDao{
	/**
	 * @Description ��¼��֤����
	 * @param userName �û���
	 * @param userPass ����
	 * @return ��ѯ���
	 */
	public List<User> login(final String userName, final String userPass){
		List<User> list = this.check(userName);       //��ȡ��ѯ���
		for(User u: list){
			if("".equals(u.getUserPass()) || u.getUserPass() == null){
				return null;        //�������ڸ����룬����Ϊ�� 
			}
			if(u.getUserPass().equals(MD5.getMD5(userPass))){
				return list;
			}
		}
		return null;
	}
	
	/**
	 * @Description ִ��ע�᷽��
	 * @param userName �û���
	 * @param userPass ����
	 * @return �����Ƿ�ɹ�
	 */
	public boolean register(final String userName, final String userPass){
		//�Ƚ��е�¼��֤�����Ƿ��û����������Ѵ���
		List<User> list = this.check(userName);
		for(User u: list){
			if(u.getUserName().equals(userName) || u.getUserPass().equals(MD5.getMD5(userPass))){
				return false;
			}
		}
		
		//�û��������벻���ڣ�����ע��
		User users = new User();    //����Ҫ����Ķ���
		users.setUserName(userName);
		users.setUserPass(MD5.getMD5(userPass));
		users.setRole(1);
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		try{
			session.save(users);       //�־û�����
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //�������ɹ�������ع�
			return false;
		}
		trans.commit();      //�ύ����
		session.close();      //�ر�Session
		
		return true;
	}
	
	/**
	 * @Description �鿴�����Ƿ����
	 * @param userName �û���
	 * @return ��ѯ���
	 */
	private List<User> check(final String userName){
		//��ȡSession����
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from User where USERNAME=?";
		//��ȡQuery����
		Query query = session.createQuery(hql);
		query.setString(0, userName);
		return query.list();
	}
}
