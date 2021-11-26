package com.gs.number.median;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MedianFinderTest {
  
  @Test
  public void testCase1() {
    MedianFinderOnStream medianFinder = new MedianFinderOnStream();
    medianFinder.addNum(4);
    assertTrue(medianFinder.getMedian() == new Double(4.0));
    medianFinder.addNum(3);
    assertTrue(medianFinder.getMedian() == new Double(3.5));
    medianFinder.addNum(2);
    assertTrue(medianFinder.getMedian() == new Double(3.0));
  }
  
  @Test
  public void testCase3() {
    MedianFinderOnStream medianFinder = new MedianFinderOnStream();
    medianFinder.addNum(3);
    assertTrue(medianFinder.getMedian() == new Double(3.0));
    medianFinder.addNum(2);
    assertTrue(medianFinder.getMedian() == new Double(2.5));
  }
  
  @Test
  public void testCase2() {
    MedianFinderOnStream medianFinder = new MedianFinderOnStream();
    medianFinder.addNum(4);
    assertTrue(medianFinder.getMedian() == new Double(4.0));
    medianFinder.addNum(3);
    assertTrue(medianFinder.getMedian() == new Double(3.5));
    medianFinder.addNum(2);
    assertTrue(medianFinder.getMedian() == new Double(3.0));
    medianFinder.addNum(1);
    assertTrue(medianFinder.getMedian() == new Double(2.5));
    medianFinder.addNum(5);
    assertTrue(medianFinder.getMedian() == new Double(3.0));
  }
  
}
