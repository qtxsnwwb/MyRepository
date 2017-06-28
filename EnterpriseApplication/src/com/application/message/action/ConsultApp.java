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
 * @Description 遍历简历数据表中的信息
 *
 */
public class ConsultApp {
	Session session = HibernateSessionFactory.getSession();     //获取Session对象
	private String id;    //ID值
	private List<Person> list;     //用户个人信息List
	private List<Edu> elist;     //教育背景List
	private List<Practice> plist;      //实习经历List    
	private List<Shpra> shlist;      //校内实践List
	private List<Skill> sklist;      //技能证书List
	private List<Selfass> selist;    //自我评价List
	
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
	 * @Description 取得全部的用户个人信息
	 */
	private void getWholePerMessage(){
		final String hql = "from Person"; 
		Query query = session.createQuery(hql);     //创建Query对象
		list = query.list();      //获取查询结果
	}
	
	/**
	 * @Description 查询全部用户
	 * @return 与result相关的字符串
	 */
	public String checkApp(){
		this.getWholePerMessage();     //调用方法，取得全部用户个人信息
		return "success";
	}
	
	/**
	 * @Description 获取全部简历信息
	 * @return 与result相关的字符串
	 */
	public String getWholeAppMessage(){
		Person person = this.getPerson(id);     //获取ID值对应的Person对象
		String userID = person.getUser().getId();       //获取与Person对象级联的User对象的ID值
		this.getWholePerMessage();      //取得全部用户个人信息
		this.getWholeEduMessage(userID);      //取得全部教育经历信息
		this.getWholePraMessage(userID);      //取得全部实习经历信息
		this.getWholeShpMessage(userID);      //取得全部校内实践信息
		this.getWholeSkiMessage(userID);      //取得全部技能证书信息
		this.getWholeSelMessage(userID);      //取得全部自我评价信息
		return "success";
	}
	
	/**
	 * @Description 获取全部教育经历信息
	 * @param userID 级联ID
	 */
	private void getWholeEduMessage(String userID){
		final String hql = "from Edu e inner join fetch e.user u where u.id= :userID";
		Query query = session.createQuery(hql);      //创建Query
		query.setString("userID", userID);
		elist = query.list();       //返回获取结果
	}
	
	/**
	 * @Description 获取全部实习经历信息
	 * @param userID 级联ID
	 */
	private void getWholePraMessage(String userID){
		final String hql = "from Practice p inner join fetch p.user u where u.id= :userID";
		Query query = session.createQuery(hql);      //创建Query
		query.setString("userID", userID);
		plist = query.list();       //返回获取结果
	}
	
	/**
	 * @Description 获取全部校内实践信息
	 * @param userID 级联ID
	 */
	private void getWholeShpMessage(String userID){
		final String hql = "from Shpra s inner join fetch s.user u where u.id= :userID";
		Query query = session.createQuery(hql);      //创建Query
		query.setString("userID", userID);
		shlist = query.list();       //返回获取结果
	}
	
	/**
	 * @Description 获取全部技能证书信息
	 * @param userID 级联ID
	 */
	private void getWholeSkiMessage(String userID){
		final String hql = "from Skill s inner join fetch s.user u where u.id= :userID";
		Query query = session.createQuery(hql);      //创建Query
		query.setString("userID", userID);
		sklist = query.list();       //返回获取结果
	}
	
	/**
	 * @Description 获取全部自我评价信息
	 * @param userID 级联ID
	 */
	private void getWholeSelMessage(String userID){
		final String hql = "from Selfass s inner join fetch s.user u where u.id= :userID";
		Query query = session.createQuery(hql);      //创建Query
		query.setString("userID", userID);
		selist = query.list();       //返回获取结果
	}
	
	/**
	 * @Description 获取用户个人信息
	 * @param id ID值
	 * @return 用户个人信息对象
	 */
	private Person getPerson(String ID){
		Transaction trans = session.beginTransaction();     //开启一个事务
		Person person = (Person) session.get(Person.class, ID);      //获取指定的Person对象
		trans.commit();      //提交事务
		return person;
	}
	
	/**
	 * @Description 查询按日期排序后的全部用户
	 * @return 与result相关的字符串
	 */
	public String orderDate(){
		final String hql = "from Person as p order by p.date";
		Query query = session.createQuery(hql);     //创建Query对象
		list = query.list();      //获取查询结果
		return "success";
	}
	
	/**
	 * @Description 查询按学历排序后的全部用户
	 * @return 与result相关的字符串
	 */
	public String orderEdu(){
		final String hql = "from Person as p order by p.edu";
		Query query = session.createQuery(hql);     //创建Query对象
		list = query.list();      //获取查询结果
		return "success";
	}
	
	/**
	 * @Description 查询按意向职位排序后的全部用户
	 * @return 与result相关的字符串
	 */
	public String orderPos(){
		final String hql = "from Person as p order by p.pos";
		Query query = session.createQuery(hql);     //创建Query对象
		list = query.list();      //获取查询结果
		return "success";
	}
	
	
	
}
