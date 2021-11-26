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
  idx 0 1 2 3 4 5 6
  
  when 1st drop on index 3
                     
            #     #  
      #   $ #   # #  
      # # # # # # #  
  idx 0 1 2 3 4 5 6  
  
  
    when 2nd drop on index 3
                     
          $ #     #  
      #   $ #   # #  
      # # # # # # #  
  idx 0 1 2 3 4 5 6 
  
  
      when 3rd drop on index 3
                    
          $ #     #  
      # $ $ #   # # 
      # # # # # # #  
  idx 0 1 2 3 4 5 6 
  
  
        when 4th drop on index 3
                   
        $ $ #     # 
      # $ $ #   # #  
      # # # # # # #  
  idx 0 1 2 3 4 5 6 
  
  
          when 5th drop on index 3
                   
        $ $ #     # 
      # $ $ # $ # #  
      # # # # # # #  
  idx 0 1 2 3 4 5 6 
 
    when 6th drop on index 3
    
        $ $ # $   # 
      # $ $ # $ # #  
      # # # # # # #  
  idx 0 1 2 3 4 5 6 
  
      when 7th drop on index 3
    
        $ $ # $ $ # 
      # $ $ # $ # #  
      # # # # # # #  
  idx 0 1 2 3 4 5 6 
  
      when 8th drop on index 3
            $
        $ $ # $ $ # 
      # $ $ # $ # #  
      # # # # # # #  
  idx 0 1 2 3 4 5 6 
  
 */

public class LandscapeWithSnow {

  public int[] afterSnow(final int[] heights, int totalUnitOfSnow, final int positionToSnow) {
  
    int[] capacityHolder = findCapacityHolder(heights, positionToSnow);
    System.out.println("capacityHolder - " + Arrays.toString(capacityHolder));
    // fill left side ,, goes  postion -> left direction
    for ( int index = positionToSnow - 1; index >=0 && totalUnitOfSnow > 0; index--) {
      int fillAtIndex = Math.min(totalUnitOfSnow, capacityHolder[index]);
      heights[index] += fillAtIndex;
      totalUnitOfSnow -= fillAtIndex;
    }
    // fill right side,, goes position -> right direction
    for ( int index = positionToSnow + 1; index < heights.length && totalUnitOfSnow > 0; index++ ) {
      int fillAtIndex = Math.min(totalUnitOfSnow, capacityHolder[index]);
      heights[index] += fillAtIndex;
      totalUnitOfSnow -= fillAtIndex;
    }
    // fill current position
    heights[positionToSnow] += totalUnitOfSnow; // filling remaining on top of current
    
    return heights;
  }

  private int[] findCapacityHolder(int[] heights, int positionToSnow) {
    int[] capacity = new int[heights.length];
    final int positionToSnowHeight = heights[positionToSnow];
    // find capacity by going toward left side from pos
    for ( int i = positionToSnow - 1; i >=0 && heights[i] < positionToSnowHeight; i--) {
      int maxAmountToSnow = positionToSnowHeight - heights[i];
      capacity[i] = maxAmountToSnow;
    }
    // find capacity by going toward right side from pos
    for ( int i = positionToSnow + 1; i <heights.length && heights[i] < positionToSnowHeight; i++) {
      int maxAmountToSnow = positionToSnowHeight - heights[i];
      capacity[i] = maxAmountToSnow;
    }
    return capacity;
  }
  
}
