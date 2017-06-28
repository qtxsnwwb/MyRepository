package com.application.upload.action;

import java.io.*;

import com.application.login.action.*;

/**
 * 
 * @Description �ϴ��ļ�ҵ����
 *
 */
public class UploadService {
	private UploadDao uploadDao = new UploadDaoImpl();      //�ϴ��ļ�DAO
	
	/**
	 * @Description ���ͼƬ�ļ�
	 * @param pic ͼƬ�ļ�
	 * @param picFileName �ϴ��ļ�����
	 * @param root �ϴ��ļ�·��
	 * @param path �ϴ��ļ���ַ
	 * @param user ������user����
	 * @return ��ӳɹ����
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
