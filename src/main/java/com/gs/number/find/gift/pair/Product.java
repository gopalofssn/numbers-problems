package com.gs.number.find.gift.pair;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

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

  public static class ProductSortingByPriceDesc {

    public static Product[] sort(Product[] products) {
      Comparator<Product> cmp = new Comparator<Product>() {
        public int compare(Product o1, Product o2) {
          if (o1.productPrice == o2.productPrice) {
            return  o1.productName.compareTo(o2.productName);
          }
          return o1.productPrice > o2.productPrice ? 1 : -1;
        }
      };
      
      Comparator<Product> cmp1 = (a, b) -> {
        if (a.productPrice == b.productPrice) {
          return a.productName.compareTo(b.productName);
        }else {
          return a.productPrice > b.productPrice ? 1 : -1;
        }
      };
        
      
      SortedSet<Product> productsSorted = new TreeSet<Product>(cmp1);
      for (Product product : products) {
        productsSorted.add(product);
      }
      return convertAsArray(productsSorted);
    }

    private static Product[] convertAsArray(SortedSet<Product> productsSorted) {
      Product[] result = new Product[productsSorted.size()];
      productsSorted.toArray(result);
      return result;
    }
  }

  public static void main(String[] args) {
    Product[] products = {new Product("Kayak", 209.25f), new Product("xbox", 295.95f),
        new Product("Hat", 15.00f), new Product("Cat", "15.00"), new Product("Teddy Bear", 25.75f),
        new Product("Speaker", 59.99f), new Product("Necklace", 129.95f),
        new Product("Chair", 145.99f)};
    products =  ProductSortingByPriceDesc.sort(products);
    
    for (Product product : products) {
      System.out.println(product);
    }

    System.out.println("app".compareTo("ball"));


  }
}
