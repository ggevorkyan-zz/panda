package com.panda.dynamic;

import org.junit.Test;

public class SubsetSumProblemTest {
	
	@Test
	public void testSolve() {
		int[] set = {5, 2, 3, 1};
		int sum = 9;
		new SubsetSumProblem(set, sum).solve();
	}
	
}
