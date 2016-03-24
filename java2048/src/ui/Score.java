package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Score {
	protected int s_x = 150;
	protected int s_y = 50;
	public void drawScore(Graphics g){
		g.drawImage(Images.img_score, s_x, s_y, null);
	}
}
