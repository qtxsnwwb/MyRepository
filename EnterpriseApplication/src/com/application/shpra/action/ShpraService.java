package com.application.shpra.action;

import com.application.login.action.*;

/**
 * 
 * @Description У��ʵ��ҵ����
 *
 */
public class ShpraService {
	private ShpraDao shpraDao = new ShpraDaoImpl();     //У��ʵ��DAO
	
	/**
	 * @Description ���У��ʵ��
	 * @param stime ʵ��ʱ��
	 * @param sorgan ʵ����λ
	 * @param sduty ʵ��ְ��
	 * @param scontent ʵ������
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(String stime, String sorgan, String sduty, String scontent, User user){
		return shpraDao.add(stime, sorgan, sduty, scontent, user);
	}
	
	public ShpraDao getShpraDao(){
		return shpraDao;
	}
	public void setShpraDao(ShpraDao shpraDao){
		this.shpraDao = shpraDao;
	}
}
