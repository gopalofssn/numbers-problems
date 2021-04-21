package com.gs.segment.without.zero;

import java.util.ArrayList;
import java.util.List;

public class FindNonZeroSegments {

  class Range{
    private int left;
    private int right;
    public Range(int left, int right) {
      this.left = left;
      this.right = right;
    }
    @Override
    public String toString() {
      return "\n Non Zero Range [left=" + left + ", right=" + right + "]";
    } 
  }
  
  private List<Range> find(int[] nums) {
    List<Range> result = new ArrayList<Range>();
    
    int left = nextNonZeroIndex(nums, 0);
    int right = left;
    
    while(right < nums.length) {    
      if ( nums[right] != 0) {
        right++;
        continue;
      }
      result.add(new Range(left, right - 1));
      
      left = nextNonZeroIndex(nums, right);
      right = left;
    }
    
    if(left != right) {
      result.add(new Range(left, right - 1));
    }
    
    return result;
  }
  
  private int nextNonZeroIndex(int[] nums, int index) {
    while ( index < nums.length && nums[index] == 0) {
      index++;
    }
    return index;
  }

  public static void main(String[] args) {
    int[] nums = {1, 0, 1, 1, 0, 1};
    System.out.println(new FindNonZeroSegments().find(nums));
    
    nums = new int[] {0, 0, 0, 1, 0, 1};
    System.out.println(new FindNonZeroSegments().find(nums));
    
    nums = new int[] {0, 0, 0, 0, 0, 0};
    System.out.println(new FindNonZeroSegments().find(nums));
    
  }
  
}
