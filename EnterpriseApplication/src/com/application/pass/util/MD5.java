package com.application.pass.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @Description 实现MD5加密
 *
 */
public final class MD5 {
	/**
	 * 
	 * @param str 输入需加密的字符串
	 * @return 加密后的字符串
	 */
	public static String getMD5(String str){
		String reStr = null;
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");    //创建具有指定算法名称的信息摘要
			md.update(str.getBytes());       //使用指定的字节更新摘要
			byte ss[] = md.digest();       //通过执行诸如填充之类的最终操作完成哈希计算 
			reStr = bytes2String(ss);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return reStr;
	}
	
	//将字节数组转化为字符串
	private static String bytes2String(byte[] aa){
		String hash = "";
		for(int i=0; i<aa.length; i++){
			int temp;
			if(aa[i] < 0)      //如果小于0，将其变为正数
				temp = 256+aa[i];
			else
				temp = aa[i];
			if(temp < 16)
				hash += "0";
			hash += Integer.toString(temp,16);       //转换为十六进制
		}
		hash = hash.toUpperCase();     //转换为大写
		return hash;
	}
}
