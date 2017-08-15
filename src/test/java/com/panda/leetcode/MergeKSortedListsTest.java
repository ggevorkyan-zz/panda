package com.panda.leetcode;

import org.junit.Test;

import com.panda.util.ListNode;

public class MergeKSortedListsTest {

	@Test
	public void testSolve() {
		ListNode n1 = new ListNode(2);
		n1.next = new ListNode(4);
		n1.next.next = new ListNode(9);
		ListNode n2 = new ListNode(5);
		n2.next = new ListNode(7);
		ListNode n3 = new ListNode(3);
		n3.next = new ListNode(8);
		n3.next.next = new ListNode(11);
		ListNode n4 = new ListNode(1);
		ListNode[] a = { n1, n2, n3, n4 };
		ListNode res = new MergeKSortedLists().solve(a);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

}
