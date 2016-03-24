package ui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import service.GameService;

import dto.Dto;
/**
 * main JPanel
 * @author fengcne
 * */
public class MainPanel extends JPanel{
	
	private MainFg mainFg;
	private Score score;
	private Score_Num scoreNum;
	private MainGame mainGame;
	private Dto dto;
	public MainPanel(Dto dto,GameService gameService){
		this.dto = dto;
		this.mainFg = new MainFg(dto);
		this.score = new Score();
		this.mainGame = new MainGame(dto, gameService);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.scoreNum = new Score_Num(dto);
		
		g.drawImage(Images.img, 0, 0, null);
		
		this.mainFg.drawWin(g);
		
		this.score.drawScore(g);
		
		this.scoreNum.drawNum(g);
		
		this.mainGame.GamePaint(g,new GameService(dto).getGameNum());
		
	}
	
}
