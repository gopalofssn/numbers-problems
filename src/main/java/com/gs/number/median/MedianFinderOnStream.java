package com.gs.number.median;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Refer Leetcode 295 : Find median from data stream
 * @author Gopal Selvaraj
 * 
 */
public class MedianFinderOnStream {

  private Queue<Integer> maxHeap;
  private Queue<Integer> minHeap;
  
  
  public MedianFinderOnStream() {
    Comparator<Integer> cmp = (a, b) -> {
      if (a <= b ) return 1;
      else return -1;
    };
    maxHeap = new PriorityQueue<>(cmp);
    minHeap = new PriorityQueue<>();
  }

   public void addNum(int num) {
    maxHeap.add(num);
    balance();
  }

  private void balance() {
    if (maxHeap.size() == 1) {
      return;
    }
    
    if (maxHeap.size() > minHeap.size() + 1) {
      int num = maxHeap.poll();
      minHeap.offer(num);
    }
   
    swap();    
  }

  private void swap() {
    if (maxHeap.peek() < minHeap.peek()) {
      return;
    }
    int numToMini = maxHeap.poll();
    int numToMax = minHeap.poll();    
    maxHeap.offer(numToMax);
    minHeap.offer(numToMini);
  }

   public double getMedian() {
    if (maxHeap.size() == minHeap.size() + 1) {
      return maxHeap.peek();
    }

    int peekNumMax = maxHeap.peek();
    int peekNumMin = minHeap.peek();
    
    return ( (double)peekNumMax + (double) peekNumMin ) / 2;
  }
  
  
}
