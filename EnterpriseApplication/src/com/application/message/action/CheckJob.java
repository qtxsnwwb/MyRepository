package com.application.message.action;

import org.hibernate.*;
import com.application.login.action.*;
import com.application.job.action.*;

import java.util.*;

/**
 * 
 * @Description 信息查询
 *
 */
public class CheckJob {
	private String checkmess;       //查询信息
	private List<Job> list;       //创建对象集合
	Session session = HibernateSessionFactory.getSession();      //获取Session
	
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
	 * @Description 进行符合要求信息筛选
	 * @return 与result相关的字符串
	 */
	public String execute(){
		this.getPartMessage();      //调用方法，执行模糊查询
		return "success";
	}
	
	/**
	 * @Description 进行招聘信息数据表模糊查询
	 */
	private void getPartMessage(){
		final String hql = "from Job as j where j.jname like :name";
		Query query = session.createQuery(hql);      //创建Query对象
		query.setString("name", "%"+checkmess+"%");      //设置模糊查询
		list = query.list();
	}
}
