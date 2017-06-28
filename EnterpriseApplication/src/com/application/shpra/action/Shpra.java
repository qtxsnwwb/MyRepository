package com.application.shpra.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.*;

import com.opensymphony.xwork2.*;
import com.application.login.action.*;

/**
 * 
 * @Description 校内实践POJO
 *
 */
public class Shpra extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;         //用户ID
	private String stime;      //实践时间
	private String sorgan;      //实践单位
	private String sduty;       //实践职务
	private String scontent;    //实践内容
	private ShpraService shpraService = new ShpraService();      //校内实践业务类
	
	private User user;      //用户类
	
	private HttpServletRequest request;       //声明request对象
	
	public Shpra() {
		super();
	}
	public Shpra(String stime, String sorgan, String sduty, String scontent, User user) {
		super();
		this.stime = stime;
		this.sorgan = sorgan;
		this.sduty = sduty;
		this.scontent = scontent;
		this.user = user;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getSorgan() {
		return sorgan;
	}
	public void setSorgan(String sorgan) {
		this.sorgan = sorgan;
	}
	public String getSduty() {
		return sduty;
	}
	public void setSduty(String sduty) {
		this.sduty = sduty;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
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
	 * @Description 添加校内实践
	 * @return 与result有关的字符串
	 */
	public String add(){
		//获取session属性对象
		HttpSession hSession = request.getSession();
		//获取user对象
		User user = (User) hSession.getAttribute("user");
		if(shpraService.add(stime, sorgan, sduty, scontent, user)){
			return "success";
		}else{
			return "error";
		}
	}
	
}
