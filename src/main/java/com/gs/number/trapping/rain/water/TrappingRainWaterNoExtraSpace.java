package com.gs.number.trapping.rain.water;

/**
 * 
 * @author Gopal Selvaraj
 * 
 *   Divide and solve approach
 *   Find supreme height position & calculate on sides
 *   
 *   Time : O(n) , actually O(2n)
 *   Space : O(1)
 */
public class TrappingRainWaterNoExtraSpace implements TrappingRainWater{

  @Override
  public int trap(int[] heights) {
    int highestIndex = 0;
    for ( int i = 0; i < heights.length; i++) {
      if (heights[i] > heights[highestIndex]) {
        highestIndex = i;
      }
    }
    
    return leftSideTrap(heights, highestIndex) + rightSideTrap(heights, highestIndex);
  }

  private int leftSideTrap(int[] heights, int highestIndex) {
    int result = 0;
    int leftHighestIndex = 0;
    for (int i = 1; i < highestIndex; i++) {
      if ( heights[i] > heights[leftHighestIndex]) {
        leftHighestIndex = i;
      }else {
        int diff = heights[leftHighestIndex] - heights[i]; 
        result += diff;
      }
    }
    return result;
  }

  private int rightSideTrap(int[] heights, int highestIndex) {
    int result = 0;
    int rightHighestIndex = heights.length - 1;
    for (int i = heights.length - 2; i > highestIndex; i--) {
      if ( heights[i] > heights[rightHighestIndex]) {
        rightHighestIndex = i;
      }else {
        int diff = heights[rightHighestIndex] - heights[i]; 
        result += diff;
      }
    }
    return result;
  }

  
  
}
