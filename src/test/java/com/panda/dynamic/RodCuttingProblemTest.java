package com.panda.dynamic;

import org.junit.Test;

public class RodCuttingProblemTest {

	@Test
	public void testSove() {
		int[] prices = { 2, 5, 7 };
		int length = 5;
		new RodCuttingProblem(prices, length).solve();
	}

}
