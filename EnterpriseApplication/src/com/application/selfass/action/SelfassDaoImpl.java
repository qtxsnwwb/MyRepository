package com.application.selfass.action;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.edu.action.Edu;
import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.User;

/**
 * 
 * @Description ��������DAO����ʵ����
 *
 */
public class SelfassDaoImpl implements SelfassDao{
	/**
	 * @Description �����������
	 * @param secontent ����
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String secontent, final User user){
		List<Selfass> list = this.check(user);
		for(Selfass s: list){      
			if(!("".equals(s.getSecontent()) || s.getSecontent() == null)){       //�������ݿ������и��û���Ϣ�������
				if(this.update(secontent, s)){   //���³ɹ�
					return true;
				}else{       //����ʧ��
					return false;
				}
			}
		}
		
		//�������ڣ��򴴽�
		Selfass selfass = new Selfass(secontent,user);      //����Ҫ�洢�Ķ���
		
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		try{
			session.save(selfass);       //�־û�����
		}catch(Exception ex){
			ex.printStackTrace();
			trans.rollback();      //�������ɹ�������ع�
			return false;
		}
		trans.commit();      //�ύ����
		HibernateSessionFactory.closeSession();      //�ر�Session
		
		return true;     //��ӳɹ�������true
	} 
	
	/**
	 * @Description �鿴���ݿ����Ƿ����и�����
	 * @param user ����user����
	 * @return ��ѯ���
	 */
	private List<Selfass> check(final User user){
		String ID = user.getId();      //��ȡuser�����ID
		//��ȡSession����
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Selfass s inner join fetch s.user u where u.id= :userID";
		//��ȡQuery����
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description ��������
	 * @param secontent ����
	 * @param selfass ��ǰselfass����
	 * @return ���³ɹ����
	 */
	public boolean update(final String secontent, final Selfass selfass){
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		selfass.setSecontent(secontent);      //���ø��µ�����
		try{
			session.update(selfass);       //�־û�����
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //�������ɹ�������ع�
			return false;
		}
		trans.commit();      //�ύ����
		HibernateSessionFactory.closeSession();      //�ر�Session
		
		return true;     //���³ɹ�������true
	}
}
