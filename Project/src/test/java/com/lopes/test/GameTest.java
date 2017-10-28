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

}
