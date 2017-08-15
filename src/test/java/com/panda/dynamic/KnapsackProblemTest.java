package com.panda.dynamic;

import org.junit.Test;

public class KnapsackProblemTest {

	@Test
	public void testSolve() {
		int[] weights = { 4, 3, 2 };
		int[] values = { 6, 5, 3 };
		new KnapsackProblem(weights, values, 5).solve();
	}

}
