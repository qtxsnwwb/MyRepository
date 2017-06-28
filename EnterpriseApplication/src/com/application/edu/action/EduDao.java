package com.application.edu.action;

import java.sql.Timestamp;

import com.application.login.action.*;

/**
 * 
 * @Description 教育背景DAO接口
 *
 */
public interface EduDao {
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
	public boolean add(final Timestamp endTime, final String school, final String major, final String degree, final String subject, final User user);
	
	/**
	 * @Description 更新数据
	 * @param endTime 毕业时间
	 * @param school 学校
	 * @param major 专业
	 * @param degree 学位
	 * @param subject 主修课程
	 * @param edu 级联Edu对象
	 * @return 更新成功与否
	 */
	public boolean update(final Timestamp endTime, final String school, final String major, final String degree, final String subject, final Edu edu);
	
}
