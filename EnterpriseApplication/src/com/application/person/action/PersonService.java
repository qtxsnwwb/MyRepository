package com.application.person.action;

import java.sql.Timestamp;
import com.application.login.action.*;

/**
 * 
 * @Description 用户个人信息业务类
 *
 */
public class PersonService {
	private PersonDao personDao = new PersonDaoImpl();
	
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
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(String name, String sex, Timestamp date, String idCard, String tel, String status, String mail, String address, String edu, String pos, User user){
		return personDao.add(name, sex, date, idCard, tel, status, mail, address, edu, pos, user);
	}
	
	public PersonDao getPersonDao(){
		return personDao;
	}
	public void setPersonDao(PersonDao personDao){
		this.personDao = personDao;
	}
}
