package com.gs.number.bar.histogram.max.area;

/*
https://leetcode.com/problems/container-with-most-water/
Input: [1,8,6,2,5,4,8,3,7]
Output: 49

max area it can frame 

8   | --------|---
7   |         |   |
6   | |       |   |
5   | |   |   |   |
4   | |   | | |   |
3   | |   | | | | |
2   | | | | | | | |
1 | | | | | | | | |
  0 1 2 3 4 5 6 7 8 
    
 */
public interface MaxAreaCalculator {

  public int calculate(int[] nums);
  
}
