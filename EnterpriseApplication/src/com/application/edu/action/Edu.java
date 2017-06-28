package com.application.edu.action;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.*;

import com.opensymphony.xwork2.*;
import com.application.login.action.*;

/**
 * 
 * @Description ��������POJO
 *
 */
public class Edu extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;          //�û�ID
	private Timestamp endTime;       //��ҵʱ��
	private String school;      //ѧУ
	private String major;       //רҵ
	private String degree;      //ѧλ
	private String subject;     //���޿γ�
	
	private EduService eduService = new EduService();      //��������ҵ����
	
	private User user;      //�û���
	
	private HttpServletRequest request;       //����request����
	
	public Edu(){
		super();
	}
	public Edu(Timestamp endTime, String school, String major, String degree, String subject, User user){
		super();
		this.endTime = endTime;
		this.school = school;
		this.major = major;
		this.degree = degree;
		this.subject = subject;
		this.user = user;
	}
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	 * @Description ��ӽ�������
	 * @return ��result��ط��ص��ַ���
	 */
	public String add(){
		//��ȡsession���Զ���
		HttpSession hSession = request.getSession();
		//��ȡuser����
		User user = (User) hSession.getAttribute("user");
		if(eduService.add(endTime, school, major, degree, subject, user)){
			return "success";
		}else{
			return "error";
		}
	}
}
