package com.gs.number.bar.snow.problem;

import java.util.Arrays;

/**
 * 
 * @author Gopal Selvaraj
 *  Given a heights[i] representing the height of the terrain at that index. The width at each index is 1. 
    After V units of snow fall at index K, how much snow is at each index? snow first drops at index K and rests on top of the highest terrain or snow at that index. 
    Then, it flows according to the following rules:
     If the one unit snow would eventually fall by moving left, then move left.
     Otherwise, if the droplet would eventually fall by moving right, then move right.
     Otherwise, rise at it's current position.
     
                     
            #     #  
      #     #   # #  
      # # # # # # #  
      2 1 1 2 1 2 2
  idx  0 1 2 3 4 5 6
  
  when 1st drop on index 3
                     
            #     #  
      #   $ #   # #  
      # # # # # # #  
      2 1 1 2 1 2 2
  idx 0 1 2 3 4 5 6  
  
  
    when 2nd drop on index 3
                     
            #     #  
      # $ $ #   # #  
      # # # # # # #  
      2 1 1 2 1 2 2
  idx 0 1 2 3 4 5 6 
  
  
      when 3rd drop on index 3
                    
            #     #  
      # $ $ # $ # # 
      # # # # # # #  
      2 1 1 2 1 2 2
  idx 0 1 2 3 4 5 6 
  
  
        when 4th drop on index 3
                   
            #   $ # 
      # $ $ # $ # #  
      # # # # # # #  
      2 1 1 2 1 2 2
  idx 0 1 2 3 4 5 6 
  
  
          when 5th drop on index 3
                   
            # $ $ # 
      # $ $ # $ # #  
      # # # # # # #  
      2 1 1 2 1 2 2
  idx 0 1 2 3 4 5 6 
 
    when 6th drop on index 3
            $       
            # $ $ # 
      # $ $ # $ # #  
      # # # # # # #  
      2 1 1 2 1 2 2
  idx 0 1 2 3 4 5 6 
 */

public class LandscapeWithSnow {

  public int[] afterSnow(final int[] heights, int totalUnitOfSnow, final int positionToSnow) {
  
    int[] capacityHolder = findCapacityHolder(heights, positionToSnow);

    totalUnitOfSnow = fillAndSendRemaining(heights, totalUnitOfSnow, positionToSnow - 1, capacityHolder, -1); // filling left side as per rule # 1
    totalUnitOfSnow = fillAndSendRemaining(heights, totalUnitOfSnow, positionToSnow + 1, capacityHolder, 1); // filling right side as per rule # 2
    heights[positionToSnow] += totalUnitOfSnow; // filling remaining on top of current
    
    return heights;
  }

  private int[] findCapacityHolder(int[] heights, int positionToSnow) {
    int[] capacity = new int[heights.length];
    int tallest = Integer.MIN_VALUE;
    
    for (int index = 0; index < positionToSnow; index++) {
      tallest = Math.max(tallest, heights[index]);
      capacity[index] = (tallest - heights[index]);
    }
   
    tallest = Integer.MIN_VALUE;
    for ( int index = heights.length - 1; index > positionToSnow ; index--) {
      tallest = Math.max(tallest, heights[index]);
      capacity[index] = (tallest - heights[index]);
    }
    
    return capacity;
  }
  

  private int fillAndSendRemaining(int[] heights, int totalUnitOfSnow, int index, int[] capacityHolder, int multiplier ) {
    
       while ( totalUnitOfSnow > 0 && !isIndexOutOfBound(heights, index) ) {
         int currentCapacity = capacityHolder[index];
         if (currentCapacity >= totalUnitOfSnow) {
           heights[index] += totalUnitOfSnow;
           totalUnitOfSnow = 0;
         } else {
           heights[index] += currentCapacity;
           totalUnitOfSnow -= currentCapacity;
         }
         
         index = index + ( 1 * multiplier);
       }
       
    return totalUnitOfSnow;
  }

  
  private boolean isIndexOutOfBound(int[] heights, int index) {
    return index < 0 || index >= heights.length;
  }
  
  public static void main(String[] args) {
    int[] heights = { 2,1,1,2,1,2,3 }; 
    System.err.println(Arrays.toString(new LandscapeWithSnow().afterSnow(heights, 10, 3)));
  }
  
}
