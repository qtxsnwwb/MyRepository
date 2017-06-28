package com.application.shpra.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.*;

import com.opensymphony.xwork2.*;
import com.application.login.action.*;

/**
 * 
 * @Description У��ʵ��POJO
 *
 */
public class Shpra extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;         //�û�ID
	private String stime;      //ʵ��ʱ��
	private String sorgan;      //ʵ����λ
	private String sduty;       //ʵ��ְ��
	private String scontent;    //ʵ������
	private ShpraService shpraService = new ShpraService();      //У��ʵ��ҵ����
	
	private User user;      //�û���
	
	private HttpServletRequest request;       //����request����
	
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
	 * @Description ���У��ʵ��
	 * @return ��result�йص��ַ���
	 */
	public String add(){
		//��ȡsession���Զ���
		HttpSession hSession = request.getSession();
		//��ȡuser����
		User user = (User) hSession.getAttribute("user");
		if(shpraService.add(stime, sorgan, sduty, scontent, user)){
			return "success";
		}else{
			return "error";
		}
	}
	
}
