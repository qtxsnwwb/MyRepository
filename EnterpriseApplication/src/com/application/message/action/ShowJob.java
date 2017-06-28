package com.application.message.action;

import java.util.*;

import com.application.login.action.*;
import com.application.job.action.*;

import org.hibernate.*;


/**
 * 
 * @Description ��ͨ�û�������Ƹְλ���ݱ���
 *
 */
public class ShowJob {
	private Integer id;
	private String checkmess;       //��ѯ��Ϣ
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
	public String getCheckmess(){
		return checkmess;
	}
	public void setCheckmess(String checkmess){
		this.checkmess = checkmess;
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
	 * @Description ������Ƹ��Ϣ���ݱ�ģ����ѯ
	 */
	private void getPartMessage(){
		final String hql = "from Job as j where j.jname like :name";
		Query query = session.createQuery(hql);      //����Query����
		query.setString("name", "%"+checkmess+"%");      //����ģ����ѯ
		list = query.list();
	}
	
	/**
	 * @Description ִ��ģ����ѯ
	 * @return ��result��ص��ַ���
	 */
	public String execute(){
		this.getPartMessage();     //ִ��ģ����ѯ
		return "success";
	}
}
