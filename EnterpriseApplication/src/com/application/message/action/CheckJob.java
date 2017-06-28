package com.application.message.action;

import org.hibernate.*;
import com.application.login.action.*;
import com.application.job.action.*;

import java.util.*;

/**
 * 
 * @Description ��Ϣ��ѯ
 *
 */
public class CheckJob {
	private String checkmess;       //��ѯ��Ϣ
	private List<Job> list;       //�������󼯺�
	Session session = HibernateSessionFactory.getSession();      //��ȡSession
	
	public String getCheckmess(){
		return checkmess;
	}
	public void setCheckmess(String checkmess){
		this.checkmess = checkmess;
	}
	public List<Job> getList(){
		return list;
	}
	public void setList(List<Job> list){
		this.list = list;
	}
	
	/**
	 * @Description ���з���Ҫ����Ϣɸѡ
	 * @return ��result��ص��ַ���
	 */
	public String execute(){
		this.getPartMessage();      //���÷�����ִ��ģ����ѯ
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
}
