package com.gs.number.bar.snow.problem;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

public class LandscapeWithSnowTests {

  private LandscapeWithSnow landscapeWithSnow = new LandscapeWithSnow();
  
  @Test
  public void testCase0() {
    int[] heights = { 4,1,1,3,1,2,3 }; 
                   //       ^
    System.out.println("input - " + Arrays.toString(heights));
    int totalUnitOfSnow = 8;
    int positionToSnow = 3;
    int[] actuals = landscapeWithSnow.afterSnow(heights, totalUnitOfSnow, positionToSnow);
    System.out.println("actuals - " + Arrays.toString(actuals));
    int[] expecteds = {4,3,3,4,3,3,3};
    assertArrayEquals(expecteds, actuals);
  }
  
  @Test
  public void testCase1() {
    int[] heights = { 2,1,1,2,1,2,3 }; 
                   //       ^
    System.out.println("input - " + Arrays.toString(heights));
    int totalUnitOfSnow = 6;
    int positionToSnow = 3;
    int[] actuals = landscapeWithSnow.afterSnow(heights, totalUnitOfSnow, positionToSnow);
    System.out.println("actuals - " + Arrays.toString(actuals));
    int[] expecteds = {2,2,2,5,2,2,3};
    assertArrayEquals(expecteds, actuals);
  }
  
  @Test
  public void testCase2() {
    int[] heights = { 1,7,6,2,5,4,7,3,7 }; 
    System.out.println("input - " + Arrays.toString(heights));
    int totalUnitOfSnow = 15;
    int positionToSnow = 4;
    int[] actuals = landscapeWithSnow.afterSnow(heights, totalUnitOfSnow, positionToSnow);
    System.out.println("actuals - " + Arrays.toString(actuals));
    int[] expecteds = {1,7,6,4,6,4,7,3,7};
    assertArrayEquals(expecteds, actuals);
  }
}
