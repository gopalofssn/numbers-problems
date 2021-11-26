package com.gs.number.find.gift.pair;

import java.util.*;

public class Product {

  private float productPrice;
  private String productName;

  public Product(String productName, String productPrice) {
    this(productName, new Float(productPrice));
  }

  public Product(String productName, float productPrice) {
    this.productPrice = productPrice;
    this.productName = productName;
  }

  public float getProductPrice() {
    return productPrice;
  }

  public String getProductName() {
    return productName;
  }

  @Override
  public String toString() {
    return "Product [productPrice=" + productPrice + ", productName=" + productName + "]";
  }
  
  public static int compareByPrice(Product left, Product right) {
    return Float.compare(left.productPrice, right.productPrice);
  }

  public static int compareByName(Product left, Product right) {
    return left.productName.compareTo(right.productName);
  }
  
  public static void main(String[] args) {
    Product[] products = {new Product("Kayak", 209.25f), new Product("xbox", 295.95f),
        new Product("Hat", 15.00f), new Product("Cat", "15.00"), new Product("Teddy Bear", 25.75f),
        new Product("Speaker", 59.99f), new Product("Necklace", 129.95f),
        new Product("Chair", 145.99f)};
    
    Comparator<Product> cmp =  Product::compareByPrice;
    cmp = cmp.thenComparing(Product::compareByName);
    Arrays.sort(products, cmp);
    
    for (Product product : products) {
      System.out.println(product);
    }


  }
}
