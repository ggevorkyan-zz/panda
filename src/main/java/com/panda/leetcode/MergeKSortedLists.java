package com.panda.leetcode;

import com.panda.util.ListNode;

public class MergeKSortedLists {

	public ListNode solve(ListNode[] lists) {
		ListNode head = null, cur = null;
		ListNode[] currentHeads = new ListNode[lists.length];
		for (int i = 0; i < lists.length; i++) {
			currentHeads[i] = lists[i];
		}
		for (int k = getNextHead(currentHeads); k < currentHeads.length; k = getNextHead(currentHeads)) {
			for (int i = 0; i < currentHeads.length; i++) {
				if (currentHeads[i] != null && currentHeads[i].val < currentHeads[k].val) {
					k = i;
				}
			}
			ListNode n = new ListNode(currentHeads[k].val);
			if (head == null) {
				head = n;
				cur = n;
			} else {
				cur.next = n;
				cur = n;
			}
			currentHeads[k] = currentHeads[k].next;
		}
		return head;
	}

	private int getNextHead(ListNode[] currentHeads) {
		int k = 0;
		while (k < currentHeads.length && currentHeads[k] == null) {
			k++;
		}
		return k;
	}

}
