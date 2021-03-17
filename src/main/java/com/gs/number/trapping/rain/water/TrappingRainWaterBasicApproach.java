package com.gs.number.trapping.rain.water;

/*
basic approach
--------------
I / P   :   [0,1,0,2,1,0,1,3,2,1,2,1]
Left    :   [0,1,1,2,2,2,2,3,3,3,3,3]   - max
Right   :   [3,3,3,3,3,3,3,3,2,2,2,1]   - max
formula  to hold water each index- 
   min(left max, right max) - height[index]
            [0,0,1,0,1,2,1,0,0,1,0,0]
            = 1 + 1 + 2 + 1 + 1
            = 6
            
   Time : O(n) , actually O(3 *n)
   Space : O(n) , actually O(2 * n) , two storage
*/

public class TrappingRainWaterBasicApproach implements TrappingRainWater{

  public int trap(int[] heights) {
    // TODO Auto-generated method stub
    return 0;
  }

}
