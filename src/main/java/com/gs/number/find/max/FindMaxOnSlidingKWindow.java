package com.gs.number.find.max;

import java.util.*;

public class FindMaxOnSlidingKWindow {

  public int[] find(int nums[], final int k) {    
    final int LEN = nums.length;
    int[] result = new int[LEN - k + 1];
    Comparator<Integer> cmp = (a, b) -> {
      System.out.println(a + " vs " + b);
              /*if ( nums[a] == nums[b] ) {
                System.out.println("i here?");
                return a - b; // why???
              }           
              return Integer.compare(nums[a], nums[b]); */
            if (nums[a] == nums[b] ) return a-b;
            else if (nums[a] > nums[b] ) return 1;
            else return -1;
            };
    TreeSet<Integer> window = new TreeSet<>(cmp);
    for ( int i = 0; i < k ; i++) {
      window.add(i);
    }
    System.out.println(window);
    int counter = 0;
    result[counter] = nums[window.last()];
    counter++;
    for ( int i = k; i < LEN; i++) {
      int indexToRemove = ( i - k );
      System.out.println( "b4 remove");
      boolean isRemoved = window.remove(indexToRemove);
      System.out.println( "after remove");
      System.out.println( indexToRemove + "th index is removed ? " + isRemoved);
      window.add(i);
      System.out.println(window);
      result[counter] = nums[window.last()];
      counter++;
    }
  
    return result;    
  }
  
  public static void main(String[] args) {
    int[] nums = {1,3,-1,1,1,4,2,8};
    System.out.println("ans - " + Arrays.toString( new FindMaxOnSlidingKWindow().find(nums, 3)));
  }
}
