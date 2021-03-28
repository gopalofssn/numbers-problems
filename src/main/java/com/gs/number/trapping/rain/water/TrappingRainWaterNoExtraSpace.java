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
    
    if (heights == null || heights.length == 0)
      return 0;

    int supremeHightIndex = findSupremeHightIndex(heights);
    
    return leftSideWaterTrap(heights, supremeHightIndex) + rightSideWaterTrap(heights, supremeHightIndex);
  }

  private int rightSideWaterTrap(int[] heights, int supremeHightIndex) {

    int total = 0;
    int rightMaxIndex = heights.length - 1;
    
    for ( int index = rightMaxIndex - 2; index > supremeHightIndex; index--) {
      if ( heights[index] > heights[rightMaxIndex]) {
        rightMaxIndex = index;
      }else {
        int trapAmountAtIndex = ( heights[rightMaxIndex] - heights[index]);
        total += trapAmountAtIndex;
      }
    }
        
    return total;
  }

  private int leftSideWaterTrap(int[] heights, int supremeHightIndex) {
    
    int total = 0;
    int leftMaxIndex = 0;
    
    for (int index = 1; index < supremeHightIndex; index++) {
      if ( heights[index]  > heights[leftMaxIndex]) {
        leftMaxIndex = index;
      }else {
        int trapAmountAtIndex = ( heights[leftMaxIndex] - heights[index]);
        total = total + trapAmountAtIndex;
      }
    }
    
    return total;
  }

  private int findSupremeHightIndex(int[] heights) {
    
    int supremeHightIndex = 0;
    int max = Integer.MIN_VALUE;
    
    for (int index = 0; index < heights.length; index++) {
      if( heights[index] > max) {
        supremeHightIndex = index;
        max = heights[index];
      }
    }
    
    return supremeHightIndex;
  }

}
