package com.panda.dynamic;

public class SubsetSumProblem {

	private int[] set;
	private int sum;
	private boolean[][] table;

	public SubsetSumProblem(int[] set, int sum) {
		this.set = set;
		this.sum = sum;
		this.table = new boolean[set.length + 1][sum + 1];
		for (int i = 0; i <= set.length; i++) {
			table[i][0] = true;
		}
	}

	public void solve() {
		for (int i = 1; i <= set.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (set[i - 1] > j) {
					table[i][j] = table[i - 1][j];
				} else {
					if (table[i - 1][j]) {
						table[i][j] = true;
					} else {
						table[i][j] = table[i - 1][j - set[i - 1]];
					}
				}
			}
		}
		for (int i = set.length, j = sum; i > 0 && j > 0;) {
			if (table[i][j] != table[i - 1][j]) {
				System.out.print(set[i - 1] + " ");
				j -= set[i - 1];
			}
			i--;
		}
	}

}
