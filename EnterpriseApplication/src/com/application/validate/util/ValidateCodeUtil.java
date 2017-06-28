package com.application.validate.util;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.util.Random;

public class ValidateCodeUtil {
	
	/**
	 * @Description 生成二维码
	 * @param content
	 * @return
	 */
	public static BufferedImage getValidateCode(String content){
		int width = 120;
		int height = 48;
		//画板
		BufferedImage buf = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//绘制工具
		Graphics2D gs = buf.createGraphics();
		//矩形
		gs.setColor(getRandomColor(200,250));
		gs.fillRect(0, 0, width, height);
		//绘制干扰线
		Random random = new Random();
		for(int i=0; i<100; i++){
			gs.setColor(getRandomColor(50,200));
			int x1 = random.nextInt(120);
			int y1 = random.nextInt(48);
			int x2 = x1+random.nextInt(50);
			int y2 = y1+random.nextInt(20);
			gs.drawLine(x1, y1, x2, y2);
		}
		//字体
		Font font = new Font("楷体",Font.BOLD,25);
		gs.setFont(font);     //设置字体
		gs.setColor(getRandomColor(20,130));      //设置颜色
		gs.drawString(content, 10, 30);      //设置文字内容及位置
		
		return buf;
	}
	
	/**
	 * @Description 生成随机色
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
