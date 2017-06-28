package com.application.shpra.action;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.edu.action.Edu;
import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.User;

/**
 * 
 * @Description У��ʵ��DAO����ʵ����
 *
 */
public class ShpraDaoImpl implements ShpraDao{
	/**
	 * @Description ���У��ʵ��
	 * @param stime ʵ��ʱ��
	 * @param sorgan ʵ����λ
	 * @param sduty ʵ��ְ��
	 * @param scontent ʵ������
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String stime, final String sorgan, final String sduty, final String scontent, final User user){
		List<Shpra> list = this.check(user);
		for(Shpra s: list){        
			if(!("".equals(s.getSorgan()) || s.getSorgan() == null)){       //�������ݿ������и��û���Ϣ�������
				if(this.update(stime, sorgan, sduty, scontent, s)){   //���³ɹ�
					return true;
				}else{       //����ʧ��
					return false;
				}
			}
		}
		
		//�������ڣ��򴴽�
		Shpra shpra = new Shpra(stime,sorgan,sduty,scontent,user);      //����Ҫ�洢�Ķ���
		
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		try{
			session.save(shpra);       //�־û�����
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
	 * @Description �鿴���ݿ��Ƿ����и�����
	 * @param user ����user����
	 * @return ��ѯ���
	 */
	private List<Shpra> check(final User user){
		String ID = user.getId();      //��ȡuser�����ID
		//��ȡSession����
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Shpra s inner join fetch s.user u where u.id= :userID";
		//��ȡQuery����
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description ��������
	 * @param stime ʵ��ʱ��
	 * @param sorgan ʵ����λ
	 * @param sduty ʵ��ְ��
	 * @param scontent ʵ������
	 * @param shpra ��ǰshpra����
	 * @return ���³ɹ����
	 */
	public boolean update(final String stime, final String sorgan, final String sduty, final String scontent, final Shpra shpra){
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		shpra.setStime(stime);
		shpra.setSorgan(sorgan);
		shpra.setSduty(sduty);
		shpra.setScontent(scontent);     //���ø��µ�����
		try{
			session.update(shpra);       //�־û�����
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
