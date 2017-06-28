package com.application.practice.action;

import com.application.login.action.*;

/**
 * 
 * @Description 实习经历业务类
 *
 */
public class PracticeService{
	private PracticeDao practiceDao = new PracticeDaoImpl();      //实习经历DAO
	
	/**
	 * @Description 添加实习经历
	 * @param ptime 实习时间
	 * @param porgan 实习单位
	 * @param ppos 实习岗位
	 * @param pcontent 实习内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(String ptime, String porgan, String ppos, String pcontent, User user){
		return practiceDao.add(ptime, porgan, ppos, pcontent, user);
	}
	
	public PracticeDao getPracticeDao(){
		return practiceDao;
	}
	public void setPracticeDao(PracticeDao practiceDao){
		this.practiceDao = practiceDao;
	}
}
