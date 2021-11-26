package com.gs.number.trapping.rain.water;

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
    
    int[] leftMax = findLeftMax(heights);
    int[] rightMax = findRightMax(heights);
    int result = 0;
    for ( int i = 1; i < heights.length - 1  ; i++) {
      int height = Math.min(leftMax[i], rightMax[i]);
      if (heights[i] < height) {
        int diff = height - heights[i];
        result = result + diff;
      }
    }
    return result;    
  }

  private int[] findRightMax(int[] heights) {
    int[] result = new int[heights.length];
    int max = Integer.MIN_VALUE;
    for ( int i = 0; i < heights.length; i++) {
      max = Math.max(max, heights[i]);
      result[i] = max;
    }
    return result;
  }

  private int[] findLeftMax(int[] heights) {
    int[] result = new int[heights.length];
    int max = Integer.MIN_VALUE;
    for ( int i = heights.length - 1; i >=0 ; i--) {
      max = Math.max(max, heights[i]);
      result[i] = max;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(new TrappingRainWaterTwoExtraArray().trap(heights));
  }

}
