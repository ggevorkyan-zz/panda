package com.panda.leetcode;

import org.junit.Test;

public class CoinChangeTest {
	
	@Test
	public void testSolve() {
		new CoinChange(new int[] {1, 7, 9, 10}, 21).solve();
		new CoinChange(new int[] {186, 419, 83, 408}, 6249).solve(); // 20
	}

}
