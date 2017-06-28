package com.application.selfass.action;

import com.application.login.action.*;

/**
 * 
 * @Description 自我评价业务类
 *
 */
public class SelfassService {
	private SelfassDao selfassDao = new SelfassDaoImpl();      //自我评价DAO
	
	/**
	 * @Description 添加自我评价
	 * @param secontent 内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(String secontent, User user){
		return selfassDao.add(secontent,user);
	}
	
	public SelfassDao getSelfassDao(){
		return selfassDao;
	}
	public void setSelfassDao(SelfassDao selfassDao){
		this.selfassDao = selfassDao;
	}
}
