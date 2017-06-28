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
 * @Description �û�������ϢPOJO
 *
 */
public class Person extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;      //�û�ID
	private String name;    //��ʵ����
	private String sex;     //�Ա�
	private Timestamp date;    //��������
	private String idCard;     //���֤����
	private String tel;     //�绰
	private String status;    //������ò
	private String mail;     //����
	private String address;     //סַ
	private String edu;      //ѧ��
	private String pos;      //ְλ
	private PersonService personService = new PersonService();      //�û�������Ϣҵ����
	
	private User user;       //�û���
	
	private HttpServletRequest request;      //����request����
	
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
	 * @Description ����û�������Ϣ
	 * @return ��result��ط��ص��ַ���
	 */
	public String add(){
		//��ȡsession���Զ���
		HttpSession hSession = request.getSession();
		//��ȡuser����
		User user = (User) hSession.getAttribute("user");
		if(personService.add(name, sex, date, idCard, tel, status, mail, address, edu, pos, user)){
			return "success";
		}else{
			return "error";
		}
	}
	
}
