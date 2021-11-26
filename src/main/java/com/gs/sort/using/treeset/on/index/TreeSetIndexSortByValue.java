package com.gs.sort.using.treeset.on.index;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetIndexSortByValue {

  public static void main(String[] args) {
    int[] nums = {1,3,-1,1,4,2,8};
                //0 1 2  3 4 5 6
    TreeSetIndexSortByValue clz = new TreeSetIndexSortByValue();
    SortedSet<Integer> result = clz.sort(nums);
    for ( int i : result) {
      System.out.println(i);
    }
    
    System.out.println("********");
    Iterator<Integer> iterator = result.iterator();
    while ( iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private SortedSet<Integer> sort(int[] nums) {
    TreeSet<Integer> result = new TreeSet<>(buildComparator(nums));
    for ( int i = 0 ; i < nums.length; i++) {
      result.add(i);
    }
    return result;
  }

  private Comparator<Integer> buildComparator(int[] nums) {
    return (a, b) -> {
      if (nums[a] == nums[b])
        return a - b;
      else if (nums[a] > nums[b])
        return 1;
      else
        return -1;
      };
  }

}
