package com.gs.number.multiple.missing.number.finder;

public class MissingMultipleNumbersFinderUsingXOR implements MissingMultipleNumbersFinder{

	/*
	 * Iunput : Sorted array from 1... n(- missing)
	 * 
	 */
	public int[] findmissingNumbers(int[] nums, int totalNumbers) throws NoSuchFieldException {
		if(isNullOrEmpty(nums)) {
			return constructAllMissedNumbers(totalNumbers);
		}
		
		int totalMissedNumbers = totalNumbers - nums.length;
		
		if(totalMissedNumbers == 0) {
			throw new NoSuchFieldException("No numbers are missing");
		}
		
		int[] missedNumbers = new int[totalMissedNumbers];
		int missedNumbersIndex = 0;
		int numsIndex = 0;
		
		for(int expectedNumber = 1; expectedNumber <= totalNumbers ; expectedNumber++) {
			int actualNumber = nums[numsIndex];
			if ( (actualNumber ^ expectedNumber) != 0) {
				missedNumbers[missedNumbersIndex] = expectedNumber;
				missedNumbersIndex++;
			}else {
				numsIndex++;
			}
		}
		
		return missedNumbers;
	}

	private int[] constructAllMissedNumbers(int totalNumbers) {
		int[] nums = new int[totalNumbers];
		int index = 0;
		while(index < totalNumbers) {
			int num = index + 1;
			nums[index] = num;
			index++;
		}
		return nums;
	}

	private boolean isNullOrEmpty(int[] nums) {
		return nums == null || nums.length == 0;
	}
}
