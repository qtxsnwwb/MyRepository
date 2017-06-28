package com.application.message.action;

import com.application.login.action.*;
import com.application.person.action.*;
import com.application.edu.action.*;
import com.application.practice.action.*;
import com.application.selfass.action.*;
import com.application.shpra.action.*;
import com.application.skill.action.*;

import java.util.*;

import org.hibernate.*;

/**
 * 
 * @Description �����������ݱ��е���Ϣ
 *
 */
public class ConsultApp {
	Session session = HibernateSessionFactory.getSession();     //��ȡSession����
	private String id;    //IDֵ
	private List<Person> list;     //�û�������ϢList
	private List<Edu> elist;     //��������List
	private List<Practice> plist;      //ʵϰ����List    
	private List<Shpra> shlist;      //У��ʵ��List
	private List<Skill> sklist;      //����֤��List
	private List<Selfass> selist;    //��������List
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public List<Person> getList(){
		return list;
	}
	public void setList(List<Person> list){
		this.list = list;
	}
	public List<Edu> getElist(){
		return elist;
	}
	public void setElist(List<Edu> elist){
		this.elist = elist;
	}
	public List<Practice> getPlist(){
		return plist;
	}
	public void setPlist(List<Practice> plist){
		this.plist = plist;
	}
	public List<Shpra> getShlist(){
		return shlist;
	}
	public void setShlist(List<Shpra> shlist){
		this.shlist = shlist;
	}
	public List<Skill> getSklist() {
		return sklist;
	}
	public void setSklist(List<Skill> sklist) {
		this.sklist = sklist;
	}
	public List<Selfass> getSelist() {
		return selist;
	}
	public void setSelist(List<Selfass> selist) {
		this.selist = selist;
	}
	
	
	/**
	 * @Description ȡ��ȫ�����û�������Ϣ
	 */
	private void getWholePerMessage(){
		final String hql = "from Person"; 
		Query query = session.createQuery(hql);     //����Query����
		list = query.list();      //��ȡ��ѯ���
	}
	
	/**
	 * @Description ��ѯȫ���û�
	 * @return ��result��ص��ַ���
	 */
	public String checkApp(){
		this.getWholePerMessage();     //���÷�����ȡ��ȫ���û�������Ϣ
		return "success";
	}
	
	/**
	 * @Description ��ȡȫ��������Ϣ
	 * @return ��result��ص��ַ���
	 */
	public String getWholeAppMessage(){
		Person person = this.getPerson(id);     //��ȡIDֵ��Ӧ��Person����
		String userID = person.getUser().getId();       //��ȡ��Person��������User�����IDֵ
		this.getWholePerMessage();      //ȡ��ȫ���û�������Ϣ
		this.getWholeEduMessage(userID);      //ȡ��ȫ������������Ϣ
		this.getWholePraMessage(userID);      //ȡ��ȫ��ʵϰ������Ϣ
		this.getWholeShpMessage(userID);      //ȡ��ȫ��У��ʵ����Ϣ
		this.getWholeSkiMessage(userID);      //ȡ��ȫ������֤����Ϣ
		this.getWholeSelMessage(userID);      //ȡ��ȫ������������Ϣ
		return "success";
	}
	
	/**
	 * @Description ��ȡȫ������������Ϣ
	 * @param userID ����ID
	 */
	private void getWholeEduMessage(String userID){
		final String hql = "from Edu e inner join fetch e.user u where u.id= :userID";
		Query query = session.createQuery(hql);      //����Query
		query.setString("userID", userID);
		elist = query.list();       //���ػ�ȡ���
	}
	
	/**
	 * @Description ��ȡȫ��ʵϰ������Ϣ
	 * @param userID ����ID
	 */
	private void getWholePraMessage(String userID){
		final String hql = "from Practice p inner join fetch p.user u where u.id= :userID";
		Query query = session.createQuery(hql);      //����Query
		query.setString("userID", userID);
		plist = query.list();       //���ػ�ȡ���
	}
	
	/**
	 * @Description ��ȡȫ��У��ʵ����Ϣ
	 * @param userID ����ID
	 */
	private void getWholeShpMessage(String userID){
		final String hql = "from Shpra s inner join fetch s.user u where u.id= :userID";
		Query query = session.createQuery(hql);      //����Query
		query.setString("userID", userID);
		shlist = query.list();       //���ػ�ȡ���
	}
	
	/**
	 * @Description ��ȡȫ������֤����Ϣ
	 * @param userID ����ID
	 */
	private void getWholeSkiMessage(String userID){
		final String hql = "from Skill s inner join fetch s.user u where u.id= :userID";
		Query query = session.createQuery(hql);      //����Query
		query.setString("userID", userID);
		sklist = query.list();       //���ػ�ȡ���
	}
	
	/**
	 * @Description ��ȡȫ������������Ϣ
	 * @param userID ����ID
	 */
	private void getWholeSelMessage(String userID){
		final String hql = "from Selfass s inner join fetch s.user u where u.id= :userID";
		Query query = session.createQuery(hql);      //����Query
		query.setString("userID", userID);
		selist = query.list();       //���ػ�ȡ���
	}
	
	/**
	 * @Description ��ȡ�û�������Ϣ
	 * @param id IDֵ
	 * @return �û�������Ϣ����
	 */
	private Person getPerson(String ID){
		Transaction trans = session.beginTransaction();     //����һ������
		Person person = (Person) session.get(Person.class, ID);      //��ȡָ����Person����
		trans.commit();      //�ύ����
		return person;
	}
	
	/**
	 * @Description ��ѯ������������ȫ���û�
	 * @return ��result��ص��ַ���
	 */
	public String orderDate(){
		final String hql = "from Person as p order by p.date";
		Query query = session.createQuery(hql);     //����Query����
		list = query.list();      //��ȡ��ѯ���
		return "success";
	}
	
	/**
	 * @Description ��ѯ��ѧ��������ȫ���û�
	 * @return ��result��ص��ַ���
	 */
	public String orderEdu(){
		final String hql = "from Person as p order by p.edu";
		Query query = session.createQuery(hql);     //����Query����
		list = query.list();      //��ȡ��ѯ���
		return "success";
	}
	
	/**
	 * @Description ��ѯ������ְλ������ȫ���û�
	 * @return ��result��ص��ַ���
	 */
	public String orderPos(){
		final String hql = "from Person as p order by p.pos";
		Query query = session.createQuery(hql);     //����Query����
		list = query.list();      //��ȡ��ѯ���
		return "success";
	}
	
	
	
}
