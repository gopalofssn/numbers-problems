package com.gs.number.bar.histogram.max.area;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaxAreaCalculatorTest {

  private MaxAreaCalculator maxAreaCalculator  = new MaxAreaCalculatorByStackApproach();
  
  @Test
  public void testCase1() {
    int[] nums  = {1,7,6,2,5,4,8,3,8};
    assertEquals(16, maxAreaCalculator.calculate(nums));
  }
  
  @Test
  public void testCase2() {
    int[] nums  = {1,8,6,2,5,4,8,3,7};
    assertEquals(49, maxAreaCalculator.calculate(nums));
  }
  
  @Test
  public void testCase3() {
    int[] nums  = {1, 1};
    assertEquals(1, maxAreaCalculator.calculate(nums));
  }
  
  @Test
  public void testCase4() {
    int[] nums  = { 1, 2, 1};
    assertEquals(2, maxAreaCalculator.calculate(nums));
  }
  
  @Test
  public void testCase5() {
    int[] nums  = { 4, 3, 2, 1, 4};
    assertEquals(16, maxAreaCalculator.calculate(nums));
  }
  
  
  @Test
  public void testCase6() {
    int[] nums  = {1, 0, 0, 0, 1};
    assertEquals(1, maxAreaCalculator.calculate(nums));
  }
  
}
