package com.application.job.action;

import java.util.*;
import java.text.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.login.action.*;

/**
 * 
 * @Description ��Ƹ��ϢDAO����ʵ����
 *
 */
public class JobDaoImpl implements JobDao{
	/**
	 * @Description �����Ƹ��Ϣ
	* @param jname ְλ����
	 * @param partment ��������
	 * @param worktype ��������
	 * @param salary ��н��Χ
	 * @param jedu ѧ��Ҫ��
	 * @param pnum ��Ƹ����
	 * @param jperson ��ϵ��
	 * @param jtel �ֻ�
	 * @param jmail ����
	 * @param message ��ϸ��Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String jname, final String partment, final String worktype, final String salary, final String jedu, final String pnum, final String jperson, final String jtel, final String jmail, final String message){
		List<Job> list = this.check(jname, salary, jedu, pnum);
		for(Job j: list){       //�����ݿ������и���Ϣ���򷵻�false
			if(j.getJname().equals(jname) && j.getSalary().equals(salary) && j.getJedu().equals(jedu) && j.getPnum().equals(pnum)){
				return false;
			}
		}
		
		//�����ݿ����޸���Ϣ�������
		Job job = new Job(jname,partment,worktype,salary,jedu,pnum,this.getCurrentTime(),jperson,jtel,jmail,message);       //����Ҫ��ӵĶ���
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		try{
			session.save(job);       //�־û�����
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
	 * @Description �鿴���ݿ����Ƿ����и���Ƹ��Ϣ
	 * @param jname ְλ����
	 * @param salary ��н��Χ
	 * @param jedu ѧ��Ҫ��
	 * @param pnum ��Ƹ����
	 * @return ��ѯ���
	 */
	private List<Job> check(final String jname, final String salary, final String jedu, final String pnum){
		//��ȡSession����
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Job where JNAME=? and SALARY=? and JEDU=? and PNUM=?";
		//��ȡQuery����
		Query query = session.createQuery(hql);
		query.setString(0, jname);
		query.setString(1, salary);
		query.setString(2, jedu);
		query.setString(3, pnum);
		return query.list();
	}
	
	private String getCurrentTime(){
		Date currentTime = new Date();
		SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formatTime.format(currentTime);
		return time;
	}
}
