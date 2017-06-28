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
 * @Description 上传文件DAO代理实现类
 *
 */
public class UploadDaoImpl implements UploadDao{
	/**
	 * @Description 添加图片文件路径
	 * @param pic 图片文件
	 * @param picFileName 上传的文件名称
	 * @param root 上传的文件路径
	 * @param path 上传的文件地址
	 * @return 添加成功与否
	 */
	public boolean add(File pic, String picFileName, String root, final String path, final User user){
		//System.out.println("上传文件存储目录为："+root);
		File file = new File(root,picFileName);
		try{
			InputStream fis = new FileInputStream(pic);      //定义输入流
			OutputStream fos = new FileOutputStream(file);        //定义输出流
			file.getParentFile().mkdirs();      //创建目录
			System.out.println("正在上传"+pic.getName());
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
			return false;       //上传产生错误，返回false
		}
		
		//将图片地址存入数据库
		return this.save(path,user);
	}
	
	/**
	 * @Description 将上传的文件地址存入数据库
	 * @param path 上传的文件地址
	 * @param user 级联的user对象
	 * @return 存储成功与否
	 */
	private boolean save(final String path, final User user){
		List<Upload> list = this.check(user);
		for(Upload u: list){     //若数据库中已有该存储地址，返回false
			if(!("".equals(u.getPath()) || u.getPath() == null)){       //若在数据库中已有该用户信息，则更新
				if(this.update(path, u)){   //更新成功
					return true;
				}else{       //更新失败
					return false;
				}
			}
		}
			
		//若数据库中无该地址，则添加
		Upload upload = new Upload();      //创建需要添加入数据库的对象
		upload.setPath(path);
		upload.setUser(user);
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		try{
			session.save(upload);       //持久化操作
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //操作不成功，事务回滚
			return false;
		}
		trans.commit();      //提交事务
		HibernateSessionFactory.closeSession();      //关闭Session
			
		return true;     //存储成功
	}
		
		
	/**
	 * @Description 查看数据库中是否已有该文件地址
	 * @param user 级联user对象
	 * @return 查询结果
	 */
	private List<Upload> check(final User user){
		String ID = user.getId();      //获取user对象的ID
		//获取Session对象
		Session session = HibernateSessionFactory.getSession();
		final String hql = "from Upload p inner join fetch p.user u where u.id= :userID";
		//获取Query对象
		Query query = session.createQuery(hql);
		query.setString("userID", ID);
		return query.list();
	}
	
	/**
	 * @Description 更新操作
	 * @param path 上传的文件地址
	 * @param upload 当前的upload对象 
	 * @return 更新成功与否
	 */
	public boolean update(final String path, final Upload upload){
		Session session = HibernateSessionFactory.getSession();     //获取Session对象
		Transaction trans = session.beginTransaction();      //开始一个事务
		upload.setPath(path);      //设置更新的数据
		try{
			session.update(upload);       //持久化操作
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();      //操作不成功，事务回滚
			return false;
		}
		trans.commit();      //提交事务
		HibernateSessionFactory.closeSession();      //关闭Session
		
		return true;     //更新成功，返回true
	}
}
