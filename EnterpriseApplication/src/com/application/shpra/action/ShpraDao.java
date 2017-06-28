package com.application.shpra.action;

import com.application.login.action.*;

/**
 * 
 * @Description У��ʵ��DAO�ӿ�
 *
 */
public interface ShpraDao {
	/**
	 * @Description ���У��ʵ��
	 * @param stime ʵ��ʱ��
	 * @param sorgan ʵ����λ
	 * @param sduty ʵ��ְ��
	 * @param scontent ʵ������
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String stime, final String sorgan, final String sduty, final String scontent, final User user);
	
	/**
	 * @Description ��������
	 * @param stime ʵ��ʱ��
	 * @param sorgan ʵ����λ
	 * @param sduty ʵ��ְ��
	 * @param scontent ʵ������
	 * @param shpra ��ǰshpra����
	 * @return ���³ɹ����
	 */
	public boolean update(final String stime, final String sorgan, final String sduty, final String scontent, final Shpra shpra);
}
