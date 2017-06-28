package com.application.person.action;

import java.sql.Timestamp;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.*;

/**
 * 
 * @Description �û�������ϢDAO����ʵ����
 *
 */
public class PersonDaoImpl implements PersonDao{
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
	 * @param user ������user����
	 * @return ��ӳɹ����
	 */
	public boolean add(final String name, final String sex, final Timestamp date, final String idCard, final String tel, final String status, final String mail, final String address, final String edu, final String pos, final User user){
		List<Person> list = this.check(user);
		for(Person p: list){        
			if(!("".equals(p.getName()) || p.getName() == null)){       //�������ݿ������и��û���Ϣ�������
				if(this.update(name, sex, date, idCard, tel, status, mail, address, edu, pos, p)){   //���³ɹ�
					return true;
				}else{       //����ʧ��
					return false;
				}
			}
		}
		
		//�����ݿ����޸���Ϣ�򴴽�
		Person person = new Person(name,sex,date,idCard,tel,status,mail,address,edu,pos,user);      //����Ҫ�洢�Ķ���
		
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		try{
			session.save(person);       //�־û�����
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //�������ɹ�������ع�
			return false;
		}
		trans.commit();      //�ύ����
		HibernateSessionFactory.closeSession();      //�ر�Session
		
		return true;     //��ӳɹ�������true
		
	}
	
	/**
	 * @Description ��ѯ���ݿ����Ƿ����и��û���Ϣ
	 * @param user ������user����
	 * @return ��ѯ���
	 */
	private List<Person> check(final User user){
		String ID = user.getId();      //��ȡuser�����ID
		//��ȡSession����
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Person p inner join fetch p.user u where u.id= :userID";
		//��ȡQuery����
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
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
	public boolean update(final String name, final String sex, final Timestamp date, final String idCard, final String tel, final String status, final String mail, final String address, final String edu, final String pos, final Person person){
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		person.setName(name);
		person.setSex(sex);
		person.setDate(date);
		person.setIdCard(idCard);
		person.setTel(tel);
		person.setStatus(status);
		person.setMail(mail);
		person.setAddress(address);
		person.setEdu(edu);
		person.setPos(pos);         //���ø��µ�����
		try{
			session.update(person);       //�־û�����
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
