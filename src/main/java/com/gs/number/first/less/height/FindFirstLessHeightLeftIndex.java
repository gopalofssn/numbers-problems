package com.gs.number.first.less.height;

import java.util.Arrays;

public class FindFirstLessHeightLeftIndex {

  private int[] heights;
  
  public FindFirstLessHeightLeftIndex(int[] heights) {
    this.heights = heights;
  }
  
  public int[] findLeftLessHeight() {   
    
    int[] result = new int[heights.length];
    result[0] = -1;
    for (int i = 1; i < heights.length; i++) {
      int previousLessIndex = findLeftLessHeightUtil(i, i - 1, result);              
      result[i] = previousLessIndex;
    }
    return result;
  }

  private int findLeftLessHeightUtil(int currentIndex,int possiblePrevLessIndex, int[] result) {
    if (possiblePrevLessIndex < 0) {
      return -1;
    }
    
    if ( heights[possiblePrevLessIndex] < heights[currentIndex] ) {
      return possiblePrevLessIndex;
    }
    
    return findLeftLessHeightUtil(currentIndex,result[possiblePrevLessIndex], result);
  }

  public static void main(String[] args) {
    int[] nums = {1, 7, 6, 2, 5, 4, 8, 3, 8};
    FindFirstLessHeightLeftIndex clz = new FindFirstLessHeightLeftIndex(nums);
    int[] left = clz.findLeftLessHeight();
    System.out.println(Arrays.toString(left));
  }

}
