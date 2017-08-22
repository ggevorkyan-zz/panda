package com.panda.leetcode;

public class CoinChange {

	private int[] coins;
	private int amount;
	private int[][] table;

	public CoinChange(int[] coins, int amount) {
		this.coins = coins;
		this.amount = amount;
		table = new int[coins.length + 1][amount + 1];
	}

	public void solve() {
		for (int i = 0; i < amount + 1; i++) {
			table[0][i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i < coins.length + 1; i++) {
			int curCoin = coins[i - 1];
			for (int j = 1; j < amount + 1; j++) {
				int prevMin = table[i - 1][j];
				int curMin = Integer.MAX_VALUE;
				if (curCoin <= j && table[i][j - curCoin] != Integer.MAX_VALUE) {
					curMin = table[i][j - curCoin] + 1;
				}
				table[i][j] = Math.min(prevMin, curMin);
			}
		}
		System.out.println(table[coins.length][amount] == Integer.MAX_VALUE ? -1 : table[coins.length][amount]);
	}

}
