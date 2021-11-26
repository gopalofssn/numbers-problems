package com.gs.number.first.less.height;

import java.util.Arrays;

public class FindFirstLessHeightRightIndex {

  
  private int[] heights;

  public FindFirstLessHeightRightIndex(int[] heights) {
    this.heights = heights;
  }

  public int[] findRightLessHeight() {
    
    final int LEN = heights.length;
    int[] result = new int[LEN];
    result[LEN - 1] = LEN;
    for ( int i = LEN - 2; i >=0; i--) {
      int firstLessRightIndex = findRightLessHeightUtil(result, i, i+1);
      result[i] = firstLessRightIndex; 
    }
    return result;
  }
  
  private int findRightLessHeightUtil(int[] result, int currentIndex, int previousPossibleFirstLessRightIndex) {
    if (previousPossibleFirstLessRightIndex >= result.length) {
      return previousPossibleFirstLessRightIndex;
    }
    
    if ( heights[previousPossibleFirstLessRightIndex] < heights[currentIndex]) {
      return previousPossibleFirstLessRightIndex;
    }
    
    return findRightLessHeightUtil(result, currentIndex, result[previousPossibleFirstLessRightIndex]);
  }

  public static void main(String[] args) {
    int[] nums = {1, 7, 6, 2, 5, 4, 8, 3, 8, 8};
               // 0  1  2  3  4  5  6  7  8  9
               // 10 2  3 10  5  7  7  10 10 10
    FindFirstLessHeightRightIndex clz = new FindFirstLessHeightRightIndex(nums);
    int[] left = clz.findRightLessHeight();
    System.out.println(Arrays.toString(left));
  }
  
}
