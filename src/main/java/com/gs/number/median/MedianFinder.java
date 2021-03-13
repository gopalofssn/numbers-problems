package com.gs.number.median;

/**
 * Refer Leetcode 295 : Find median from data stream
 * @author Gopal Selvaraj
 *
 */
public interface MedianFinder {

  public void addNums(int[] nums);
  
  public void addNum(int num);

  public double getMedian();

}
