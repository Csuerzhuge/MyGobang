package com.coolcats1113;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlaneAI extends Thread {

	private JPanel gamePanel;
	private int bgx, bgy, bgspeed;
	private boolean isStart = true, isPause = false;
	private static  ArrayList<FlyingObject> _flyObjs;
	private ImageIcon planeLow, planeMid, planeHigh;
	private int genX, genY;
	private ImageIcon bgImg;
	private int bgys;

	public PlaneAI(JPanel gamePanel, ImageIcon bgImg) {
		this.gamePanel = gamePanel;
		this.bgImg = bgImg;
		_flyObjs = new ArrayList<>();
	}

	public PlaneAI(JPanel gamePanel) {
		this.gamePanel = gamePanel;

		_flyObjs = new ArrayList<>();

	}

	/**
	 * 飛機AI綫程
	 */
	public void run() {
		BufferedImage bfImg = new BufferedImage(gamePanel.getWidth(), gamePanel.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics bfg = bfImg.getGraphics();
//		BackThread backThread = new BackThread(gamePanel, new ImageIcon("gamebg1.jpg"),bfg);
//		backThread.start();// 背景綫程
		Random rand = new Random();
		Graphics g = gamePanel.getGraphics();
		planeMid = new ImageIcon("midpimg.png");
		planeHigh = new ImageIcon("highpimg.png");
		genY = 0;
//		int speedx = rand.nextInt(bound)

		int deltay = (bgImg.getIconHeight() - gamePanel.getHeight());
		while (isStart) {
			if (!isPause) {

				bfg.drawImage(bgImg.getImage(), 0, bgys - deltay, null);
				bgys++;
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				if (gamePanel.getHeight() + bgys > bgImg.getIconHeight()) {
//					bgys = 0;

				// 自動產生敵機
				genX = rand.nextInt(gamePanel.getWidth());
				if (Math.random() > 0.99) {
//					System.out.println("大飛機生成！");
				} else if (Math.random() > 0.90) {
//					System.out.println("小飛機生成！");
					int speedy = rand.nextInt(10)+5;
					ImageIcon planeLow = new ImageIcon("lowpimg.png");

					System.out.println("小飛機生成！" + planeLow);

					PlaneLow low = new PlaneLow(genX, genY, 30, 0, speedy, 1, planeLow, gamePanel, this);
					_flyObjs.add(low);
				} else {
//					System.out.println("中飛機生成！！");

				}
//				System.out.println("飛機數量"+_flyObjs.size()+","+_flyObjs.get(_flyObjs.size()-1).getTYPE());
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < _flyObjs.size(); i++) {
//					FlyingObject flyobg = _flyObjs.get(i);
					if (_flyObjs.get(i).TYPE == FlyingObject.PLANE) {
						Plane flyobg = (Plane) _flyObjs.get(i);
						if (flyobg._planeType == Plane.Plane_low) {
							PlaneLow flylow = (PlaneLow) _flyObjs.get(i);
							System.out.println("小飛機" + planeLow + "," + flylow.obgimg);
							flylow.drawPlane(bfg);
							flylow.movePlane(bfg);
						}

					} else {

					}
				}
				bfg.setColor(Color.white);
				g.drawImage(bfImg, 0, 0, gamePanel.getWidth(), gamePanel.getHeight(), null);
//				bfg.fillRect(0, 0,gamePanel.getWidth(), gamePanel.getHeight());

			}
		}
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public static ArrayList<FlyingObject> get_flyObjs() {
		return _flyObjs;
	}

	public void set_flyObjs(ArrayList<FlyingObject> _flyObjs) {
		this._flyObjs = _flyObjs;
	}

}
