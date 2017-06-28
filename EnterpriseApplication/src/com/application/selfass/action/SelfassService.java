package com.application.selfass.action;

import com.application.login.action.*;

/**
 * 
 * @Description ��������ҵ����
 *
 */
public class SelfassService {
	private SelfassDao selfassDao = new SelfassDaoImpl();      //��������DAO
	
	/**
	 * @Description �����������
	 * @param secontent ����
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(String secontent, User user){
		return selfassDao.add(secontent,user);
	}
	
	public SelfassDao getSelfassDao(){
		return selfassDao;
	}
	public void setSelfassDao(SelfassDao selfassDao){
		this.selfassDao = selfassDao;
	}
}
