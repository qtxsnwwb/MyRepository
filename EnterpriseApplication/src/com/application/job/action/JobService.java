package com.application.job.action;

/**
 * 
 * @Description ��Ƹ��Ϣҵ����
 *
 */
public class JobService {
	private JobDao jobDao = new JobDaoImpl();       //��Ƹ��ϢDAO
	
	public JobDao getJobDao(){
		return jobDao;
	}
	public void setJobDao(JobDao jobDao){
		this.jobDao = jobDao;
	}
	
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
	public boolean add(String jname, String partment, String worktype, String salary, String jedu, String pnum, String jperson, String jtel, String jmail, String message){
		return jobDao.add(jname, partment, worktype, salary, jedu, pnum, jperson, jtel, jmail, message);
	}
}
