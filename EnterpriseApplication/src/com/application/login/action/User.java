package com.application.login.action;

import java.io.Serializable;
import java.util.*;

//import org.apache.struts2.ServletActionContext;
import javax.servlet.http.*;
import org.apache.struts2.interceptor.*;
import org.hibernate.*;

import com.opensymphony.xwork2.*;
import com.application.pass.util.*;

/**
 * 
 * @Description 用户POJO
 *
 */
public class User extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;        //用户ID
	private String userName;     //用户名
	private String userPass;     //密码
	private Integer role;       //用户权限
	UserService userService = new UserService();    //用户业务类
	
	private boolean checkbox;     //记住密码是否选中
	
	private HttpServletRequest request;       //声明request对象
	private HttpServletResponse response;       //声明response对象
	
	public User(){
		super();
	}
	
	public User(String userName, String userPass, Integer role){
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.role = role;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Integer getRole(){
		return role;
	}
	public void setRole(Integer role){
		this.role = role;
	}
	public boolean getCheckbox(){
		return checkbox;
	}
	public void setCheckbox(boolean checkbox){
		this.checkbox = checkbox;
	}
	public HttpServletRequest getServletRequest(){
		return request;
	}
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	public HttpServletResponse getServletResponse(){
		return response;
	}
	public void setServletResponse(HttpServletResponse response){
		this.response = response;
	}
	
	
	/**
	 * @Description 登录验证
	 * @return 和struts.xml的result联系的字符串
	 */
	public String execute(){
		//若记住密码框被选中，执行Cookie操作
		if(checkbox){
			Cookie nameCookie = new Cookie("loginName",userName);
			Cookie passCookie = new Cookie("passName",userPass);
			//设置Cookie存储期限为一年
			nameCookie.setMaxAge(60*60*24*365);
			passCookie.setMaxAge(60*60*24*365);
			response.addCookie(nameCookie);
			response.addCookie(passCookie);
		}
				
		//判断用户名和密码是否为空
		if((this.userName == null || "".equals(this.userName)) && (this.userPass == null || "".equals(this.userPass))){
			this.userName = "";
			this.userPass = "";
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				checkbox = true;      //传递到登录页面，作为记住密码框的默认勾选判断
				for(int i=0; i<cookies.length; i++){
					Cookie c = cookies[i];
					if(c.getName().equalsIgnoreCase("userName")){
						userName = c.getValue();
					}
					if(c.getName().equalsIgnoreCase("userPass")){
						userPass = c.getValue();
					}
				}
			}
		}
		
		//加载数据库验证信息
		List<User> list = userService.login(userName, userPass);
		for(User u: list){
			//验证成功
			if(u.getUserName().equals(userName) && u.getUserPass().equals(MD5.getMD5(userPass))){
				//取得ID值
				String ID = u.getId();
				//根据ID值获取对象
				User user = this.getUser(ID);
				//获取Session对象
				HttpSession hSession = request.getSession();
				//将user对象存入session属性
				hSession.setAttribute("user", user);
				if(u.getRole() == 2){
					return "manager";
				}
				return "success";
			}
		}
		return "error";
	}
	
	/**
	 * @Description 注册操作
	 * @return 和struts.xml的result联系的字符串
	 */
	public String register(){
		if(userService.register(userName, userPass)){
			return "success";
		}else{
			return "error";
		}
	}
	
	/**
	 * @Description 按ID值取得对应的User对象
	 * @param ID ID值
	 * @return 取得的User对象
	 */
	private User getUser(String ID){
		Session session = HibernateSessionFactory.getSession();       //获取Session
		Transaction trans = session.beginTransaction();       //开始事务
		User user = (User) session.get(User.class, ID);       //根据主键获取用户对象
		trans.commit();     //提交事务
		HibernateSessionFactory.closeSession();      //关闭Session
		return user;
	}
}
