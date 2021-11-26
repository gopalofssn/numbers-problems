package com.gs.number.max.heights;

import java.util.Arrays;

/*

3                      |
2          |           |  |  |
1    |     |  |     |  |  |  |  |
  0  1  2  3  4  5  6  7  8  9  10
 [0  1  1  2  2  2  2  3  3  3  3 ] - output
 

*/

public class FindTallestPersonOnMyLeft {

  public int[] tallestFinder(int[] nums) {
    
    int[] tallestHeightHolder = new int[nums.length];
    int tallest = Integer.MIN_VALUE;
    
    for (int index = 0; index < nums.length; index++) {
      if (nums[index] > tallest) {
        tallest = nums[index];
      }
      tallestHeightHolder[index] = tallest;
    }

    return tallestHeightHolder;
  }


  public static void main(String[] args) {
    
    int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int[] maxLeftHeight = new FindTallestPersonOnMyLeft().tallestFinder(nums);
    System.out.println(Arrays.toString(maxLeftHeight));
    
  }

}
