package com.application.pass.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @Description ʵ��MD5����
 *
 */
public final class MD5 {
	/**
	 * 
	 * @param str ��������ܵ��ַ���
	 * @return ���ܺ���ַ���
	 */
	public static String getMD5(String str){
		String reStr = null;
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");    //��������ָ���㷨���Ƶ���ϢժҪ
			md.update(str.getBytes());       //ʹ��ָ�����ֽڸ���ժҪ
			byte ss[] = md.digest();       //ͨ��ִ���������֮������ղ�����ɹ�ϣ���� 
			reStr = bytes2String(ss);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return reStr;
	}
	
	//���ֽ�����ת��Ϊ�ַ���
	private static String bytes2String(byte[] aa){
		String hash = "";
		for(int i=0; i<aa.length; i++){
			int temp;
			if(aa[i] < 0)      //���С��0�������Ϊ����
				temp = 256+aa[i];
			else
				temp = aa[i];
			if(temp < 16)
				hash += "0";
			hash += Integer.toString(temp,16);       //ת��Ϊʮ������
		}
		hash = hash.toUpperCase();     //ת��Ϊ��д
		return hash;
	}
}
