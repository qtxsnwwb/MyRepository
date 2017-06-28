package com.application.practice.action;

import com.application.login.action.*;

/**
 * 
 * @Description ʵϰ����ҵ����
 *
 */
public class PracticeService{
	private PracticeDao practiceDao = new PracticeDaoImpl();      //ʵϰ����DAO
	
	/**
	 * @Description ���ʵϰ����
	 * @param ptime ʵϰʱ��
	 * @param porgan ʵϰ��λ
	 * @param ppos ʵϰ��λ
	 * @param pcontent ʵϰ����
	 * @param user �û���Ϣ
	 * @return ��ӳɹ����
	 */
	public boolean add(String ptime, String porgan, String ppos, String pcontent, User user){
		return practiceDao.add(ptime, porgan, ppos, pcontent, user);
	}
	
	public PracticeDao getPracticeDao(){
		return practiceDao;
	}
	public void setPracticeDao(PracticeDao practiceDao){
		this.practiceDao = practiceDao;
	}
}
