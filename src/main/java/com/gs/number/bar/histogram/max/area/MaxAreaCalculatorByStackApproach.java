package com.gs.number.bar.histogram.max.area;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Gopal Selvaraj
 *
 *  Time : O(n)
 *  Space : O(1)
 *  
 *  
 */
public class MaxAreaCalculatorByStackApproach implements MaxAreaCalculator{

  public int calculate(int[] heights) { 
    
    int maxArea = 0;
    int left = findNextNonZeroIndex(heights, 0);
    int right = left;
    int smallest = Integer.MAX_VALUE;
    
    while (right < heights.length) {
      if ( heights[right] != 0) {
        smallest = Math.min(smallest, heights[right]);
        right++;
        continue;
      }
      
      maxArea = Math.max(maxArea, findMaxUtil(heights, left, right, smallest));
      
      left = findNextNonZeroIndex(heights, right);
      right = left;
      
    }
    
    maxArea = Math.max(maxArea, findMaxUtil(heights, left, right, smallest));
    return maxArea;
  }
  
  

  private int findNextNonZeroIndex(int[] heights, int index) {
    
    while (index < heights.length && heights[index] == 0) {
      index++;
    }
    
    return index;
  }



  private int findMaxUtil(int[] heights, int left, int right, int smallest) {
    int maxArea = smallest * (right - left);
    Stack<Integer> indexStack = new Stack<Integer>();
    while ( left <= right) {
      if ( indexStack.isEmpty() || heights[indexStack.peek()] <=  heights[left]) {
        indexStack.push(left);
        left++;
        continue;
      }
      maxArea = Math.max(maxArea, findMaxUtil(heights, left, indexStack));
    }
    
    return maxArea;
  }



  private int findMaxUtil(int[] heights, int index, Stack<Integer> indexStack) {
    int maxArea = heights[index];
    while (!indexStack.isEmpty()) {
      int pop = indexStack.pop();
      maxArea = Math.max(maxArea, heights[pop]); // if pop height contribute max area
      int width = (index - pop);
      int height = Math.min(heights[pop], heights[index]);
      maxArea = Math.max(maxArea, height*width);
    }
    return maxArea;
  }



  public static void main(String[] args) {
    int[] nums = {1,7,6,2,5,4,8,3,8};
    System.out.println(new MaxAreaCalculatorByStackApproach().calculate(nums));
  }

}
