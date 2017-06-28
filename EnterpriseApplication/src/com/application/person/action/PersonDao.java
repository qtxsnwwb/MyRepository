package com.application.person.action;

import java.sql.Timestamp;

import com.application.login.action.*;

/**
 * 
 * @Description 个人信息DAO接口
 *
 */
public interface PersonDao {
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
	public boolean add(final String name, final String sex, final Timestamp date, final String idCard, final String tel, final String status, final String mail, final String address, final String edu, final String pos, final User user);
	
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
	public boolean update(final String name, final String sex, final Timestamp date, final String idCard, final String tel, final String status, final String mail, final String address, final String edu, final String pos, final Person person);
	
}
