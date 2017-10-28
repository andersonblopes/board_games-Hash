package com.lopes.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lopes.Game;

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

}
