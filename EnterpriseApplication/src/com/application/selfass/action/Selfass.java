package com.application.selfass.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import com.application.login.action.*;

import org.apache.struts2.interceptor.*;

/**
 * 
 * @Description ��������POJO
 *
 */
public class Selfass extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;         //�û�ID
	private String secontent;       //����
	private SelfassService selfassService = new SelfassService();       //��������ҵ����
	
	private User user;      //�û���
	
	private HttpServletRequest request;      //����request����
	
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
	 * @Description �����������
	 * @return ��result��ص��ַ���
	 */
	public String add(){
		//��ȡsession���Զ���
		HttpSession hSession = request.getSession();
		//��ȡuser����
		User user = (User) hSession.getAttribute("user");
		if(selfassService.add(secontent,user)){
			return "success";
		}else{
			return "error";
		}
	}
}
