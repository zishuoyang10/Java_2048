package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import dto.Dto;
/**
 * 游戏分数显示
 * @author fengche
 * */
public class Score_Num extends Score{
	private static final int SIZE_NUM = 21;
	private static final int SIZE_SCORE = 80;
	private int x;
	private Dto dto;
	public Score_Num(Dto dto) {
		this.dto = dto;
	}
	public void drawNum(Graphics g){
		String gameNumString = Integer.toString(dto.getGame_Num());
		for (int i = 0; i < gameNumString.length(); i++) {
			int NumBit = gameNumString.charAt(i)-'0';
			this.x = NumBit*SIZE_NUM;
			g.drawImage(Images.img_num, this.s_x+SIZE_SCORE+i*SIZE_NUM, this.s_y+8, this.s_x+SIZE_SCORE+SIZE_NUM+i*SIZE_NUM, this.s_y+8+SIZE_NUM,
					x, 0, SIZE_NUM+x, SIZE_NUM, null);
		}
	}
}
