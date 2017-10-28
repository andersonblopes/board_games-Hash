package com.lopes;

import com.lopes.exception.HashException;

public class Game {

	private Boolean playerMarkX;
	private Boolean[][] board = new Boolean[3][3];
	private boolean started;

	public boolean endUp() {
		return false;
	}

	public void setPlayerMarkX(boolean playerMarkX) {
		if (started) {
			generateException();
		}
		this.playerMarkX = playerMarkX;
	}

	public boolean isPlayerMarkX() {
		return playerMarkX;
	}

	public void drawBrand(int line, int column) {
		if (!isCellValid(line, column) || playerMarkX == null) {
			generateException();
		}
		board[line][column] = playerMarkX;
		started = true;
	}

	public boolean isCellValid(int line, int column) {
		return line >= 0 && line < board.length && column >= 0 && column < board.length && board[line][column] == null;
	}

	public Boolean isMarkXPosition(int line, int column) {
		return board[line][column];
	}

	private void generateException() {
		throw new HashException();
	}

}
