package com.gs.number.bar.histogram.max.area;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MaxAreaCalculatorTest {

  @DataProvider
  public MaxAreaCalculator[] maxAreaCalculatorDataProvider() {
    return new MaxAreaCalculator[] {
        new MaxAreaCalculatorByLinear(),
        new MaxAreaCalculatorByPointerApproach()
    };
  }
  
  @Test(dataProvider = "maxAreaCalculatorDataProvider")
  public void testCase1(MaxAreaCalculator maxAreaCalculator) {
    int[] nums  = {1,7,6,2,5,4,8,3,8};
    assertEquals(49, maxAreaCalculator.calculate(nums));
  }
  
  @Test(dataProvider = "maxAreaCalculatorDataProvider")
  public void testCase2(MaxAreaCalculator maxAreaCalculator) {
    int[] nums  = {1,8,6,2,5,4,8,3,7};
    assertEquals(49, maxAreaCalculator.calculate(nums));
  }
  
  @Test(dataProvider = "maxAreaCalculatorDataProvider")
  public void testCase3(MaxAreaCalculator maxAreaCalculator) {
    int[] nums  = {1, 1};
    assertEquals(1, maxAreaCalculator.calculate(nums));
  }
  
  @Test(dataProvider = "maxAreaCalculatorDataProvider")
  public void testCase4(MaxAreaCalculator maxAreaCalculator) {
    int[] nums  = { 1, 2, 1};
    assertEquals(2, maxAreaCalculator.calculate(nums));
  }
  
  @Test(dataProvider = "maxAreaCalculatorDataProvider")
  public void testCase5(MaxAreaCalculator maxAreaCalculator) {
    int[] nums  = { 4, 3, 2, 1, 4};
    assertEquals(16, maxAreaCalculator.calculate(nums));
  }
  
}
