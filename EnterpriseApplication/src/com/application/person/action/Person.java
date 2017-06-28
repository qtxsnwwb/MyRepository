package com.application.person.action;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import com.application.login.action.*;

import org.apache.struts2.interceptor.*;

/**
 * 
 * @Description 用户个人信息POJO
 *
 */
public class Person extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;      //用户ID
	private String name;    //真实姓名
	private String sex;     //性别
	private Timestamp date;    //出生日期
	private String idCard;     //身份证号码
	private String tel;     //电话
	private String status;    //政治面貌
	private String mail;     //邮箱
	private String address;     //住址
	private String edu;      //学历
	private String pos;      //职位
	private PersonService personService = new PersonService();      //用户个人信息业务类
	
	private User user;       //用户类
	
	private HttpServletRequest request;      //声明request对象
	
	public Person(){
		super();
	}
	public Person(String name, String sex, Timestamp date, String idCard, String tel, String status, String mail, String address, String edu, String pos, User user) {
		super();
		this.name = name;
		this.sex = sex;
		this.date = date;
		this.idCard = idCard;
		this.tel = tel;
		this.status = status;
		this.mail = mail;
		this.address = address;
		this.edu = edu;
		this.pos = pos;
		this.user = user;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public HttpServletRequest getServletRequest(){
		return request;
	}
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	
	/**
	 * @Description 添加用户个人信息
	 * @return 与result相关返回的字符串
	 */
	public String add(){
		//获取session属性对象
		HttpSession hSession = request.getSession();
		//获取user对象
		User user = (User) hSession.getAttribute("user");
		if(personService.add(name, sex, date, idCard, tel, status, mail, address, edu, pos, user)){
			return "success";
		}else{
			return "error";
		}
	}
	
}
