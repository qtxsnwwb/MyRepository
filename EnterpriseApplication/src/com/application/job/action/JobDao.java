package com.application.job.action;

/**
 * 
 * @Description ��Ƹ��ϢDAO�ӿ�
 *
 */
public interface JobDao {
	/**
	 * @Description �����Ƹ��Ϣ
	 * @param jname ְλ����
	 * @param partment ��������
	 * @param worktype ��������
	 * @param salary ��н��Χ
	 * @param jedu ѧ��Ҫ��
	 * @param pnum ��Ƹ����
	 * @param jperson ��ϵ��
	 * @param jtel �ֻ�
	 * @param jmail ����
	 * @param message ��ϸ��Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(final String jname, final String partment, final String worktype, final String salary, final String jedu, final String pnum, final String jperson, final String jtel, final String jmail, final String message);
}
