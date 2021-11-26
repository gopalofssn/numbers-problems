package com.gs.number.sum;

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.junit.Test;

public class SumOf3NumbersTest {
  
  private SumOf3Numbers clz = new SumOf3Numbers();
  
  @Test(expected = NoSuchElementException.class)
  public void testNull() {
    clz.find(null);
  }
  
  @Test
  public void testEmpty() {
    System.out.println(Arrays.deepToString(clz.find(new int[] {})));
  }
  
  @Test
  public void testZero() {
    System.out.println(Arrays.deepToString(clz.find(new int[] {0})));
  }
  
  @Test
  public void testCase1() {
    int[] nums = { -1, 0, 1, 2, -1, -4};
    System.out.println(Arrays.deepToString(clz.find(nums)));
  }
  
}
