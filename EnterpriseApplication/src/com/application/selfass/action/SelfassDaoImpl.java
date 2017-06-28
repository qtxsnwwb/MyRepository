package com.application.selfass.action;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.edu.action.Edu;
import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.User;

/**
 * 
 * @Description 自我评价DAO代理实现类
 *
 */
public class SelfassDaoImpl implements SelfassDao{
	/**
	 * @Description 添加自我评价
	 * @param secontent 内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(final String secontent, final User user){
		List<Selfass> list = this.check(user);
		for(Selfass s: list){      
			if(!("".equals(s.getSecontent()) || s.getSecontent() == null)){       //若在数据库中已有该用户信息，则更新
				if(this.update(secontent, s)){   //更新成功
					return true;
				}else{       //更新失败
					return false;
				}
			}
		}
		
		//若不存在，则创建
		Selfass selfass = new Selfass(secontent,user);      //创建要存储的对象
		
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		try{
			session.save(selfass);       //持久化操作
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
	 * @Description 查看数据库中是否已有该内容
	 * @param user 级联user对象
	 * @return 查询结果
	 */
	private List<Selfass> check(final User user){
		String ID = user.getId();      //获取user对象的ID
		//获取Session对象
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Selfass s inner join fetch s.user u where u.id= :userID";
		//获取Query对象
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description 更新数据
	 * @param secontent 内容
	 * @param selfass 当前selfass对象
	 * @return 更新成功与否
	 */
	public boolean update(final String secontent, final Selfass selfass){
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		selfass.setSecontent(secontent);      //设置更新的数据
		try{
			session.update(selfass);       //持久化操作
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
