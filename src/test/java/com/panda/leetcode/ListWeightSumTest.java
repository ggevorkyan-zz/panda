package com.panda.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListWeightSumTest {

	@Test
	public void testSum() {
		List<IntOrList> list = new ArrayList<IntOrList>();
		list.add(new IntOrList(2));
		IntOrList list1 = new IntOrList();
		list1.list.add(new IntOrList(1));
		list1.list.add(new IntOrList(1));
		list.add(list1);
		System.out.println(new ListWeightSum().sum(list));
	}
}
