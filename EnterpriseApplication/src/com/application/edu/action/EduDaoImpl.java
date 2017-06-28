package com.application.edu.action;

import java.sql.Timestamp;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.User;
import com.application.person.action.Person;

/**
 * 
 * @Description 教育背景DAO代理实现类
 *
 */
public class EduDaoImpl implements EduDao{
	/**
	 * @Description 添加教育背景
	 * @param endTime 毕业时间
	 * @param school 学校
	 * @param major 专业
	 * @param degree 学位
	 * @param subject 主修课程
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(final Timestamp endTime, final String school, final String major, final String degree, final String subject, final User user){
		List<Edu> list = this.check(user);
		for(Edu e: list){       
			if(!("".equals(e.getEndTime()) || e.getEndTime() == null)){       //若在数据库中已有该用户信息，则更新
				if(this.update(endTime, school, major, degree, subject, e)){   //更新成功
					return true;
				}else{       //更新失败
					return false;
				}
			}
		}
		
		//若不存在，则创建
		Edu edu = new Edu(endTime,school,major,degree,subject,user);      //创建要存储的对象
		
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		try{
			session.save(edu);       //持久化操作
		}catch(Exception ex){
			ex.printStackTrace();
			trans.rollback();      //操作不成功，事务回滚
			return false;
		}
		trans.commit();      //提交事务
		HibernateSessionFactory.closeSession();      //关闭Session
		
		return true;     //添加成功，返回true
	}
	
	/**
	 * @Description 查询教育背景是否已在数据库中
	 * @param user 级联user对象
	 * @return 查询结果
	 */
	private List<Edu> check(final User user){
		String ID = user.getId();      //获取user对象的ID
		//获取Session对象
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Edu e inner join fetch e.user u where u.id= :userID";
		//获取Query对象
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description 更新数据
	 * @param endTime 毕业时间
	 * @param school 学校
	 * @param major 专业
	 * @param degree 学位
	 * @param subject 主修课程
	 * @param edu 当前Edu对象
	 * @return 更新成功与否
	 */
	public boolean update(final Timestamp endTime, final String school, final String major, final String degree, final String subject, final Edu edu){
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		edu.setEndTime(endTime);
		edu.setSchool(school);
		edu.setMajor(major);
		edu.setDegree(degree);
		edu.setSubject(subject);      //设置更新的数据
		try{
			session.update(edu);       //持久化操作
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //操作不成功，事务回滚
			return false;
		}
		trans.commit();      //提交事务
		HibernateSessionFactory.closeSession();      //关闭Session
		
		return true;     //更新成功，返回true
	}
}
