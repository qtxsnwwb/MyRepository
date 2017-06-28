package com.application.skill.action;

import com.application.login.action.*;

/**
 * 
 * @Description 技能证书DAO接口
 *
 */
public interface SkillDao {
	/**
	 * @Description 增加技能证书
	 * @param skcontent 内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(final String skcontent, final User user);
	
	/**
	 * @Description 更新数据
	 * @param skcontent 内容
	 * @param skill 当前skill对象
	 * @return 更新成功与否
	 */
	public boolean update(final String skcontent, final Skill skill);
}
