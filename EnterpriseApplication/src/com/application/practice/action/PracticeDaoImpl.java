package com.application.practice.action;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.edu.action.Edu;
import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.User;

/**
 * 
 * @Description ʵϰ����DAO����ʵ����
 *
 */
public class PracticeDaoImpl implements PracticeDao{
	/**
	 * @Description ���ʵϰ����
	 * @param ptime ʵϰʱ��
	 * @param porgan ʵϰ��λ
	 * @param ppos ʵϰ��λ
	 * @param pcontent ʵϰ����
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String ptime, final String porgan, final String ppos, final String pcontent, final User user){
		List<Practice> list = this.check(user);
		for(Practice p: list){        
			if(!("".equals(p.getPorgan()) || p.getPorgan() == null)){       //�������ݿ������и��û���Ϣ�������
				if(this.update(ptime, porgan, ppos, pcontent, p)){   //���³ɹ�
					return true;
				}else{       //����ʧ��
					return false;
				}
			}
		}
		
		//�������ڣ��򴴽�
		Practice practice = new Practice(ptime,porgan,ppos,pcontent,user);      //����Ҫ�洢�Ķ���
		
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		try{
			session.save(practice);       //�־û�����
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
	 * @Description �鿴���ݿ������и�ʵϰ����
	 * @param user ����user����
	 * @return ��ѯ���
	 */
	private List<Practice> check(final User user){
		String ID = user.getId();      //��ȡuser�����ID
		//��ȡSession����
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Practice p inner join fetch p.user u where u.id= :userID";
		//��ȡQuery����
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description ��������
	 * @param ptime ʵϰʱ��
	 * @param porgan ʵϰ��λ
	 * @param ppos ʵϰ��λ
	 * @param pcontent ʵϰ����
	 * @param practice ��ǰpractice����
	 * @return ���³ɹ����
	 */
	public boolean update(final String ptime, final String porgan, final String ppos, final String pcontent, final Practice practice){
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		practice.setPtime(ptime);
		practice.setPorgan(porgan);
		practice.setPpos(ppos);
		practice.setPcontent(pcontent);      //���ø��µ�����
		try{
			session.update(practice);       //�־û�����
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
