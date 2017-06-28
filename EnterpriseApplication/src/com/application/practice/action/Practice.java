package com.application.practice.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import com.application.login.action.*;

import org.apache.struts2.interceptor.*;

/**
 * 
 * @Description 实习经历POJO
 *
 */
public class Practice extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;          //用户ID
	private String ptime;       //实习时间
	private String porgan;       //实习单位
	private String ppos;         //实习岗位
	private String pcontent;     //实习内容
	private PracticeService practiceService = new PracticeService();      //实习经历业务类
	
	private User user;      //用户类
	
	private HttpServletRequest request;       //声明request对象
	
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
	 * @Description 添加实习经历
	 * @return 与result相关返回的字符串
	 */
	public String add(){
		//获取session属性对象
		HttpSession hSession = request.getSession();
		//获取user对象
		User user = (User) hSession.getAttribute("user");
		if(practiceService.add(ptime, porgan, ppos, pcontent, user)){
			return "success";
		}else{
			return "error";
		}
	}
	
}
