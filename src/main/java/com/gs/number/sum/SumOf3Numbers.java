package com.gs.number.sum;

import java.util.*;
// sum of 3 nums , that give 0
public class SumOf3Numbers {

  public static void main(String[] args) {
    int[] nums = { -1, 0, 1, 2, -1, -4};
    System.out.println(Arrays.deepToString(new SumOf3Numbers().find(nums)));
  }

  public int[][] find(int[] nums) {
    if ( nums == null) {
      throw new NoSuchElementException("Nums array is null or empty !!!");
    }
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    for ( int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int remain = 0 - nums[i];
      int[][] pairs = findPairs(nums, i + 1, remain);
      for ( int[] pair : pairs) {
        List<Integer> threeNums = new ArrayList<Integer>(Arrays.asList(nums[i], pair[0], pair[1]));
        result.add(threeNums);
      }
    }
    return convertAndSend(result);
  }

  private int[][] findPairs(int[] nums, int left, int target) {
    int right = nums.length - 1;
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    while ( left < right) {
     int sum = nums[left] + nums[right];
     if ( sum == target) {
       List<Integer> pair = new ArrayList<Integer>(Arrays.asList(nums[left], nums[right]));
       result.add(pair);
       right--;
     }else if ( sum > target) {
       right--;
     }else {
       left++;
     }
    }
    return convertAndSend(result);
  }

  private int[][] convertAndSend(List<List<Integer>> numsofnums) {
    int[][] result = new int[numsofnums.size()][];
    int idx = 0;
    for ( List<Integer> nums : numsofnums) {
      result[idx] = nums.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
      idx++;
    }
    return result;
  }

}
