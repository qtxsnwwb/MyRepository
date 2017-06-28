package com.application.upload.action;

import java.io.File;

import com.application.login.action.*;

/**
 * 
 * @Description 上传文件DAO接口
 *
 */
public interface UploadDao {
	/**
	 * @Description 添加图片文件路径
	 * @param pic 图片文件
	 * @param picFileName 上传的文件名称
	 * @param root 上传的文件路径
	 * @param path 上传的文件地址
	 * @param user 级联的user对象
	 * @return 添加成功与否
	 */
	public boolean add(File pic, String picFileName, String root, final String path, final User user);
	
	/**
	 * @Description 更新操作
	 * @param path 上传的文件地址
	 * @param upload 当前的upload对象 
	 * @return 更新成功与否
	 */
	public boolean update(final String path, final Upload upload);
}
