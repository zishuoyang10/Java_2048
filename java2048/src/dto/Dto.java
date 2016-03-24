package dto;


public class Dto {
	private int game_Num = 0;
	private int x;
	private int y;
	private int[][] gameMap = new int[4][4];
	public int getGame_Num() {
		return game_Num;
	}
	public void setGame_Num(int gameNum) {
		game_Num = gameNum;
	}
	public int[][] getGameMap() {
		return gameMap;
	}
	public void setGameMap(int[][] gameMap) {
		this.gameMap = gameMap;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	};
}
