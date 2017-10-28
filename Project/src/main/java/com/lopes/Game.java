package com.lopes;

public class Game {

	private boolean playerMarkX;

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

	}

	public boolean isMarkXPosition(int line, int column) {
		return true;
	}

}
