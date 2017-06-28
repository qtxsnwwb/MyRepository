package com.application.message.action;

import java.util.*;

import com.application.login.action.*;
import com.application.job.action.*;

import org.hibernate.*;

/**
 * 
 * @Description 遍历招聘信息数据表中信息
 *
 */
public class ConsultJob {
	private Integer id;
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
	 * @Description 删除指定职位
	 * @return 与result相关的字符串
	 */
	public String delJob(){
		Transaction trans = session.beginTransaction();     //开启一个事务
		Job job = (Job) session.get(Job.class, id);
		try{
			session.delete(job);       //持久化操作
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //操作不成功，事务回滚
		}
		trans.commit();      //提交事务
		//HibernateSessionFactory.closeSession();      //关闭Session
		this.checkJob();      //调用方法，获取全部职位信息
		return "success";
	}
}
