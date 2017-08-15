package com.panda.leetcode;

import com.panda.util.ListNode;

public class MergeKSortedLists {

	public ListNode solve(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		int last = lists.length - 1;
		while (last != 0) {
			int i = 0, j = last;
			while (i < j) {
				lists[i] = merge(lists[i], lists[j]);
				i++;
				j--;
			}
			last = j;
		}
		return lists[0];
	}

	private ListNode merge(ListNode a, ListNode b) {
		ListNode res = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.val < b.val) {
			res = a;
			res.next = merge(a.next, b);
		} else {
			res = b;
			res.next = merge(a, b.next);
		}
		return res;
	}

}
