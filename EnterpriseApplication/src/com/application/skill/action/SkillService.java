package com.application.skill.action;

import com.application.login.action.*;

/**
 * 
 * @Description 技能证书业务类
 *
 */
public class SkillService {
	private SkillDao skillDao = new SkillDaoImpl();     //技能证书DAO
	
	/**
	 * @Description 增加技能证书
	 * @param skcontent 内容
	 * @return 增加成功与否
	 */
	public boolean add(String skcontent, User user){
		return skillDao.add(skcontent,user);
	}
	
	public SkillDao getSkillDao(){
		return skillDao;
	}
	public void setSkillDao(SkillDao skillDao){
		this.skillDao = skillDao;
	}
	
}
