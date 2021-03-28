package com.gs.number.trapping.rain.water;

/**
 * 
 * @author Gopal Selvaraj
 *  I / P   :   [0,1,0,2,1,0,1,3,2,1,2,1]
    holder  :   [0,1,1,2,2,2,2,3,3,3,3,3]   - max
                 3 3 3 3 3 3 3 3 2 2 2 1     - right max val
    holder  :   [0,1,1,2,2,2,2,3,2,2,2,1]   -  min ( holder, right max val)
    
     diff       [0,0,1,0,1,2,1,0,0,1,0,0] - (holder - height)
    
    
 */
public class TrappingWaterOneExtraArray implements TrappingRainWater{

  @Override
  public int trap(int[] heights) {
    
    if (heights == null || heights.length == 0) return 0;
    
    final int LEN = heights.length;
    int[] holder = new int[LEN];
    calculateLeftMax(heights, holder, LEN);
    calculateRightMax(heights, holder, LEN);
    
    int total = 0;
    for ( int index = 0; index < LEN; index++) {
      int diff = holder[index] - heights[index];
      if ( diff > 0) {
        total += diff;
      }
    }
    return total;
  }

  
  private void calculateRightMax(int[] heights, int[] holder, final int LEN) {

    int max = Integer.MIN_VALUE;
    for ( int index = LEN - 1; index >= 0; index--) {
      max = Math.max(max, heights[index]); // holder to keep right max
      int min = Math.min(max, holder[index]);
      holder[index] = min;
    }
    
  }


  private void calculateLeftMax(int[] heights, int[] holder, final int LEN) {

    int max = Integer.MIN_VALUE;
    for ( int index = 0; index < LEN; index++) {
      max = Math.max(max, heights[index]);
      holder[index] = max;
    }
    
  }

  
}
