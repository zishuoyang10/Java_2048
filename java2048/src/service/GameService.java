package service;

import java.util.Random;

import javax.swing.JOptionPane;
import dto.Dto;

/**
 * ��Ϸ������
 * 
 * @author fengche
 * */
public class GameService {

	private int game_num;
	private Random random;
	private Dto dto;
	private int[][] gameMap;

	public GameService(Dto dto) {
		this.random = new Random();
		this.dto = dto;
		this.gameMap = dto.getGameMap();
		this.game_num = dto.getGame_Num();
	}

	// ��ȡ������
	public int getMapId() {
		int x = random.nextInt(4);
		return x;
	}

	// ��ȡ�·����
	public int getGameNum() {
		int x = random.nextInt(2) + 1;
		return x;
	}

	// �½�һ������
	public void newBlok() {
		int x = getMapId();
		int y = getMapId();
		while (gameMap[x][y] != 0) {
			x = getMapId();
			y = getMapId();
		}
		//��ȡһ��������
		gameMap[x][y] = getGameNum();
		this.dto.setGameMap(gameMap);
	}

	// �жϵ�ͼ�ǲ�����
	public boolean isFull() {
		int index = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (gameMap[i][j] != 0) {
					index++;
				}
			}
		}
		if (index == 16 && !canRemove()) {
			return true;
		} else {
			return false;
		}
	}
	//�ܲ����ƶ�
	public boolean canRemove() {
		boolean canRemove = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameMap[i][j] == gameMap[i + 1][j]
						|| gameMap[i][j] == gameMap[i][j + 1]) {
					canRemove = true;
				}
			}
		}
		return canRemove;
	}

	// �ж��ǲ���gameover
	// TODO
	public void isGameOver() {
		if (isFull()) {
			JOptionPane.showMessageDialog(null, "GameOver!----����Ϊ��"
					+ this.dto.getGame_Num());
		} else if (is2048()) {
			JOptionPane.showMessageDialog(null, "��ϲ�㣡2048 ");
		}
	}

	// �ж��ǲ��ǳɹ�
	public boolean is2048() {
		boolean isok = false;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (gameMap[i][j] == 11) {
					isok = true;
				}
			}
		}
		return isok;
	}

	// ����
	public int moveLeft() {
		int ismov = 0;
		for (int j = 0; j < 4; j++) {
			for (int i = 1; i < 4; i++) {
				int mov_i = i;
				int mov_j = j;
				while (gameMap[mov_i][mov_j] != 0
						&& gameMap[mov_i - 1][mov_j] == 0) {
					gameMap[mov_i - 1][mov_j] = gameMap[mov_i][mov_j];
					gameMap[mov_i][mov_j] = 0;
					if (mov_i > 1) {
						mov_i--;
					}
					ismov = 1;
				}
			}
		}
		return ismov;
	}

	// ����
	public int moveRight() {
		int ismov = 0;
		for (int j = 0; j < 4; j++) {
			for (int i = 2; i >= 0; i--) {
				int mov_i = i;
				int mov_j = j;
				while (gameMap[mov_i][mov_j] != 0
						&& gameMap[mov_i + 1][mov_j] == 0) {
					gameMap[mov_i + 1][mov_j] = gameMap[mov_i][mov_j];
					gameMap[mov_i][mov_j] = 0;
					if (mov_i < 2) {
						mov_i++;
					}
					ismov = 1;
				}
			}
		}
		return ismov;
	}

	// ����
	public int moveDown() {
		int ismov = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j >= 0; j--) {
				int mov_i = i;
				int mov_j = j;
				while (gameMap[mov_i][mov_j] != 0
						&& gameMap[mov_i][mov_j + 1] == 0) {
					gameMap[mov_i][mov_j + 1] = gameMap[mov_i][mov_j];
					gameMap[mov_i][mov_j] = 0;
					if (mov_j < 2) {
						mov_j++;
					}
					ismov = 1;
				}
			}
		}
		return ismov;
	}

	// ����
	public int moveUp() {
		int ismov = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				int mov_i = i;
				int mov_j = j;
				while (gameMap[mov_i][mov_j] != 0
						&& gameMap[mov_i][mov_j - 1] == 0) {
					gameMap[mov_i][mov_j - 1] = gameMap[mov_i][mov_j];
					gameMap[mov_i][mov_j] = 0;
					if (mov_j > 1) {
						mov_j--;
					}
					ismov = 1;
				}
			}
		}
		return ismov;
	}

	// ����
	public int removeLeft() {
		int isremove = 0;
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				while (gameMap[i][j] == gameMap[i + 1][j]
						&& gameMap[i][j] != 11 && gameMap[i][j] != 0) {
					gameMap[i][j] = gameMap[i + 1][j] + 1;
					gameMap[i + 1][j] = 0;
					// �ӷ�
					this.game_num++;
					this.dto.setGame_Num(game_num);
					isremove = 1;
				}
			}
		}
		moveLeft();
		return isremove;
	}

	// ����
	public int removeRight() {
		int isremove = 0;
		for (int j = 0; j < 4; j++) {
			for (int i = 3; i > 0; i--) {
				while (gameMap[i][j] == gameMap[i - 1][j]
						&& gameMap[i][j] != 11 && gameMap[i][j] != 0) {
					gameMap[i][j] = gameMap[i - 1][j] + 1;
					gameMap[i - 1][j] = 0;
					// �ӷ�
					this.game_num++;
					this.dto.setGame_Num(game_num);
					isremove = 1;
				}
			}
		}
		moveRight();
		return isremove;
	}

	// ����
	public int removeUp() {
		int isremove = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				while (gameMap[i][j] == gameMap[i][j + 1]
						&& gameMap[i][j] != 11 && gameMap[i][j] != 0) {
					gameMap[i][j] = gameMap[i][j + 1] + 1;
					gameMap[i][j + 1] = 0;
					// �ӷ�
					this.game_num++;
					this.dto.setGame_Num(game_num);
					isremove = 1;
				}
			}
		}
		moveUp();
		return isremove;
	}

	// ����
	public int removeDown() {
		int isremove = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j > 0; j--) {
				while (gameMap[i][j] == gameMap[i][j - 1]
						&& gameMap[i][j] != 11 && gameMap[i][j] != 0) {
					gameMap[i][j] = gameMap[i][j - 1] + 1;
					gameMap[i][j - 1] = 0;
					// �ӷ�
					this.game_num++;
					this.dto.setGame_Num(game_num);
					isremove = 1;
				}
			}
		}
		moveDown();
		return isremove;
	}
}
