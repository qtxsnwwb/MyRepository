package com.application.message.action;

import java.util.*;

import com.application.login.action.*;
import com.application.job.action.*;

import org.hibernate.*;

/**
 * 
 * @Description ������Ƹ��Ϣ���ݱ�����Ϣ
 *
 */
public class ConsultJob {
	private Integer id;
	Session session = HibernateSessionFactory.getSession();      //��ȡSession����
	private List<Job> list;     //����List����
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public List<Job> getList() {
		return list;
	}

	public void setList(List<Job> list) {
		this.list = list;
	}
	
	/**
	 * @Description ����ָ���û�����ȡ�ø��û�ȫ��ְλ��Ϣ
	 */
	private void getWholeJobMessage(){
		final String hql = "from Job"; 
		Query query = session.createQuery(hql);     //����Query����
		list = query.list();      //��ȡ��ѯ���
	}
	
	/**
	 * @Description ��ѯȫ��ְλ
	 * @return ��result��ص��ַ���
	 */
	public String checkJob(){
		this.getWholeJobMessage();      //���÷�������ȡȫ��ְλ��Ϣ
		return "success";
	}
	
	/**
	 * @Description ɾ��ָ��ְλ
	 * @return ��result��ص��ַ���
	 */
	public String delJob(){
		Transaction trans = session.beginTransaction();     //����һ������
		Job job = (Job) session.get(Job.class, id);
		try{
			session.delete(job);       //�־û�����
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //�������ɹ�������ع�
		}
		trans.commit();      //�ύ����
		//HibernateSessionFactory.closeSession();      //�ر�Session
		this.checkJob();      //���÷�������ȡȫ��ְλ��Ϣ
		return "success";
	}
}
