package com.application.edu.action;

import java.sql.Timestamp;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.User;
import com.application.person.action.Person;

/**
 * 
 * @Description ��������DAO����ʵ����
 *
 */
public class EduDaoImpl implements EduDao{
	/**
	 * @Description ��ӽ�������
	 * @param endTime ��ҵʱ��
	 * @param school ѧУ
	 * @param major רҵ
	 * @param degree ѧλ
	 * @param subject ���޿γ�
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final Timestamp endTime, final String school, final String major, final String degree, final String subject, final User user){
		List<Edu> list = this.check(user);
		for(Edu e: list){       
			if(!("".equals(e.getEndTime()) || e.getEndTime() == null)){       //�������ݿ������и��û���Ϣ�������
				if(this.update(endTime, school, major, degree, subject, e)){   //���³ɹ�
					return true;
				}else{       //����ʧ��
					return false;
				}
			}
		}
		
		//�������ڣ��򴴽�
		Edu edu = new Edu(endTime,school,major,degree,subject,user);      //����Ҫ�洢�Ķ���
		
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		try{
			session.save(edu);       //�־û�����
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
	 * @Description ��ѯ���������Ƿ��������ݿ���
	 * @param user ����user����
	 * @return ��ѯ���
	 */
	private List<Edu> check(final User user){
		String ID = user.getId();      //��ȡuser�����ID
		//��ȡSession����
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Edu e inner join fetch e.user u where u.id= :userID";
		//��ȡQuery����
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description ��������
	 * @param endTime ��ҵʱ��
	 * @param school ѧУ
	 * @param major רҵ
	 * @param degree ѧλ
	 * @param subject ���޿γ�
	 * @param edu ��ǰEdu����
	 * @return ���³ɹ����
	 */
	public boolean update(final Timestamp endTime, final String school, final String major, final String degree, final String subject, final Edu edu){
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		edu.setEndTime(endTime);
		edu.setSchool(school);
		edu.setMajor(major);
		edu.setDegree(degree);
		edu.setSubject(subject);      //���ø��µ�����
		try{
			session.update(edu);       //�־û�����
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
