package com.lopes;

import com.lopes.exception.HashException;

public class Game {

	private Boolean nextMove;
	private Boolean[][] board = new Boolean[3][3];
	private boolean started;

	public boolean endUp() {
		return false;
	}

	public void setPlayerMarkX(boolean playerMarkX) {
		if (started) {
			generateException();
		}
		this.nextMove = playerMarkX;
	}

	public boolean isPlayerMarkX() {
		return nextMove;
	}

	public void drawBrand(int line, int column) {
		if (!isCellValid(line, column) || nextMove == null || isEndedUp()) {
			generateException();
		}
		board[line][column] = nextMove;
		nextMove = !nextMove;
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

	public boolean isEndedUp() {
		return wonByColumn() || wonByLine() || wonByDiagonal();
	}

	private boolean wonByLine() {
		for (int i = 0; i < 3; i++) {
			if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2]) && (board[i][1] != null)) {
				return true;
			}
		}
		return false;
	}

	private boolean wonByColumn() {
		for (int i = 0; i < 3; i++) {
			if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) && (board[1][i] != null)) {
				return true;
			}
		}
		return false;
	}

	private boolean wonByDiagonal() {
		if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && (board[1][1] != null)) {
			return true;
		}

		if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) && (board[1][1] != null)) {
			return true;
		}
		return false;
	}

}
