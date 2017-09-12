package com.panda.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinPackingProblem {

	private int capacity;
	private List<Integer> items;
	private List<Bin> bins;

	public BinPackingProblem(int capacity, List<Integer> items) {
		this.capacity = capacity;
		this.items = items;
		bins = new ArrayList<Bin>();
	}

	public void solve() {
		Collections.sort(items, Collections.reverseOrder());
		for (Integer item : items) {
			if (item <= capacity) {
				boolean itemPlaced = false;
				for (Bin bin : bins) {
					if (bin.put(item)) {
						itemPlaced = true;
						break;
					}
				}
				if (!itemPlaced) {
					Bin bin = new Bin(capacity);
					bins.add(bin);
					bin.put(item);
				}
			} else {
				System.out.println("There is no feasible solution");
				break;
			}
		}
		System.out.println(bins);
	}

	public static class Bin {
		private List<Integer> bin;
		private int capacity;
		private int currentItems = 0;

		public Bin(int capacity) {
			this.capacity = capacity;
			this.bin = new ArrayList<Integer>();
		}

		public boolean put(int item) {
			if (currentItems + item > capacity) {
				return false;
			}
			currentItems += item;
			bin.add(item);
			return true;
		}

		public String toString() {
			return bin.toString();
		}
	}

}
