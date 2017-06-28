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
 * @Description 教育背景POJO
 *
 */
public class Edu extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;          //用户ID
	private Timestamp endTime;       //毕业时间
	private String school;      //学校
	private String major;       //专业
	private String degree;      //学位
	private String subject;     //主修课程
	
	private EduService eduService = new EduService();      //教育背景业务类
	
	private User user;      //用户类
	
	private HttpServletRequest request;       //声明request对象
	
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
	 * @Description 添加教育背景
	 * @return 与result相关返回的字符串
	 */
	public String add(){
		//获取session属性对象
		HttpSession hSession = request.getSession();
		//获取user对象
		User user = (User) hSession.getAttribute("user");
		if(eduService.add(endTime, school, major, degree, subject, user)){
			return "success";
		}else{
			return "error";
		}
	}
}
