package com.application.upload.action;

import com.application.login.action.*;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.*;

import org.apache.struts2.interceptor.*;

/**
 * 
 * @Description 上传文件
 *
 */
public class Upload extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;       //上传文件ID
	private File pic;        //上传的图片文件
	private String picFileName;      //文件名称
	private String picContentType;   //文件类型
	private String path;      //上传的图片的地址
	private UploadService uploadService = new UploadService();     //上传文件业务类
	
	private User user;     //用户类
	
	private HttpServletRequest request;       //声明request对象
	
	public Upload(){
		super();
	}
	public Upload(File pic, String picFileName, String picContentType, String path, User user){
		super();
		this.pic = pic;
		this.picFileName = picFileName;
		this.picContentType = picContentType;
		this.path = path;
		this.user = user;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public String getPicFileName(){
		return picFileName;
	}
	public void setPicFileName(String picFileName){
		this.picFileName = picFileName;
	}
	public String getPicContentType(){
		return picContentType;
	}
	public void setPicContentType(String picContentType){
		this.picContentType = picContentType;
	}
	public String getPath(){
		return path;
	}
	public void setPath(String path){
		this.path = path;
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
	
	public String execute(){
		//获取session属性对象
		HttpSession hSession = request.getSession();
		//获取user对象
		User user = (User) hSession.getAttribute("user");
		
		//设置文件上传路径
		String root = ServletActionContext.getServletContext().getRealPath("/upload");
		//设置上传文件地址
		this.setPath(root+File.separator+picFileName);
		//System.out.println("文件存储路径为："+this.getPath());
		System.out.println("上传图片名称："+picFileName);
		System.out.println("上传图片类型："+picContentType);
		
		if(uploadService.add(pic, picFileName, root, path, user)){
			return "success";
		}else{
			return "error";
		}
	}
}
