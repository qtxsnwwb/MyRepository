package com.application.upload.action;

import java.io.*;

import com.application.login.action.*;

/**
 * 
 * @Description 上传文件业务类
 *
 */
public class UploadService {
	private UploadDao uploadDao = new UploadDaoImpl();      //上传文件DAO
	
	/**
	 * @Description 添加图片文件
	 * @param pic 图片文件
	 * @param picFileName 上传文件名称
	 * @param root 上传文件路径
	 * @param path 上传文件地址
	 * @param user 级联的user对象
	 * @return 添加成功与否
	 */
	public boolean add(File pic, String picFileName, String root, String path, User user){
		return uploadDao.add(pic, picFileName, root, path, user);
	}
	
	public UploadDao getUploadDao(){
		return uploadDao;
	}
	public void setUploadDao(UploadDao uploadDao){
		this.uploadDao = uploadDao;
	}
}
