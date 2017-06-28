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
 * @Description �ϴ��ļ�
 *
 */
public class Upload extends ActionSupport implements Serializable,ServletRequestAware{
	private String id;       //�ϴ��ļ�ID
	private File pic;        //�ϴ���ͼƬ�ļ�
	private String picFileName;      //�ļ�����
	private String picContentType;   //�ļ�����
	private String path;      //�ϴ���ͼƬ�ĵ�ַ
	private UploadService uploadService = new UploadService();     //�ϴ��ļ�ҵ����
	
	private User user;     //�û���
	
	private HttpServletRequest request;       //����request����
	
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
		//��ȡsession���Զ���
		HttpSession hSession = request.getSession();
		//��ȡuser����
		User user = (User) hSession.getAttribute("user");
		
		//�����ļ��ϴ�·��
		String root = ServletActionContext.getServletContext().getRealPath("/upload");
		//�����ϴ��ļ���ַ
		this.setPath(root+File.separator+picFileName);
		//System.out.println("�ļ��洢·��Ϊ��"+this.getPath());
		System.out.println("�ϴ�ͼƬ���ƣ�"+picFileName);
		System.out.println("�ϴ�ͼƬ���ͣ�"+picContentType);
		
		if(uploadService.add(pic, picFileName, root, path, user)){
			return "success";
		}else{
			return "error";
		}
	}
}
