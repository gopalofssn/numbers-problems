package com.gs.number.bar.histogram.max.area;

import com.gs.number.first.less.height.FindFirstLessHeightLeftIndex;
import com.gs.number.first.less.height.FindFirstLessHeightRightIndex;

public class MaxAreaCalculatorByLeftAndRightFirstLessHeightApproach implements MaxAreaCalculator {

  public int calculate(int[] heights) {

    int[] firstLessHeightRightIndex = new FindFirstLessHeightRightIndex(heights).findRightLessHeight();
    int[] firstLessHeightLeftIndex = new FindFirstLessHeightLeftIndex(heights).findLeftLessHeight();
    int area = Integer.MIN_VALUE;
    for (int i = 0; i < heights.length; i++) {
      int height = heights[i];
      int width = firstLessHeightRightIndex[i] - firstLessHeightLeftIndex[i] - 1;
      area = Math.max(area, height * width);
    }
    return area;
  }



  public static void main(String[] args) {
    int[] nums = {1,7,7,2,5,4,8,3,8,8};
               // 0 1 2 3 4 5 6 7 8,
    MaxAreaCalculatorByLeftAndRightFirstLessHeightApproach clz = new MaxAreaCalculatorByLeftAndRightFirstLessHeightApproach();
    System.out.println(clz.calculate(nums));
  }

}
