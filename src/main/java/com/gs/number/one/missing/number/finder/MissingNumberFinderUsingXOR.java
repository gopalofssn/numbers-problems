package com.gs.number.one.missing.number.finder;

public class MissingNumberFinderUsingXOR extends MissingNumberFinderHelper implements MissingNumberFinder{

	/* ^ concept
	 * -------
	 * 0 ^ 0 = 0
	 * 1 ^ 1 = 0
	 * 2 ^ 2 = 0
	 * 
	 * 2 ^ 3 !=0
	 * 
	 * Time : O(n)
	 * Space : O(1)
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
		
		int n = nums[length - 1];
		int index = 0;
		for(int expectedNumber = 1 ; expectedNumber < n; expectedNumber++) {
			int actualNumber = nums[index];
			if((expectedNumber ^ actualNumber) != 0) {
				return expectedNumber;
			}
			index++;
		}
		 
		throw new IllegalArgumentException("There is no numbers missing");
		
	}

	public static void main(String[] args) {
		System.out.println(0 ^ 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8);
	}
}
