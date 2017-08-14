package com.panda.leetcode;

import java.util.ArrayList;
import java.util.List;

class IntOrList {
	Integer val;
	List<IntOrList> list = new ArrayList<IntOrList>();

	public IntOrList() {
	}

	public IntOrList(int val) {
		this.val = val;
	}

	public boolean isIntValue() {
		return val != null;
	}
}

public class ListWeightSum {

	private int sum(List<IntOrList> list, int depth) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		int sum = 0;
		for (IntOrList item : list) {
			if (item.isIntValue()) {
				sum += item.val * depth;
			} else {
				sum += sum(item.list, depth + 1);
			}
		}
		return sum;
	}

	public int sum(List<IntOrList> list) {
		return sum(list, 1);
	}

}
