package com.application.validate.util;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.util.Random;

public class ValidateCodeUtil {
	
	/**
	 * @Description ���ɶ�ά��
	 * @param content
	 * @return
	 */
	public static BufferedImage getValidateCode(String content){
		int width = 120;
		int height = 48;
		//����
		BufferedImage buf = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//���ƹ���
		Graphics2D gs = buf.createGraphics();
		//����
		gs.setColor(getRandomColor(200,250));
		gs.fillRect(0, 0, width, height);
		//���Ƹ�����
		Random random = new Random();
		for(int i=0; i<100; i++){
			gs.setColor(getRandomColor(50,200));
			int x1 = random.nextInt(120);
			int y1 = random.nextInt(48);
			int x2 = x1+random.nextInt(50);
			int y2 = y1+random.nextInt(20);
			gs.drawLine(x1, y1, x2, y2);
		}
		//����
		Font font = new Font("����",Font.BOLD,25);
		gs.setFont(font);     //��������
		gs.setColor(getRandomColor(20,130));      //������ɫ
		gs.drawString(content, 10, 30);      //�����������ݼ�λ��
		
		return buf;
	}
	
	/**
	 * @Description �������ɫ
	 * @param from
	 * @param to
	 * @return
	 */
	public static Color getRandomColor(int from, int to){
		Random random = new Random();
		int r = from + random.nextInt(to-from);
		int g = from + random.nextInt(to-from);
		int b = from + random.nextInt(to-from);
		return new Color(r,g,b);
	}

}
