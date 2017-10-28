package com.lopes;

import com.lopes.exception.HashException;

public class Game {

	private boolean playerMarkX;
	private Boolean[][] board = new Boolean[3][3];

	public boolean endUp() {
		return false;
	}

	public void setPlayerMarkX(boolean playerMarkX) {
		this.playerMarkX = playerMarkX;
	}

	public boolean isPlayerMarkX() {
		return playerMarkX;
	}

	public void drawBrand(int line, int column) {
		if (isCellValid(line, column)) {
			generateException();
		}
		board[line][column] = playerMarkX;
	}

	private boolean isCellValid(int line, int column) {
		return line < 0 || line > board.length || column < 0 || column > board.length || board[line][column] != null;
	}

	public boolean isMarkXPosition(int line, int column) {
		return true;
	}

	private void generateException() {
		throw new HashException();
	}

}
