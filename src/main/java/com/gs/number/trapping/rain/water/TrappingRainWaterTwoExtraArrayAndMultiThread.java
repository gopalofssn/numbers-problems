package com.gs.number.trapping.rain.water;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TrappingRainWaterTwoExtraArrayAndMultiThread implements TrappingRainWater{

  private ExecutorService executorService = Executors.newFixedThreadPool(2);
  
  @Override
  public int trap(int[] heights) {
    
    Callable<int[]> leftMaxHeightsCallable = () ->{
      return findLeftMaxHeights(heights);
    };
    Future<int[]> leftMaxHeightsFuture =  executorService.submit(leftMaxHeightsCallable);
    
     
    Callable<int[]> rightMaxHeightsCallable = () ->{
      return findRightMaxHeights(heights);
    };
    Future<int[]> rightMaxHeightsFuture =  executorService.submit(rightMaxHeightsCallable);
    
    
    int[] leftMaxHeights = get(leftMaxHeightsFuture);
    int[] rightMaxHeights = get(rightMaxHeightsFuture);
    
    int total = 0;
    for (int index = 0; index < heights.length; index++) {
      int min = Math.min(leftMaxHeights[index], rightMaxHeights[index]);
      int diff = min - heights[index];
      if (diff > 0) {
        total += diff;
      }
    }

    return total;
  }

  
  private int[] get(Future<int[]> leftMaxHeightsFuture) {
    // TODO Auto-generated method stub
    try {
      return leftMaxHeightsFuture.get();
    } catch (InterruptedException| ExecutionException e) {
      return new int[] {};
    }
  }

  private int[] findRightMaxHeights(int[] heights) {
    int[] rightMaxHeights = new int[heights.length];
    int max = Integer.MIN_VALUE;

    for (int index = heights.length - 1; index >= 0; index--) {
      max = Math.max(max, heights[index]);
      rightMaxHeights[index] = max;
    }

    return rightMaxHeights;
  }

  private int[] findLeftMaxHeights(int[] heights) {
    int[] leftMaxHeights = new int[heights.length];
    
    int max = Integer.MIN_VALUE;

    Arrays.stream(heights)
          .forEach(System.out::println);
    
    
    for (int index = 0; index < heights.length; index++) {
      max = Math.max(max, heights[index]);
      leftMaxHeights[index] = max;
    }

    return leftMaxHeights;
  }

}
