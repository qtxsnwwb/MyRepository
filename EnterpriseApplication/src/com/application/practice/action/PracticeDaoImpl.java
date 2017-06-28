package com.application.practice.action;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.edu.action.Edu;
import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.User;

/**
 * 
 * @Description 实习经历DAO代理实现类
 *
 */
public class PracticeDaoImpl implements PracticeDao{
	/**
	 * @Description 添加实习经历
	 * @param ptime 实习时间
	 * @param porgan 实习单位
	 * @param ppos 实习岗位
	 * @param pcontent 实习内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(final String ptime, final String porgan, final String ppos, final String pcontent, final User user){
		List<Practice> list = this.check(user);
		for(Practice p: list){        
			if(!("".equals(p.getPorgan()) || p.getPorgan() == null)){       //若在数据库中已有该用户信息，则更新
				if(this.update(ptime, porgan, ppos, pcontent, p)){   //更新成功
					return true;
				}else{       //更新失败
					return false;
				}
			}
		}
		
		//若不存在，则创建
		Practice practice = new Practice(ptime,porgan,ppos,pcontent,user);      //创建要存储的对象
		
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		try{
			session.save(practice);       //持久化操作
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
	 * @Description 查看数据库中已有该实习经历
	 * @param user 级联user对象
	 * @return 查询结果
	 */
	private List<Practice> check(final User user){
		String ID = user.getId();      //获取user对象的ID
		//获取Session对象
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Practice p inner join fetch p.user u where u.id= :userID";
		//获取Query对象
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description 更新数据
	 * @param ptime 实习时间
	 * @param porgan 实习单位
	 * @param ppos 实习岗位
	 * @param pcontent 实习内容
	 * @param practice 当前practice对象
	 * @return 更新成功与否
	 */
	public boolean update(final String ptime, final String porgan, final String ppos, final String pcontent, final Practice practice){
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		practice.setPtime(ptime);
		practice.setPorgan(porgan);
		practice.setPpos(ppos);
		practice.setPcontent(pcontent);      //设置更新的数据
		try{
			session.update(practice);       //持久化操作
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
