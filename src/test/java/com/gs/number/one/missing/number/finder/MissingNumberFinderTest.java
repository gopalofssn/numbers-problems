package com.gs.number.one.missing.number.finder;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MissingNumberFinderTest {

	@DataProvider
	public MissingNumberFinder[] missingNumberFinderProviders() {
	  return new MissingNumberFinder[] {
	    		new MissingNumberFinderUsingBinarySearch(),
	    		new MissingNumberFinderUsingCalculation(),
	    		new MissingNumberFinderUsingXOR()
	  };
	}
	
	@Test(dataProvider = "missingNumberFinderProviders", expectedExceptions  = IllegalArgumentException.class)
	public void testNullScnerio(MissingNumberFinder missingNumberFinder)  {
		int[] nums = null;
		missingNumberFinder.missingNumber(nums);
	}

	@Test(dataProvider = "missingNumberFinderProviders", expectedExceptions = IllegalArgumentException.class)
	public void testEmptyScnerio(MissingNumberFinder missingNumberFinder)  {
		int[] nums = {};
		missingNumberFinder.missingNumber(nums);
	}

	@Test(dataProvider = "missingNumberFinderProviders")
	public void testMiddleScnerio(MissingNumberFinder missingNumberFinder)  {
		int[] nums = { 1, 2, 4, 5, 6 };
		int actualValue = missingNumberFinder.missingNumber(nums);
		assertEquals(3, actualValue);
	}

	@Test(dataProvider = "missingNumberFinderProviders")
	public void testFirstNumberMissingScnerio(MissingNumberFinder missingNumberFinder)  {
		int[] nums = { 2, 3, 4, 5, 6 };
		int actualValue = missingNumberFinder.missingNumber(nums);
		assertEquals(1, actualValue);
	}

	@Test(dataProvider = "missingNumberFinderProviders")
	public void testLastMissingScnerio(MissingNumberFinder missingNumberFinder)  {
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		missingNumberFinder.missingNumber(nums);
	}

}
