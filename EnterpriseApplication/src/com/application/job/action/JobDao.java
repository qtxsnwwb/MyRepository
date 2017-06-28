package com.application.job.action;

/**
 * 
 * @Description 招聘信息DAO接口
 *
 */
public interface JobDao {
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
	public boolean add(final String jname, final String partment, final String worktype, final String salary, final String jedu, final String pnum, final String jperson, final String jtel, final String jmail, final String message);
}
