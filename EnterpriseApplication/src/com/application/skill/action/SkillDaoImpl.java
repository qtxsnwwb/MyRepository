package com.application.skill.action;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.edu.action.Edu;
import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.User;

/**
 * 
 * @Description ����֤��DAO����ʵ����
 *
 */
public class SkillDaoImpl implements SkillDao{
	/**
	 * @Description ���Ӽ���֤��
	 * @param skcontent ����
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String skcontent, final User user){
		List<Skill> list = this.check(user);
		for(Skill s: list){       
			if(!("".equals(s.getSkcontent()) || s.getSkcontent() == null)){       //�������ݿ������и��û���Ϣ�������
				if(this.update(skcontent, s)){   //���³ɹ�
					return true;
				}else{       //����ʧ��
					return false;
				}
			}
		}
		
		//�������ڣ��򴴽�
		Skill skill = new Skill(skcontent,user);      //����Ҫ�洢�Ķ���
		
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		try{
			session.save(skill);       //�־û�����
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
	private List<Skill> check(final User user){
		String ID = user.getId();      //��ȡuser�����ID
		//��ȡSession����
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Skill s inner join fetch s.user u where u.id= :userID";
		//��ȡQuery����
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description ��������
	 * @param skcontent ����
	 * @param skill ��ǰskill����
	 * @return ���³ɹ����
	 */
	public boolean update(final String skcontent, final Skill skill){
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		skill.setSkcontent(skcontent);      //���ø��µ�����
		try{
			session.update(skill);       //�־û�����
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
