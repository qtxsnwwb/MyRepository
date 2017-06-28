package com.application.edu.action;

import java.sql.Timestamp;
import com.application.login.action.*;

/**
 * 
 * @Description ��������ҵ����
 *
 */
public class EduService {
	private EduDao eduDao = new EduDaoImpl();      //��������DAO
	
	/**
	 * @Description ��ӽ�������
	 * @param endTime ��ҵʱ��
	 * @param school ѧУ
	 * @param major רҵ
	 * @param degree ѧλ
	 * @param subject ���޿γ�
	 * @return ��ӳɹ����
	 */
	public boolean add(Timestamp endTime, String school, String major, String degree, String subject, User user){
		return eduDao.add(endTime, school, major, degree, subject, user);
	}
	
	public EduDao getEduDao(){
		return eduDao;
	}
	public void setEduDao(EduDao eduDao){
		this.eduDao = eduDao;
	}
}
