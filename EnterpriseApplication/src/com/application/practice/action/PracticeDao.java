package com.application.practice.action;

import com.application.login.action.*;

/**
 * 
 * @Description 实习经历DAO接口
 *
 */
public interface PracticeDao {
	/**
	 * @Description 添加实习经历
	 * @param ptime 实习时间
	 * @param porgan 实习单位
	 * @param ppos 实习岗位
	 * @param pcontent 实习内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(final String ptime, final String porgan, final String ppos, final String pcontent, final User user);
	
	/**
	 * @Description 更新数据
	 * @param ptime 实习时间
	 * @param porgan 实习单位
	 * @param ppos 实习岗位
	 * @param pcontent 实习内容
	 * @param practice 级联practice对象
	 * @return 更新成功与否
	 */
	public boolean update(final String ptime, final String porgan, final String ppos, final String pcontent, final Practice practice);
}
