package com.application.login.action;

import java.util.List;

/**
 * 
 * @Description 用户DAO接口
 *
 */
public interface UserDao {
	/**
	 * @Description 登录验证方法
	 * @param userName 用户名
	 * @param userPass 密码
	 * @return 查询结果
	 */
	public List<User> login(final String userName, final String userPass);
	
	/**
	 * @Description 执行注册方法
	 * @param userName 用户名
	 * @param userPass 密码
	 * @return 操作是否成功
	 */
	public boolean register(final String userName, final String userPass);
}
