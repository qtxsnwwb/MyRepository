package com.application.shpra.action;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.edu.action.Edu;
import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.User;

/**
 * 
 * @Description 校内实践DAO代理实现类
 *
 */
public class ShpraDaoImpl implements ShpraDao{
	/**
	 * @Description 添加校内实践
	 * @param stime 实践时间
	 * @param sorgan 实践单位
	 * @param sduty 实践职务
	 * @param scontent 实践内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(final String stime, final String sorgan, final String sduty, final String scontent, final User user){
		List<Shpra> list = this.check(user);
		for(Shpra s: list){        
			if(!("".equals(s.getSorgan()) || s.getSorgan() == null)){       //若在数据库中已有该用户信息，则更新
				if(this.update(stime, sorgan, sduty, scontent, s)){   //更新成功
					return true;
				}else{       //更新失败
					return false;
				}
			}
		}
		
		//若不存在，则创建
		Shpra shpra = new Shpra(stime,sorgan,sduty,scontent,user);      //创建要存储的对象
		
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		try{
			session.save(shpra);       //持久化操作
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
	 * @Description 查看数据库是否已有该数据
	 * @param user 级联user对象
	 * @return 查询结果
	 */
	private List<Shpra> check(final User user){
		String ID = user.getId();      //获取user对象的ID
		//获取Session对象
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Shpra s inner join fetch s.user u where u.id= :userID";
		//获取Query对象
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description 更新数据
	 * @param stime 实践时间
	 * @param sorgan 实践单位
	 * @param sduty 实践职务
	 * @param scontent 实践内容
	 * @param shpra 当前shpra对象
	 * @return 更新成功与否
	 */
	public boolean update(final String stime, final String sorgan, final String sduty, final String scontent, final Shpra shpra){
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		shpra.setStime(stime);
		shpra.setSorgan(sorgan);
		shpra.setSduty(sduty);
		shpra.setScontent(scontent);     //设置更新的数据
		try{
			session.update(shpra);       //持久化操作
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
