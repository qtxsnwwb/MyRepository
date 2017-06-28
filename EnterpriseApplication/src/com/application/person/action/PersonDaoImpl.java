package com.application.person.action;

import java.sql.Timestamp;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.application.login.action.HibernateSessionFactory;
import com.application.login.action.*;

/**
 * 
 * @Description 用户个人信息DAO代理实现类
 *
 */
public class PersonDaoImpl implements PersonDao{
	/**
	 * @Description 添加用户个人信息
	 * @param name 真实姓名
	 * @param sex 性别
	 * @param date 出生日期
	 * @param idCard 身份证号码
	 * @param tel 电话
	 * @param status 政治面貌
	 * @param mail 邮箱
	 * @param address 住址
	 * @param edu 学历
	 * @param pos 职位
	 * @param user 级联的user对象
	 * @return 添加成功与否
	 */
	public boolean add(final String name, final String sex, final Timestamp date, final String idCard, final String tel, final String status, final String mail, final String address, final String edu, final String pos, final User user){
		List<Person> list = this.check(user);
		for(Person p: list){        
			if(!("".equals(p.getName()) || p.getName() == null)){       //若在数据库中已有该用户信息，则更新
				if(this.update(name, sex, date, idCard, tel, status, mail, address, edu, pos, p)){   //更新成功
					return true;
				}else{       //更新失败
					return false;
				}
			}
		}
		
		//若数据库中无该信息则创建
		Person person = new Person(name,sex,date,idCard,tel,status,mail,address,edu,pos,user);      //创建要存储的对象
		
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		try{
			session.save(person);       //持久化操作
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
	 * @Description 查询数据库中是否已有该用户信息
	 * @param user 级联的user对象
	 * @return 查询结果
	 */
	private List<Person> check(final User user){
		String ID = user.getId();      //获取user对象的ID
		//获取Session对象
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Person p inner join fetch p.user u where u.id= :userID";
		//获取Query对象
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description 更新数据
	 * @param name 真实姓名
	 * @param sex 性别
	 * @param date 出生日期
	 * @param idCard 身份证号码
	 * @param tel 电话
	 * @param status 政治面貌
	 * @param mail 邮箱
	 * @param address 住址
	 * @param edu 学历
	 * @param pos 职位
	 * @param person 当前的Person对象
	 * @return 更新成功与否
	 */
	public boolean update(final String name, final String sex, final Timestamp date, final String idCard, final String tel, final String status, final String mail, final String address, final String edu, final String pos, final Person person){
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		person.setName(name);
		person.setSex(sex);
		person.setDate(date);
		person.setIdCard(idCard);
		person.setTel(tel);
		person.setStatus(status);
		person.setMail(mail);
		person.setAddress(address);
		person.setEdu(edu);
		person.setPos(pos);         //设置更新的数据
		try{
			session.update(person);       //持久化操作
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
