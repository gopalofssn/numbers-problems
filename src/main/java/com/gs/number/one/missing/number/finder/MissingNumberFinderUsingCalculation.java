package com.gs.number.one.missing.number.finder;

public class MissingNumberFinderUsingCalculation extends MissingNumberFinderHelper implements MissingNumberFinder{

	/*
	 * Time : O(n)
	 * Space : O(1)
	 * issue : integer overflow 
	 */
	public int missingNumber(int[] nums) {

		if (isNullOrEmpty(nums)) {
			throw new IllegalArgumentException("Input nums is either null or empty !");
		}

		if (nums[0] != 1) {
			return 1;
		}

		int length = nums.length;
		int expectedValueAtLast = length + 1;
		if (nums[length - 1] != expectedValueAtLast) {
			return expectedValueAtLast;
		}
		
		int n = length + 1;
		int sum =  ((n)*(n + 1)) / 2; // integer overflow
		for(int num : nums) {
			sum -= num;  // O(n) time
		}
		return sum;
	
	}

}
