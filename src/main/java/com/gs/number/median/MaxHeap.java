package com.gs.number.median;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxHeap{

  private Queue<Integer> queue;
  
  public MaxHeap() {
    Comparator<Integer> cmp = ( a, b) -> {
      if(a < b) return 1;
      else return -1;
    };
    this.queue = new PriorityQueue<Integer>(cmp);
  }
  
  public void add(int[] nums) {
    for ( int num : nums) {
      queue.offer(num);
    }
  }
  
  public void print() {
    
    while( !queue.isEmpty()) {
      System.out.println(queue.poll());
    }
    
  }
  
  public static void main(String[] args) {
    int[] nums = { 4, 2, 3, 1, 4, 5};
    MaxHeap maxHeap = new MaxHeap();
    maxHeap.add(nums);
    maxHeap.iterate();
    maxHeap.print();
  }

  private void iterate() {
    Iterator<Integer> iterator = queue.iterator();
    while ( iterator.hasNext()){
      System.out.println(iterator.next());
    }
  }

}
