package com.application.skill.action;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.edu.action.Edu;
import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.User;

/**
 * 
 * @Description 技能证书DAO代理实现类
 *
 */
public class SkillDaoImpl implements SkillDao{
	/**
	 * @Description 增加技能证书
	 * @param skcontent 内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(final String skcontent, final User user){
		List<Skill> list = this.check(user);
		for(Skill s: list){       
			if(!("".equals(s.getSkcontent()) || s.getSkcontent() == null)){       //若在数据库中已有该用户信息，则更新
				if(this.update(skcontent, s)){   //更新成功
					return true;
				}else{       //更新失败
					return false;
				}
			}
		}
		
		//若不存在，则创建
		Skill skill = new Skill(skcontent,user);      //创建要存储的对象
		
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		try{
			session.save(skill);       //持久化操作
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
	private List<Skill> check(final User user){
		String ID = user.getId();      //获取user对象的ID
		//获取Session对象
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Skill s inner join fetch s.user u where u.id= :userID";
		//获取Query对象
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description 更新数据
	 * @param skcontent 内容
	 * @param skill 当前skill对象
	 * @return 更新成功与否
	 */
	public boolean update(final String skcontent, final Skill skill){
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		skill.setSkcontent(skcontent);      //设置更新的数据
		try{
			session.update(skill);       //持久化操作
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
