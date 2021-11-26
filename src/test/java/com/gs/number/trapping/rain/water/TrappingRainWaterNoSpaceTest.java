package com.gs.number.trapping.rain.water;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TrappingRainWaterNoSpaceTest {

  private TrappingRainWaterTwoExtraArray trappingRainWater= new TrappingRainWaterTwoExtraArray();

  @Test
  public void testCase1() {
    int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    assertEquals(trappingRainWater.trap(heights), 6);
  }

  
  @Test
  public void testCase2() {
    int[] heights = {0, 1, 0, 2};
    assertEquals(trappingRainWater.trap(heights), 1);
  }
  
  
  @Test
  public void testCase3() {
    int[] heights = {0, 1, 1, 2};
    assertEquals(trappingRainWater.trap(heights), 0);
  }
  
  
  @Test
  public void testCase4() {
    int[] heights = {3, 2, 1, 2, 1};
    assertEquals(trappingRainWater.trap(heights), 1);
  }
  
}
