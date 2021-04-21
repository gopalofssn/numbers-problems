package com.gs.number.trapping.rain.water;

import static org.testng.Assert.assertEquals;
 import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrappingRainWaterTest {

  @DataProvider
  public TrappingRainWater[] trappingRainWaterDataProvider() {
    return new TrappingRainWater[] {
        new TrappingRainWaterTwoExtraArray(),
        new TrappingWaterOneExtraArray(),
        new TrappingRainWaterTwoExtraArrayAndMultiThread(),
        //new TrappingRainWaterNoExtraSpace()
        };
  }

  @Test(dataProvider = "trappingRainWaterDataProvider")
  public void testCase1(TrappingRainWater trappingRainWater) {
    int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    assertEquals(trappingRainWater.trap(heights), 6);
  }

  
  @Test(dataProvider = "trappingRainWaterDataProvider")
  public void testCase2(TrappingRainWater trappingRainWater) {
    int[] heights = {0, 1, 0, 2};
    assertEquals(trappingRainWater.trap(heights), 1);
  }
  
  
  @Test(dataProvider = "trappingRainWaterDataProvider")
  public void testCase3(TrappingRainWater trappingRainWater) {
    int[] heights = {0, 1, 1, 2};
    assertEquals(trappingRainWater.trap(heights), 0);
  }
  
  
  @Test(dataProvider = "trappingRainWaterDataProvider")
  public void testCase4(TrappingRainWater trappingRainWater) {
    int[] heights = {3, 2, 1, 2, 1};
    assertEquals(trappingRainWater.trap(heights), 1);
  }
  
}
