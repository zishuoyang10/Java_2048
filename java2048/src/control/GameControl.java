package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import dto.Dto;

import service.GameService;
import ui.MainPanel;

public class GameControl extends KeyAdapter {

	private MainPanel mainPanel;
	private GameService gameService;
	/**
	 * 游戏控制类
	 * @author fengche
	 * */
	public GameControl(MainPanel mainPanel, GameService gameService) {
		this.mainPanel = mainPanel;
		this.gameService = gameService;
	}

	/**
	 * 键盘事件监听
	 * @author fengche
	 * */
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		switch (e.getKeyCode()) {
		// 左移
		case 37: {
			int ismov = gameService.moveLeft();
			int isremove = gameService.removeLeft();
			if (ismov == 1||isremove==1) {
				// new block
				gameService.newBlok();
			}
		}
			break;
		// 上移
		case 38: {
			int ismov = gameService.moveUp();
			int isremove = gameService.removeUp();
			if (ismov == 1||isremove==1) {
				// new block
				gameService.newBlok();
			}
		}
			break;
		// 右移
		case 39: {
			int ismov = gameService.moveRight();
			int isremove = gameService.removeRight();
			if (ismov == 1||isremove==1) {
				// new block
				gameService.newBlok();
			}
		}
			break;
		// 下移
		case 40: {
			int ismov = gameService.moveDown();
			int isremove = gameService.removeDown();
			if (ismov == 1||isremove==1) {
				// new block
				gameService.newBlok();
			}
		}
		break;
		}
		//刷新游戏窗口
		this.mainPanel.repaint();
		//判断是不是gameover
		gameService.isGameOver();
	}
}
