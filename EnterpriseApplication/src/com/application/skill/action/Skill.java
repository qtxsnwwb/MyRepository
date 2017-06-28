package com.application.skill.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import com.application.login.action.*;

import org.apache.struts2.interceptor.*;

/**
 * 
 * @Description ����֤��POJO
 *
 */
public class Skill extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;         //�û�ID
	private String skcontent;       //����       //�ı���
	private SkillService skillService = new SkillService();      //����֤��ҵ����
	
	private User user;      //�û���
	
	private HttpServletRequest request;       //����request����
	
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
	 * @Description ���Ӽ���֤��
	 * @return ��result��ص��ַ���
	 */
	public String add(){
		//��ȡsession���Զ���
		HttpSession hSession = request.getSession();
		//��ȡuser����
		User user = (User) hSession.getAttribute("user");
		if(skillService.add(skcontent,user)){
			return "success";
		}else{
			return "error";
		}
	}
}
