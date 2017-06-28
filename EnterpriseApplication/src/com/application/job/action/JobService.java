package com.application.job.action;

/**
 * 
 * @Description 招聘信息业务类
 *
 */
public class JobService {
	private JobDao jobDao = new JobDaoImpl();       //招聘信息DAO
	
	public JobDao getJobDao(){
		return jobDao;
	}
	public void setJobDao(JobDao jobDao){
		this.jobDao = jobDao;
	}
	
	/**
	 * @Description 添加招聘信息
	* @param jname 职位名称
	 * @param partment 所属部门
	 * @param worktype 工作性质
	 * @param salary 月薪范围
	 * @param jedu 学历要求
	 * @param pnum 招聘人数
	 * @param jperson 联系人
	 * @param jtel 手机
	 * @param jmail 邮箱
	 * @param message 详细信息
	 * @return 添加成功与否
	 */
	public boolean add(String jname, String partment, String worktype, String salary, String jedu, String pnum, String jperson, String jtel, String jmail, String message){
		return jobDao.add(jname, partment, worktype, salary, jedu, pnum, jperson, jtel, jmail, message);
	}
}
