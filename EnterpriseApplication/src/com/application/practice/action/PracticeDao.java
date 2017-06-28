package com.application.practice.action;

import com.application.login.action.*;

/**
 * 
 * @Description ʵϰ����DAO�ӿ�
 *
 */
public interface PracticeDao {
	/**
	 * @Description ���ʵϰ����
	 * @param ptime ʵϰʱ��
	 * @param porgan ʵϰ��λ
	 * @param ppos ʵϰ��λ
	 * @param pcontent ʵϰ����
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String ptime, final String porgan, final String ppos, final String pcontent, final User user);
	
	/**
	 * @Description ��������
	 * @param ptime ʵϰʱ��
	 * @param porgan ʵϰ��λ
	 * @param ppos ʵϰ��λ
	 * @param pcontent ʵϰ����
	 * @param practice ����practice����
	 * @return ���³ɹ����
	 */
	public boolean update(final String ptime, final String porgan, final String ppos, final String pcontent, final Practice practice);
}
