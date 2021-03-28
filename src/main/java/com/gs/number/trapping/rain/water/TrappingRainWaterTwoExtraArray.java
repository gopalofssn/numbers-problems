package com.gs.number.trapping.rain.water;

import java.util.Arrays;

/*
basic approach
--------------
I / P   :   [0,1,0,2,1,0,1,3,2,1,2,1]
Left    :   [0,1,1,2,2,2,2,3,3,3,3,3]   - max
Right   :   [3,3,3,3,3,3,3,3,2,2,2,1]   - max
contri  :   [0,0,1,0,1,2,1,0,0,1,0,0]   - min(left, right) - actual height
formula  to hold water each index- 
   min(left max, right max) - height[index]
            [0,0,1,0,1,2,1,0,0,1,0,0]
            = 1 + 1 + 2 + 1 + 1
            = 6
            
   Time  : O(n) , 3n actually
   Space : O(n)  , 2n actually
 */

public class TrappingRainWaterTwoExtraArray implements TrappingRainWater {

  public int trap(int[] heights) {

    if (heights == null || heights.length == 0)
      return 0;

    int[] leftMaxHeights = findLeftMaxHeights(heights);
    int[] rightMaxHeights = findRightMaxHeights(heights);

    int total = 0;
    for (int index = 0; index < heights.length; index++) {
      int min = Math.min(leftMaxHeights[index], rightMaxHeights[index]);
      int diff = min - heights[index];
      if (diff > 0) {
        total += diff;
      }
    }

    return total;
  }

  private int[] findRightMaxHeights(int[] heights) {
    int[] rightMaxHeights = new int[heights.length];
    int max = Integer.MIN_VALUE;

    for (int index = heights.length - 1; index >= 0; index--) {
      max = Math.max(max, heights[index]);
      rightMaxHeights[index] = max;
    }

    return rightMaxHeights;
  }

  private int[] findLeftMaxHeights(int[] heights) {
    int[] leftMaxHeights = new int[heights.length];
    
    int max = Integer.MIN_VALUE;

    Arrays.stream(heights)
          .forEach(System.out::println);
    
    
    for (int index = 0; index < heights.length; index++) {
      max = Math.max(max, heights[index]);
      leftMaxHeights[index] = max;
    }

    return leftMaxHeights;
  }

}
