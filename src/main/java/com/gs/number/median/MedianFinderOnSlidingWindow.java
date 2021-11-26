package com.gs.number.median;

import java.util.*;

public class MedianFinderOnSlidingWindow {

  public double[] find(int[] nums, int k) { // {1, 3, -1, 1, 4, 2, 8};
    int resultSize = nums.length - k + 1;
    double[] result = new double[resultSize];
    Comparator<Integer> indexAscComparator = buildComparator(nums);
    SortedSet<Integer> max = new TreeSet<>(indexAscComparator.reversed());
    SortedSet<Integer> min = new TreeSet<>(indexAscComparator);
    loadKLengthData(nums, max, min, k);
    for (int i = k; i < nums.length; i++) {
      int resultIndexPos = i - k;
      result[resultIndexPos] = findwindowMedian(nums, max, min);
      max.remove(resultIndexPos);
      max.add(i);
      balance(max, min);
      swap(nums, max, min);
    }
    return result;
  }

  private double findwindowMedian(int[] nums, SortedSet<Integer> max, SortedSet<Integer> min) {
    if ( max.size() >  min.size() ){
      return (double)nums[max.last()];
    }
    double sum = (double)nums[max.last()] + (double)nums[min.last()];
    return sum / 2;
  }

  private void loadKLengthData(int[] nums, SortedSet<Integer> max, SortedSet<Integer> min, int k) {
    for (int i = 0; i < k; i++) {
      max.add(i);
      balance(max, min);
      swap(nums, max, min);
    }    
  }

  private void swap(int[] nums, SortedSet<Integer> max, SortedSet<Integer> min) {
    if (max.size() == 1) {
      return;
    }
    int maxTopIndex = max.last();
    int minLowIndex = min.last();
    if (nums[maxTopIndex] <= nums[minLowIndex]) {
      return;
    }
    max.remove(maxTopIndex);
    min.remove(minLowIndex);
    max.add(minLowIndex);
    min.add(maxTopIndex);    
  }

  private void balance(SortedSet<Integer> max, SortedSet<Integer> min) {
    if (max.size() == 1) {
      return;
    }
    if (max.size() >  min.size() + 1) {
      int topIndex = max.last();
      max.remove(topIndex);
      min.add(topIndex);
    }     
  }

  private Comparator<Integer> buildComparator(int[] nums) {
    return (a, b) -> {
      if (nums[a] == nums[b]) {
        return a - b;
      }
      if (nums[a] > nums[b]) {
        return 1;
      }
      return -1;
    };
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, -1, 1, 4, 2, 8};
    int k = 3;
    System.out.println(Arrays.toString(new MedianFinderOnSlidingWindow().find(nums, k)));
  }

}
