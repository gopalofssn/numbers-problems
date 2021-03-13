package com.gs.number.median;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MedianFinderTest {

  @DataProvider
  public MedianFinder[] medianFinderDataProvider() {
    return new MedianFinder[] {
      new MedianFinderUsingHeap()
    };
  }
  
  @Test(dataProvider = "medianFinderDataProvider")
  public void testCase1(MedianFinder medianFinder) {
    medianFinder.addNums(new int[]{ 4, 3, 2});
    assertEquals(medianFinder.getMedian(), 3.0);
  }
  
  @Test(dataProvider = "medianFinderDataProvider")
  public void testCase3(MedianFinder medianFinder) {
    medianFinder.addNums(new int[]{ 3, 2});
    assertEquals(medianFinder.getMedian(), 2.5);
  }
  
  @Test(dataProvider = "medianFinderDataProvider")
  public void testCase2(MedianFinder medianFinder) {
    medianFinder.addNums(new int[]{ 4, 3, 2, 1, 5});
    assertEquals(medianFinder.getMedian(), 3.0);
  }
  
}
