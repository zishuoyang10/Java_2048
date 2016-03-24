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
	 * ��Ϸ������
	 * @author fengche
	 * */
	public GameControl(MainPanel mainPanel, GameService gameService) {
		this.mainPanel = mainPanel;
		this.gameService = gameService;
	}

	/**
	 * �����¼�����
	 * @author fengche
	 * */
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		switch (e.getKeyCode()) {
		// ����
		case 37: {
			int ismov = gameService.moveLeft();
			int isremove = gameService.removeLeft();
			if (ismov == 1||isremove==1) {
				// new block
				gameService.newBlok();
			}
		}
			break;
		// ����
		case 38: {
			int ismov = gameService.moveUp();
			int isremove = gameService.removeUp();
			if (ismov == 1||isremove==1) {
				// new block
				gameService.newBlok();
			}
		}
			break;
		// ����
		case 39: {
			int ismov = gameService.moveRight();
			int isremove = gameService.removeRight();
			if (ismov == 1||isremove==1) {
				// new block
				gameService.newBlok();
			}
		}
			break;
		// ����
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
		//ˢ����Ϸ����
		this.mainPanel.repaint();
		//�ж��ǲ���gameover
		gameService.isGameOver();
	}
}
