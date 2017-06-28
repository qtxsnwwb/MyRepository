package com.application.message.action;

import java.util.*;

import com.application.login.action.*;
import com.application.job.action.*;

import org.hibernate.*;


/**
 * 
 * @Description 普通用户遍历招聘职位数据表类
 *
 */
public class ShowJob {
	private Integer id;
	private String checkmess;       //查询信息
	Session session = HibernateSessionFactory.getSession();      //获取Session对象
	private List<Job> list;     //创建List对象
	
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
	 * @Description 根据指定用户对象取得该用户全部职位信息
	 */
	private void getWholeJobMessage(){
		final String hql = "from Job"; 
		Query query = session.createQuery(hql);     //创建Query对象
		list = query.list();      //获取查询结果
	}
	
	/**
	 * @Description 查询全部职位
	 * @return 与result相关的字符串
	 */
	public String checkJob(){
		this.getWholeJobMessage();      //调用方法，获取全部职位信息
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
	
	/**
	 * @Description 执行模糊查询
	 * @return 与result相关的字符串
	 */
	public String execute(){
		this.getPartMessage();     //执行模糊查询
		return "success";
	}
}
