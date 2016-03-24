package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import dto.Dto;

/**
 * ´Î±³¾°
 * 
 * @author fengche
 * */
public class MainFg {

	private int x = 45;
	private int y = 95;

	public MainFg(Dto dto) {
		dto.setX(x);
		dto.setY(y);
	}

	public void drawWin(Graphics g) {
		g.drawImage(Images.img_fg, x, y, null);
	}
}
