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
		if (board[line][column] != null) {
			throw new HashException();
		}
		board[line][column] = playerMarkX;
	}

	public boolean isMarkXPosition(int line, int column) {
		return true;
	}

}
