package com.panda.dynamic;

import com.panda.util.ArrayUtils;

public class RodCuttingProblem {

	private int[] prices;
	private int length;
	private int[][] table;

	public RodCuttingProblem(int[] prices, int length) {
		this.prices = prices;
		this.length = length;
		this.table = new int[prices.length + 1][length + 1];
	}

	public void solve() {
		for (int i = 1; i <= prices.length; i++) {
			for (int j = 1; j <= length; j++) {
				if (i <= j) {
					table[i][j] = Math.max(table[i - 1][j], prices[i - 1] + table[i][j - i]);
				} else {
					table[i][j] = table[i - 1][j];
				}
			}
		}
		ArrayUtils.printMatrix(table);
		System.out.println(table[prices.length][length]);
		for (int i = prices.length, j = length; i > 0;) {
			if (table[i][j] != table[i - 1][j]) {
				System.out.print(i + " ");
				j -= i;
			} else {
				i--;
			}
		}
	}

}
