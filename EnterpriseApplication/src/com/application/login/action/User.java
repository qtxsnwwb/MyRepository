package com.application.login.action;

import java.io.Serializable;
import java.util.*;

//import org.apache.struts2.ServletActionContext;
import javax.servlet.http.*;
import org.apache.struts2.interceptor.*;
import org.hibernate.*;

import com.opensymphony.xwork2.*;
import com.application.pass.util.*;

/**
 * 
 * @Description �û�POJO
 *
 */
public class User extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;        //�û�ID
	private String userName;     //�û���
	private String userPass;     //����
	private Integer role;       //�û�Ȩ��
	UserService userService = new UserService();    //�û�ҵ����
	
	private boolean checkbox;     //��ס�����Ƿ�ѡ��
	
	private HttpServletRequest request;       //����request����
	private HttpServletResponse response;       //����response����
	
	public User(){
		super();
	}
	
	public User(String userName, String userPass, Integer role){
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.role = role;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Integer getRole(){
		return role;
	}
	public void setRole(Integer role){
		this.role = role;
	}
	public boolean getCheckbox(){
		return checkbox;
	}
	public void setCheckbox(boolean checkbox){
		this.checkbox = checkbox;
	}
	public HttpServletRequest getServletRequest(){
		return request;
	}
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	public HttpServletResponse getServletResponse(){
		return response;
	}
	public void setServletResponse(HttpServletResponse response){
		this.response = response;
	}
	
	
	/**
	 * @Description ��¼��֤
	 * @return ��struts.xml��result��ϵ���ַ���
	 */
	public String execute(){
		//����ס�����ѡ�У�ִ��Cookie����
		if(checkbox){
			Cookie nameCookie = new Cookie("loginName",userName);
			Cookie passCookie = new Cookie("passName",userPass);
			//����Cookie�洢����Ϊһ��
			nameCookie.setMaxAge(60*60*24*365);
			passCookie.setMaxAge(60*60*24*365);
			response.addCookie(nameCookie);
			response.addCookie(passCookie);
		}
				
		//�ж��û����������Ƿ�Ϊ��
		if((this.userName == null || "".equals(this.userName)) && (this.userPass == null || "".equals(this.userPass))){
			this.userName = "";
			this.userPass = "";
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				checkbox = true;      //���ݵ���¼ҳ�棬��Ϊ��ס������Ĭ�Ϲ�ѡ�ж�
				for(int i=0; i<cookies.length; i++){
					Cookie c = cookies[i];
					if(c.getName().equalsIgnoreCase("userName")){
						userName = c.getValue();
					}
					if(c.getName().equalsIgnoreCase("userPass")){
						userPass = c.getValue();
					}
				}
			}
		}
		
		//�������ݿ���֤��Ϣ
		List<User> list = userService.login(userName, userPass);
		for(User u: list){
			//��֤�ɹ�
			if(u.getUserName().equals(userName) && u.getUserPass().equals(MD5.getMD5(userPass))){
				//ȡ��IDֵ
				String ID = u.getId();
				//����IDֵ��ȡ����
				User user = this.getUser(ID);
				//��ȡSession����
				HttpSession hSession = request.getSession();
				//��user�������session����
				hSession.setAttribute("user", user);
				if(u.getRole() == 2){
					return "manager";
				}
				return "success";
			}
		}
		return "error";
	}
	
	/**
	 * @Description ע�����
	 * @return ��struts.xml��result��ϵ���ַ���
	 */
	public String register(){
		if(userService.register(userName, userPass)){
			return "success";
		}else{
			return "error";
		}
	}
	
	/**
	 * @Description ��IDֵȡ�ö�Ӧ��User����
	 * @param ID IDֵ
	 * @return ȡ�õ�User����
	 */
	private User getUser(String ID){
		Session session = HibernateSessionFactory.getSession();       //��ȡSession
		Transaction trans = session.beginTransaction();       //��ʼ����
		User user = (User) session.get(User.class, ID);       //����������ȡ�û�����
		trans.commit();     //�ύ����
		HibernateSessionFactory.closeSession();      //�ر�Session
		return user;
	}
}
