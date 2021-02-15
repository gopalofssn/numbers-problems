package com.gs.number.one.missing.number.finder;

public class MissingNumberFinderService {

	private MissingNumberFinder missingNumberFinder;

	public MissingNumberFinderService(MissingNumberFinder missingNumberFinder) {
		this.missingNumberFinder = missingNumberFinder;
	}

	public int find(int[] nums) {
		return missingNumberFinder.missingNumber(nums);
	}
}
