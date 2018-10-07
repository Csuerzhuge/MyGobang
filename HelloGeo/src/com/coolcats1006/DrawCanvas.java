package com.coolcats1006;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
public class DrawCanvas extends JFrame{
	Graphics g;
	private int interval = 40;
	private int wid = 600;
	private int hei = 600;

	private int orix = 100;
	private int oriy = 100;
	private int endx = 900;
	private int endy = 900;
	public DrawCanvas() {
		initUI();
		System.out.println("orix,oriy"+" "+orix+" "+oriy);
		System.out.println("orix,oriy"+" "+orix+" "+oriy);
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize());

	}
	
	public void initUI() {
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		CanvasListener lis = new CanvasListener(this);
		this.addMouseListener(lis);
		JButton btn1 =  new JButton("ͼ��");
		JButton btn2 = new JButton("����");
		this.add(btn1);
		this.add(btn2);
		btn1.addActionListener(lis);
		btn2.addActionListener(lis);
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		this.setVisible(true);
		g = this.getGraphics();
	}
	
//	public void initVar() {
//		
//	}
	public void paint(Graphics g) {
		super.paint(g); 
		
//		System.out.println("SSS");
		for(int line= 0;line<=20;line++) {
//			Color color = new Color(l*10,0,l*10);
//			g.setColor(color);
//			g.drawRect(orix+line*interval,oriy+line*interval,30,30);
		
			g.drawLine(orix, oriy+line*interval, endx, oriy+line*interval);
		}
		for(int line= 0;line<=20;line++) {
//			Color color = new Color(l*10,0,l*10);
//			g.setColor(color);
//			g.drawRect(orix+line*interval,oriy+line*interval,30,30);
		
			g.drawLine(orix+line*interval, oriy, orix+line*interval, endy);
		}
	}
	
	public int getOriX() {
		return this.orix;
	}
	public int getOriY() {
		return this.oriy;
	}
	public int getendX() {
		return this.endx;
	}
	public int getendY() {
		return this.endy;
	}
	
}
