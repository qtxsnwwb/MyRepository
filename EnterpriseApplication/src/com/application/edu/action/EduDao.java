package com.application.edu.action;

import java.sql.Timestamp;

import com.application.login.action.*;

/**
 * 
 * @Description ��������DAO�ӿ�
 *
 */
public interface EduDao {
	/**
	 * @Description ��ӽ�������
	 * @param endTime ��ҵʱ��
	 * @param school ѧУ
	 * @param major רҵ
	 * @param degree ѧλ
	 * @param subject ���޿γ�
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final Timestamp endTime, final String school, final String major, final String degree, final String subject, final User user);
	
	/**
	 * @Description ��������
	 * @param endTime ��ҵʱ��
	 * @param school ѧУ
	 * @param major רҵ
	 * @param degree ѧλ
	 * @param subject ���޿γ�
	 * @param edu ����Edu����
	 * @return ���³ɹ����
	 */
	public boolean update(final Timestamp endTime, final String school, final String major, final String degree, final String subject, final Edu edu);
	
}
