package com.gs.number.bar.histogram.max.area;

public class MaxAreaCalculatorByLinear implements MaxAreaCalculator {

  public int calculate(int[] nums) {

    int maxArea = Integer.MIN_VALUE;
    for (int left = 0; left < nums.length; left++) {
      final int left_height = nums[left];
      for (int right = left + 1; right < nums.length; right++) {
        int height = Math.min(left_height, nums[right]);
        int width = (right - left);
        int area = height * width;
        maxArea = Math.max(maxArea, area);
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[] nums = {1, 7, 6, 2, 5, 4, 8, 3, 8};
    System.out.println(new MaxAreaCalculatorByLinear().calculate(nums));
  }
}
