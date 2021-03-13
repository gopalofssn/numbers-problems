package com.gs.number.median;

import java.util.PriorityQueue;
/**
 * Refer Leetcode 295 : Find median from data stream
 * @author Gopal Selvaraj
 * 
 */
public class MedianFinderUsingHeap implements MedianFinder {

  PriorityQueue<Integer> maxHeap; // to hold first half
  PriorityQueue<Integer> miniHeap; // to hold second half
  
  public MedianFinderUsingHeap() {
    maxHeap = new PriorityQueue<Integer>();
    miniHeap = new PriorityQueue<Integer>();
  }
  
  public void addNums(int[] nums) {
    
    for (int num : nums) {
      addNum(num);
    }
    
  }
  
  public void addNum(int num) {
    
    miniHeap.offer(num);
    
    if(!maxHeap.isEmpty() && maxHeap.peek() > miniHeap.peek()) {
      swap();
    }
    
    if(maxHeap.size() +1 != miniHeap.size()) {
      int toMax = miniHeap.poll();
      maxHeap.offer(toMax);
    }
    
  }

  private void swap() {
    int toMini = maxHeap.poll();
    int toMax = miniHeap.poll();
    miniHeap.offer(toMini);
    maxHeap.offer(toMax);    
  }

  public double getMedian() {
    
    if (miniHeap.size() == maxHeap.size()) {
      return getAvg();
    }
    
    return miniHeap.peek();
  }

  private double getAvg() {
    
    if (miniHeap.size() == 0) {
      return 0.0;
    }
    
    double num1 = (double)miniHeap.peek() / 2;
    double num2 = (double)maxHeap.peek() / 2;
    
    return num1 + num2;
  }

}
