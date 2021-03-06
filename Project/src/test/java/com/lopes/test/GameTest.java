package com.lopes.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lopes.Game;
import com.lopes.exception.HashException;

public class GameTest {

	private Game game;

	@Before
	public void Init() {
		game = new Game();
	}

	@Test
	public void createGame() {
		Assert.assertFalse("The game is over?", game.endUp());
	}

	@Test
	public void setFirstPlayer() {
		game.setPlayerMarkX(true);

		Assert.assertTrue(game.isPlayerMarkX());
	}

	@Test
	public void setFirstPlayerAgain() {
		game.setPlayerMarkX(true);
		game.setPlayerMarkX(false);

		Assert.assertFalse(game.isPlayerMarkX());
	}

	@Test
	public void drawFirstBrand() {
		game.setPlayerMarkX(true);
		game.drawBrand(1, 0);

		Assert.assertTrue(game.isMarkXPosition(1, 0));
	}

	@Test(expected = HashException.class)
	public void drawOcuppiedCell() {
		game.setPlayerMarkX(true);
		game.drawBrand(1, 0);
		game.drawBrand(1, 0);
	}

	@Test
	public void readCellUnoccupied() {
		game.setPlayerMarkX(true);

		Assert.assertNull(game.isMarkXPosition(0, 0));
	}

	@Test(expected = HashException.class)
	public void drawWrongCell() {
		game.setPlayerMarkX(true);
		game.drawBrand(4, 4);
	}

	@Test(expected = HashException.class)
	public void drawWrongInvalidLineCell() {
		game.setPlayerMarkX(true);
		game.drawBrand(-1, 0);
	}

	@Test(expected = HashException.class)
	public void drawWrongInvalidLineCell2() {
		game.setPlayerMarkX(true);
		game.drawBrand(4, 0);
	}

	@Test(expected = HashException.class)
	public void drawWrongInvalidColumnCell() {
		game.setPlayerMarkX(true);
		game.drawBrand(0, -1);
	}

	@Test(expected = HashException.class)
	public void drawWrongInvalidColumnCel2l() {
		game.setPlayerMarkX(true);
		game.drawBrand(0, 4);
	}

	@Test
	public void testIsMarkXPosition() {
		Assert.assertNull(game.isMarkXPosition(0, 0));
	}

	@Test
	public void valiCell() {
		Assert.assertFalse(game.isCellValid(1, 10));
	}

	@Test(expected = HashException.class)
	public void definePlayerAfterGameStart() {
		game.setPlayerMarkX(true);
		game.drawBrand(0, 0);
		game.setPlayerMarkX(true);
	}

	@Test(expected = HashException.class)
	public void drawBrandBeforeGameStarts() {
		game.drawBrand(0, 0);
	}

	@Test
	public void drawSecondBrand() {
		game.setPlayerMarkX(true);
		game.drawBrand(1, 0);
		game.drawBrand(1, 1);

		Assert.assertFalse(game.isMarkXPosition(1, 1));
	}

	@Test
	public void wonByColumn() {
		game.setPlayerMarkX(true);
		game.drawBrand(0, 0);
		game.drawBrand(1, 2);
		game.drawBrand(1, 0);
		game.drawBrand(2, 2);
		game.drawBrand(2, 0);
		Assert.assertTrue("Game closed", game.isEndedUp());
	}

	@Test
	public void wonByLine() {
		game.setPlayerMarkX(true);
		game.drawBrand(1, 0);
		game.drawBrand(0, 2);
		game.drawBrand(1, 2);
		game.drawBrand(2, 0);
		game.drawBrand(1, 1);
		Assert.assertTrue("Game closed", game.isEndedUp());
	}

	@Test
	public void wonByDiagonal() {
		game.setPlayerMarkX(true);
		game.drawBrand(0, 2);
		game.drawBrand(0, 0);
		game.drawBrand(1, 1);
		game.drawBrand(2, 2);
		game.drawBrand(2, 0);
		Assert.assertTrue("Game closed", game.isEndedUp());
	}

	@Test(expected = HashException.class)
	public void drawMarkAfterFinishedGame() {
		game.setPlayerMarkX(true);
		game.drawBrand(0, 2);
		game.drawBrand(0, 0);
		game.drawBrand(1, 1);
		game.drawBrand(2, 2);
		game.drawBrand(2, 0);
		game.drawBrand(2, 1);
	}

}
