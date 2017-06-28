package com.application.job.action;

import java.util.*;
import java.text.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.login.action.*;

/**
 * 
 * @Description 招聘信息DAO代理实现类
 *
 */
public class JobDaoImpl implements JobDao{
	/**
	 * @Description 添加招聘信息
	* @param jname 职位名称
	 * @param partment 所属部门
	 * @param worktype 工作性质
	 * @param salary 月薪范围
	 * @param jedu 学历要求
	 * @param pnum 招聘人数
	 * @param jperson 联系人
	 * @param jtel 手机
	 * @param jmail 邮箱
	 * @param message 详细信息
	 * @return 添加成功与否
	 */
	public boolean add(final String jname, final String partment, final String worktype, final String salary, final String jedu, final String pnum, final String jperson, final String jtel, final String jmail, final String message){
		List<Job> list = this.check(jname, salary, jedu, pnum);
		for(Job j: list){       //若数据库中已有该信息，则返回false
			if(j.getJname().equals(jname) && j.getSalary().equals(salary) && j.getJedu().equals(jedu) && j.getPnum().equals(pnum)){
				return false;
			}
		}
		
		//若数据库中无该信息，则添加
		Job job = new Job(jname,partment,worktype,salary,jedu,pnum,this.getCurrentTime(),jperson,jtel,jmail,message);       //创建要添加的对象
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		try{
			session.save(job);       //持久化操作
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //操作不成功，事务回滚
			return false;
		}
		trans.commit();      //提交事务
		HibernateSessionFactory.closeSession();      //关闭Session
		
		return true;     //添加成功，返回true
	}
	
	/**
	 * @Description 查看数据库中是否已有该招聘信息
	 * @param jname 职位名称
	 * @param salary 月薪范围
	 * @param jedu 学历要求
	 * @param pnum 招聘人数
	 * @return 查询结果
	 */
	private List<Job> check(final String jname, final String salary, final String jedu, final String pnum){
		//获取Session对象
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Job where JNAME=? and SALARY=? and JEDU=? and PNUM=?";
		//获取Query对象
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
