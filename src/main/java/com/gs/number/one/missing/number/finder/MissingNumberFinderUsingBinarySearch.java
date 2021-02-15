package com.gs.number.one.missing.number.finder;

public class MissingNumberFinderUsingBinarySearch extends MissingNumberFinderHelper implements MissingNumberFinder{

	/*
	 * Time : O(log n)
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

		return missingNumberHelper(nums);

	}

	private int missingNumberHelper(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + ((right - left) / 2);
			int actualValueAtMid = nums[mid];
			int expectedValueAtMid = mid + 1;

			if (actualValueAtMid == expectedValueAtMid) {
				left = mid;
				continue;
			}

			int nextValueToMid = nums[mid + 1];
			if (nextValueToMid != expectedValueAtMid + 1) {
				return expectedValueAtMid;
			}

			right = mid;
		}

		throw new IllegalArgumentException("There is no numbers missing");
	}

}
