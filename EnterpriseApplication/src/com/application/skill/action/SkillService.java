package com.application.skill.action;

import com.application.login.action.*;

/**
 * 
 * @Description ����֤��ҵ����
 *
 */
public class SkillService {
	private SkillDao skillDao = new SkillDaoImpl();     //����֤��DAO
	
	/**
	 * @Description ���Ӽ���֤��
	 * @param skcontent ����
	 * @return ���ӳɹ����
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
