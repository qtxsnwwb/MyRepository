package com.application.edu.action;

import java.sql.Timestamp;
import com.application.login.action.*;

/**
 * 
 * @Description 教育背景业务类
 *
 */
public class EduService {
	private EduDao eduDao = new EduDaoImpl();      //教育背景DAO
	
	/**
	 * @Description 添加教育背景
	 * @param endTime 毕业时间
	 * @param school 学校
	 * @param major 专业
	 * @param degree 学位
	 * @param subject 主修课程
	 * @return 添加成功与否
	 */
	public boolean add(Timestamp endTime, String school, String major, String degree, String subject, User user){
		return eduDao.add(endTime, school, major, degree, subject, user);
	}
	
	public EduDao getEduDao(){
		return eduDao;
	}
	public void setEduDao(EduDao eduDao){
		this.eduDao = eduDao;
	}
}
