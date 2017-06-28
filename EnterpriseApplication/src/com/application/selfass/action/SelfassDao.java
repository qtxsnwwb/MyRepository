package com.application.selfass.action;

import com.application.login.action.*;

/**
 * 
 * @Description 自我评价DAO接口
 *
 */
public interface SelfassDao {
	/**
	 * @Description 添加自我评价
	 * @param secontent 内容
	 * @param user 用户信息
	 * @return 添加成功与否
	 */
	public boolean add(final String secontent, final User user);
	
	/**
	 * @Description 更新数据
	 * @param secontent 内容
	 * @param selfass 当前selfass对象
	 * @return
	 */
	public boolean update(final String secontent, final Selfass selfass);
}
