package com.gs.number.find.gift.pair;

import java.util.Arrays;
import java.util.Comparator;

public class FindTwoGift {

  public String[] find(Product[] products, final float total) {
    Comparator<Product> cmp =  Product::compareByPrice;
    cmp = cmp.thenComparing(Product::compareByName);
    Arrays.sort(products, cmp);
   
    int left = 0;
    int right = products.length - 1;
    String[] result = null;
    float prevDiff = Float.MAX_VALUE;
    while ( left < right) {
      Product leftProduct = products[left];
      Product rightProduct = products[right];
      
      float priceOfLeftAndRightItem = leftProduct.getProductPrice() + rightProduct.getProductPrice();
      if (priceOfLeftAndRightItem > total) {
        right--;
        continue;
      }

      float currentDiff = total - priceOfLeftAndRightItem;
      if (currentDiff < 0) {
        System.out.println("break at " + leftProduct + " vs " + rightProduct);
        break;
      }
      
      if ( currentDiff <= prevDiff) {
        prevDiff = currentDiff;
        result = new String[]{leftProduct.getProductName(), rightProduct.getProductName()};
        left++;
        continue;
      }

      left++;
      right--;
    }
    
    
    return result;
    
  }
}
