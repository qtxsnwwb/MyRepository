package com.application.practice.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import com.application.login.action.*;

import org.apache.struts2.interceptor.*;

/**
 * 
 * @Description ʵϰ����POJO
 *
 */
public class Practice extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;          //�û�ID
	private String ptime;       //ʵϰʱ��
	private String porgan;       //ʵϰ��λ
	private String ppos;         //ʵϰ��λ
	private String pcontent;     //ʵϰ����
	private PracticeService practiceService = new PracticeService();      //ʵϰ����ҵ����
	
	private User user;      //�û���
	
	private HttpServletRequest request;       //����request����
	
	public Practice() {
		super();
	}
	public Practice(String ptime, String porgan, String ppos, String pcontent, User user) {
		super();
		this.ptime = ptime;
		this.porgan = porgan;
		this.ppos = ppos;
		this.pcontent = pcontent;
		this.user = user;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getPorgan() {
		return porgan;
	}
	public void setPorgan(String porgan) {
		this.porgan = porgan;
	}
	public String getPpos() {
		return ppos;
	}
	public void setPpos(String ppos) {
		this.ppos = ppos;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
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
	 * @Description ���ʵϰ����
	 * @return ��result��ط��ص��ַ���
	 */
	public String add(){
		//��ȡsession���Զ���
		HttpSession hSession = request.getSession();
		//��ȡuser����
		User user = (User) hSession.getAttribute("user");
		if(practiceService.add(ptime, porgan, ppos, pcontent, user)){
			return "success";
		}else{
			return "error";
		}
	}
	
}
