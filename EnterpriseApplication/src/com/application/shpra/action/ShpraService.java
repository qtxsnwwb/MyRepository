package com.application.shpra.action;

import com.application.login.action.*;

/**
 * 
 * @Description 校内实践业务类
 *
 */
public class ShpraService {
	private ShpraDao shpraDao = new ShpraDaoImpl();     //校内实践DAO
	
	/**
	 * @Description 添加校内实践
	 * @param stime 实践时间
	 * @param sorgan 实践单位
	 * @param sduty 实践职务
	 * @param scontent 实践内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(String stime, String sorgan, String sduty, String scontent, User user){
		return shpraDao.add(stime, sorgan, sduty, scontent, user);
	}
	
	public ShpraDao getShpraDao(){
		return shpraDao;
	}
	public void setShpraDao(ShpraDao shpraDao){
		this.shpraDao = shpraDao;
	}
}
