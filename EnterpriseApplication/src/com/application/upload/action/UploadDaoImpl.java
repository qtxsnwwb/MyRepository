package com.application.upload.action;

import java.io.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
//import org.apache.commons.io.IOUtils;
import org.hibernate.Transaction;

import com.application.login.action.*;

/**
 * 
 * @Description �ϴ��ļ�DAO����ʵ����
 *
 */
public class UploadDaoImpl implements UploadDao{
	/**
	 * @Description ���ͼƬ�ļ�·��
	 * @param pic ͼƬ�ļ�
	 * @param picFileName �ϴ����ļ�����
	 * @param root �ϴ����ļ�·��
	 * @param path �ϴ����ļ���ַ
	 * @return ��ӳɹ����
	 */
	public boolean add(File pic, String picFileName, String root, final String path, final User user){
		//System.out.println("�ϴ��ļ��洢Ŀ¼Ϊ��"+root);
		File file = new File(root,picFileName);
		try{
			InputStream fis = new FileInputStream(pic);      //����������
			OutputStream fos = new FileOutputStream(file);        //���������
			file.getParentFile().mkdirs();      //����Ŀ¼
			System.out.println("�����ϴ�"+pic.getName());
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer,0,buffer.length)) != -1){
				fos.write(buffer);
			}
			//IOUtils.copy(fis, fos);
			fos.flush();
			fos.close();
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
			return false;       //�ϴ��������󣬷���false
		}
		
		//��ͼƬ��ַ�������ݿ�
		return this.save(path,user);
	}
	
	/**
	 * @Description ���ϴ����ļ���ַ�������ݿ�
	 * @param path �ϴ����ļ���ַ
	 * @param user ������user����
	 * @return �洢�ɹ����
	 */
	private boolean save(final String path, final User user){
		List<Upload> list = this.check(user);
		for(Upload u: list){     //�����ݿ������иô洢��ַ������false
			if(!("".equals(u.getPath()) || u.getPath() == null)){       //�������ݿ������и��û���Ϣ�������
				if(this.update(path, u)){   //���³ɹ�
					return true;
				}else{       //����ʧ��
					return false;
				}
			}
		}
			
		//�����ݿ����޸õ�ַ�������
		Upload upload = new Upload();      //������Ҫ��������ݿ�Ķ���
		upload.setPath(path);
		upload.setUser(user);
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		try{
			session.save(upload);       //�־û�����
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //�������ɹ�������ع�
			return false;
		}
		trans.commit();      //�ύ����
		HibernateSessionFactory.closeSession();      //�ر�Session
			
		return true;     //�洢�ɹ�
	}
		
		
	/**
	 * @Description �鿴���ݿ����Ƿ����и��ļ���ַ
	 * @param user ����user����
	 * @return ��ѯ���
	 */
	private List<Upload> check(final User user){
		String ID = user.getId();      //��ȡuser�����ID
		//��ȡSession����
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Upload p inner join fetch p.user u where u.id= :userID";
		//��ȡQuery����
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description ���²���
	 * @param path �ϴ����ļ���ַ
	 * @param upload ��ǰ��upload���� 
	 * @return ���³ɹ����
	 */
	public boolean update(final String path, final Upload upload){
		Session session = HibernateSessionFactory.getSession();     //��ȡSession����
		Transaction trans = session.beginTransaction();      //��ʼһ������
		upload.setPath(path);      //���ø��µ�����
		try{
			session.update(upload);       //�־û�����
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //�������ɹ�������ع�
			return false;
		}
		trans.commit();      //�ύ����
		HibernateSessionFactory.closeSession();      //�ر�Session
		
		return true;     //���³ɹ�������true
	}
}
