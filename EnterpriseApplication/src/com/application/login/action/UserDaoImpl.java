package com.application.login.action;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.pass.util.*;

/**
 * 
 * @Description 用户DAO代理实现类
 *
 */
public class UserDaoImpl implements UserDao{
	/**
	 * @Description 登录验证方法
	 * @param userName 用户名
	 * @param userPass 密码
	 * @return 查询结果
	 */
	public List<User> login(final String userName, final String userPass){
		List<User> list = this.check(userName);       //获取查询结果
		for(User u: list){
			if("".equals(u.getUserPass()) || u.getUserPass() == null){
				return null;        //若不存在该密码，返回为空 
			}
			if(u.getUserPass().equals(MD5.getMD5(userPass))){
				return list;
			}
		}
		return null;
	}
	
	/**
	 * @Description 执行注册方法
	 * @param userName 用户名
	 * @param userPass 密码
	 * @return 操作是否成功
	 */
	public boolean register(final String userName, final String userPass){
		//先进行登录验证，看是否用户名和密码已存在
		List<User> list = this.check(userName);
		for(User u: list){
			if(u.getUserName().equals(userName) || u.getUserPass().equals(MD5.getMD5(userPass))){
				return false;
			}
		}
		
		//用户名和密码不存在，进行注册
		User users = new User();    //创建要存入的对象
		users.setUserName(userName);
		users.setUserPass(MD5.getMD5(userPass));
		users.setRole(1);
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		try{
			session.save(users);       //持久化操作
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //操作不成功，事务回滚
			return false;
		}
		trans.commit();      //提交事务
		session.close();      //关闭Session
		
		return true;
	}
	
	/**
	 * @Description 查看密码是否存在
	 * @param userName 用户名
	 * @return 查询结果
	 */
	private List<User> check(final String userName){
		//获取Session对象
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from User where USERNAME=?";
		//获取Query对象
		Query query = session.createQuery(hql);
		query.setString(0, userName);
		return query.list();
	}
}
