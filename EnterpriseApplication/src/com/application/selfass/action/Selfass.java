package com.application.selfass.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import com.application.login.action.*;

import org.apache.struts2.interceptor.*;

/**
 * 
 * @Description 自我评价POJO
 *
 */
public class Selfass extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;         //用户ID
	private String secontent;       //内容
	private SelfassService selfassService = new SelfassService();       //自我评价业务类
	
	private User user;      //用户类
	
	private HttpServletRequest request;      //声明request对象
	
	public Selfass() {
		super();
	}
	public Selfass(String secontent, User user) {
		super();
		this.secontent = secontent;
		this.user = user;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSecontent() {
		return secontent;
	}
	public void setSecontent(String secontent) {
		this.secontent = secontent;
	}
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user = user;
	}
	public HttpServletRequest getServletRequest(){
		return request;
	}
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	
	/**
	 * @Description 添加自我评价
	 * @return 与result相关的字符串
	 */
	public String add(){
		//获取session属性对象
		HttpSession hSession = request.getSession();
		//获取user对象
		User user = (User) hSession.getAttribute("user");
		if(selfassService.add(secontent,user)){
			return "success";
		}else{
			return "error";
		}
	}
}
