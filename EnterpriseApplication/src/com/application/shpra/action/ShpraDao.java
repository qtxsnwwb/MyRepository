package com.application.shpra.action;

import com.application.login.action.*;

/**
 * 
 * @Description 校内实践DAO接口
 *
 */
public interface ShpraDao {
	/**
	 * @Description 添加校内实践
	 * @param stime 实践时间
	 * @param sorgan 实践单位
	 * @param sduty 实践职务
	 * @param scontent 实践内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(final String stime, final String sorgan, final String sduty, final String scontent, final User user);
	
	/**
	 * @Description 更新数据
	 * @param stime 实践时间
	 * @param sorgan 实践单位
	 * @param sduty 实践职务
	 * @param scontent 实践内容
	 * @param shpra 当前shpra对象
	 * @return 更新成功与否
	 */
	public boolean update(final String stime, final String sorgan, final String sduty, final String scontent, final Shpra shpra);
}
