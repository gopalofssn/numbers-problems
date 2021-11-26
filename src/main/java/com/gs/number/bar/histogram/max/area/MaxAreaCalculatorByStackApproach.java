package com.gs.number.bar.histogram.max.area;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Gopal Selvaraj
 *
 *         Time : O(n) Space : O(1)
 * 
 * 
 */
class Segment {
  int start;
  int end;
  int smallest;

  public Segment(int start, int end, int smallest) {
    this.start = start;
    this.end = end;
    this.smallest = smallest;
  }

  public int segmentHorizontalArea() {
    int height = smallest;
    int width = end - start + 1;
    return (height * width);
  }
  
  @Override
  public String toString() {
    return "Segment [start=" + start + ", end=" + end + ", smallest=" + smallest + "]";
  }

}


public class MaxAreaCalculatorByStackApproach implements MaxAreaCalculator {

  public int calculate(int[] heights) {

    List<Segment> segmentList = new ArrayList<Segment>(); // segment list and avoid zero in middle
    buildSegmentList(heights, 0, segmentList);
    int maxArea = 0;
    for (Segment segment : segmentList) {
      int areaBySegment = findAreaOfSegment(heights, segment);
      System.out.println("segment max - " + areaBySegment);
      maxArea = Math.max(maxArea, areaBySegment);      
    }

    return maxArea;
  }



  private int findAreaOfSegment(int[] heights, Segment segment ) {
    
    int max = segment.segmentHorizontalArea(); // entire segment area with smallest max?
    Stack<Integer> stack = new Stack<>();
    int index = segment.start;
    while (index <= segment.end) {
      max = Math.max(max, heights[index]); // current index height max?
      boolean isPushToStack = isPushToStack(heights, index, stack);
      if(isPushToStack) {
        stack.push(index);
        System.out.println("pushed index " + index + " , max " + max);
        index++;
      }else {
        int pop = stack.pop();
        int width = index - pop;
        int height = heights[pop];
        max = Math.max(max, height * width);
      }  
      System.out.println("index " + index + " , stack " + stack);
    }
    
    while( !stack.isEmpty()) {
      int pop = stack.pop();
      int width = index - pop ;
      int area = heights[pop] * width;
      max = Math.max(max, area); 
    }
    
    return max;
  }

  private boolean isPushToStack(int[] heights, int index, Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return true;
    }
    
    int peek = stack.peek();
    if (heights[index] >= heights[peek]) {
      return true;
    }
    
    return false;
  }



  private void buildSegmentList(int[] heights, int pos, List<Segment> segmentList) {
    if (pos >= heights.length) {
      return;
    }
    
    while ( pos < heights.length && heights[pos] == 0) {
      pos++;
    }
    int start = pos;
    
    int smallest = Integer.MAX_VALUE;
    
    while ( pos < heights.length && heights[pos] != 0) {
      smallest = Math.min(smallest, heights[pos]);
      pos++;
    }
    int end = pos - 1;
    
    segmentList.add(new Segment(start, end, smallest));
    buildSegmentList(heights, pos + 1, segmentList);
  }


  public static void main(String[] args) {
    int[] nums = {1,7,7,2,5,4,8,3,8, 8};
               // 0 1 2 3 4 5 6 7 8,
    MaxAreaCalculatorByStackApproach clz = new MaxAreaCalculatorByStackApproach();
    List<Segment> segmentList = new ArrayList<Segment>();
    clz.buildSegmentList(nums, 0, segmentList);
    System.out.println(clz.calculate(nums));
  }

}
