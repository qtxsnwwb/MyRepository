package com.application.skill.action;

import com.application.login.action.*;

/**
 * 
 * @Description ����֤��DAO�ӿ�
 *
 */
public interface SkillDao {
	/**
	 * @Description ���Ӽ���֤��
	 * @param skcontent ����
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String skcontent, final User user);
	
	/**
	 * @Description ��������
	 * @param skcontent ����
	 * @param skill ��ǰskill����
	 * @return ���³ɹ����
	 */
	public boolean update(final String skcontent, final Skill skill);
}
