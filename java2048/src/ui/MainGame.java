package ui;

import java.awt.Graphics;
import service.GameService;

import dto.Dto;

/**
 * ��Ϸ������
 * 
 * @author fnegche
 * */
public class MainGame {

	private static final int SIZE = 90;
	private int x;
	private int y;
	private Dto dto;
	private int[][] gameMap;

	public MainGame(Dto dto, GameService gameService) {
		gameService.newBlok();
		gameService.newBlok();
		this.dto = dto;
		this.x = dto.getX();
		this.y = dto.getY();
	}

	/**
	 * ����ͼ����
	 * */
	public void GamePaint(Graphics g, int index) {
		this.gameMap = dto.getGameMap();
		// ˢ�µ�ͼ
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (gameMap[i][j] != 0) {
					int gameindex = gameMap[i][j];
					g.drawImage(Images.img_2048, this.x + i * SIZE, this.y + j * SIZE,
							this.x + i * SIZE + SIZE, this.y + j * SIZE + SIZE,
							0 + (gameindex - 1) * SIZE, 0, SIZE
									+ (gameindex - 1) * SIZE, SIZE, null);
				}
			}
		}
	}
}
