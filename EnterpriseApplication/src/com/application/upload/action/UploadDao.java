package com.application.upload.action;

import java.io.File;

import com.application.login.action.*;

/**
 * 
 * @Description �ϴ��ļ�DAO�ӿ�
 *
 */
public interface UploadDao {
	/**
	 * @Description ���ͼƬ�ļ�·��
	 * @param pic ͼƬ�ļ�
	 * @param picFileName �ϴ����ļ�����
	 * @param root �ϴ����ļ�·��
	 * @param path �ϴ����ļ���ַ
	 * @param user ������user����
	 * @return ��ӳɹ����
	 */
	public boolean add(File pic, String picFileName, String root, final String path, final User user);
	
	/**
	 * @Description ���²���
	 * @param path �ϴ����ļ���ַ
	 * @param upload ��ǰ��upload���� 
	 * @return ���³ɹ����
	 */
	public boolean update(final String path, final Upload upload);
}
