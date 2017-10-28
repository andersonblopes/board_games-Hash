package com.lopes.test;

import org.junit.Assert;
import org.junit.Test;

import com.lopes.Game;

public class GameTest {

	@Test
	public void createGame() {
		Game game = new Game();

		Assert.assertFalse("The game is over?", game.endUp());
	}

	@Test
	public void setFirstPlayer() {
		Game game = new Game();

		game.setPlayerMarkX(true);

		Assert.assertTrue(game.isPlayerMarkX());
	}

	@Test
	public void setFirstPlayerAgain() {
		Game game = new Game();

		game.setPlayerMarkX(true);
		game.setPlayerMarkX(false);

		Assert.assertFalse(game.isPlayerMarkX());
	}

}
