package com.gs.number.find.gift.pair;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class FindTwoGiftTests {

  private Product[] products = {
                  new Product("Hat", 15.00f), 
                  new Product("Cat", "15.00"), 
                  new Product("Teddy Bear", 25.75f),
                  new Product("Speaker", 59.99f), 
                  new Product("Necklace", 129.95f),
                  new Product("Chair", 145.99f),
                  new Product("Kayak", 209.25f), 
                  new Product("xbox", 295.95f)
                  };
  private FindTwoGift towgift = new FindTwoGift();
  
  @Test
  public void testCase1() {
    String[] actual = towgift.find(products, 165.0f);
    assertArrayEquals(new String[]{"Hat", "Chair"}, actual);
  }

  @Test
  public void testCase2() {
    String[] actual = towgift.find(products, 65.0f);
    assertArrayEquals(new String[]{"Hat", "Teddy Bear"}, actual);
  }
  
  @Test
  public void testCas3() {
    String[] actual = towgift.find(products, 75.0f);
    assertArrayEquals(new String[]{"Hat", "Speaker"}, actual);
  }
  
}
