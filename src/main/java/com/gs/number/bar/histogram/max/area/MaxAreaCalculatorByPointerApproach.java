package com.gs.number.bar.histogram.max.area;

public class MaxAreaCalculatorByPointerApproach implements MaxAreaCalculator{

  public int calculate(int[] nums) {
    
    int maxArea = Integer.MIN_VALUE;
    int left = 0;
    int right = nums.length - 1;
    
    do{
      int leftHeight = nums[left];
      int rightHeight = nums[right];
      
      int height = Math.min(leftHeight, rightHeight);
      int width =  (right - left);
      int area = (height * width);
      
      maxArea = Math.max(maxArea, area);

      if(leftHeight == rightHeight) {
        break;
      }else if(leftHeight < rightHeight) {
        left++;
      }else {
        right--;
      }
      
    }while ( left < right);
    
    return maxArea;
  }
  
  public static void main(String[] args) {
    int[] nums = {1, 7, 6, 2, 5, 4, 8, 3, 8};
    System.out.println(new MaxAreaCalculatorByPointerApproach().calculate(nums));
  }

}
