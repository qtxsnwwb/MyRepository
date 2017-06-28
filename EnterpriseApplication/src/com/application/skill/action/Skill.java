package com.application.skill.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import com.application.login.action.*;

import org.apache.struts2.interceptor.*;

/**
 * 
 * @Description 技能证书POJO
 *
 */
public class Skill extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;         //用户ID
	private String skcontent;       //内容       //文本域
	private SkillService skillService = new SkillService();      //技能证书业务类
	
	private User user;      //用户类
	
	private HttpServletRequest request;       //声明request对象
	
	public Skill() {
		super();
	}
	public Skill(String skcontent, User user) {
		super();
		this.skcontent = skcontent;
		this.user = user;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSkcontent() {
		return skcontent;
	}
	public void setSkcontent(String skcontent) {
		this.skcontent = skcontent;
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
	 * @Description 增加技能证书
	 * @return 与result相关的字符串
	 */
	public String add(){
		//获取session属性对象
		HttpSession hSession = request.getSession();
		//获取user对象
		User user = (User) hSession.getAttribute("user");
		if(skillService.add(skcontent,user)){
			return "success";
		}else{
			return "error";
		}
	}
}
