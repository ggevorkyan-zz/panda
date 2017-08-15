package com.panda.dynamic;

import com.panda.util.ArrayUtils;

public class KnapsackProblem {

	private int[] weights;
	private int[] values;
	private int itemCount;
	private int maxWeight;
	private int[][] table;

	public KnapsackProblem(int[] weights, int[] values, int maxWeight) {
		if (weights.length != values.length) {
			throw new IllegalArgumentException();
		}
		this.weights = weights;
		this.values = values;
		this.itemCount = weights.length;
		this.maxWeight = maxWeight;
		this.table = new int[itemCount + 1][maxWeight + 1];
	}

	public void solve() {
		for (int i = 1; i < itemCount + 1; i++) {
			for (int j = 1; j < maxWeight + 1; j++) {
				int prevValue = table[i - 1][j];
				int curValue = 0;
				int curWeight = weights[i - 1];
				if (curWeight <= j) {
					curValue = table[i - 1][j - curWeight] + values[i - 1];
				}
				table[i][j] = Math.max(prevValue, curValue);
			}
		}
		ArrayUtils.printMatrix(table);
	}

}
