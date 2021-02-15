package com.gs.number.multiple.missing.number.finder;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MissingMultipleNumbersFinderUsingXORTest{

	@DataProvider
	public MissingMultipleNumbersFinder[] missingMultipleNumbersFinderProviders() {
	  return new MissingMultipleNumbersFinder[] {
	    		      new MissingMultipleNumbersFinderUsingXOR()
	             };
	}

	@Test(dataProvider = "missingMultipleNumbersFinderProviders")
	public void testNullScnerio(MissingMultipleNumbersFinder missingMultipleNumbersFinder) throws NoSuchFieldException{
		int[] nums = null;
		int[] actualValue = missingMultipleNumbersFinder.findmissingNumbers(nums, 0);
		assertEquals(new int[] {}, actualValue);
	}

	@Test(dataProvider = "missingMultipleNumbersFinderProviders")
	public void testEmptyScnerio(MissingMultipleNumbersFinder missingMultipleNumbersFinder) throws NoSuchFieldException{
		int[] nums = {};
		int[] actualValue = missingMultipleNumbersFinder.findmissingNumbers(nums, 2);
		assertEquals(new int[] {1, 2}, actualValue);
	}

	@Test(dataProvider = "missingMultipleNumbersFinderProviders")
	public void testMiddleScnerio(MissingMultipleNumbersFinder missingMultipleNumbersFinder) throws NoSuchFieldException{
		int[] nums = { 1, 2, 5, 6 };
		int[] actualValue = missingMultipleNumbersFinder.findmissingNumbers(nums, 6);
		assertEquals(new int[] {3, 4}, actualValue);
	}

	@Test(dataProvider = "missingMultipleNumbersFinderProviders")
	public void testFirstNumberMissingScnerio(MissingMultipleNumbersFinder missingMultipleNumbersFinder) throws NoSuchFieldException{
		int[] nums = { 2, 3, 4, 5, 6 };
		int[] actualValue = missingMultipleNumbersFinder.findmissingNumbers(nums, 6);
		assertEquals(new int[] {1}, actualValue);
	}

	@Test(dataProvider = "missingMultipleNumbersFinderProviders", expectedExceptions = NoSuchFieldException.class)
	public void testLastMissingScnerio(MissingMultipleNumbersFinder missingMultipleNumbersFinder) throws NoSuchFieldException {
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		missingMultipleNumbersFinder.findmissingNumbers(nums, 6);
	}
	
}
