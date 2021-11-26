package com.gs.number.max.heights;

import java.util.Arrays;

/**
 
5    |
4    |     |
3    |     |           |
2    |     |           |  |  |
1    |     |  |     |  |  |  |  |
  0  1  2  3  4  5  6  7  8  9  10    ~ ~ ~(sea level)
                                      ~ ~ ~
  N  Y  N  Y  N  N  N  Y  N  Y  Y
  
*/

public class IdentifySeaViewApts {

  private boolean[] identify(int[] floors) {
    boolean[] result = new boolean[floors.length];
    int tallestFloorBeforeCurrent = Integer.MIN_VALUE;
    for ( int i = floors.length - 1; i >=0; i--) {
      int currentFloorHeight = floors[i];
      if ( currentFloorHeight  > tallestFloorBeforeCurrent) {
        result[i] = true;
        tallestFloorBeforeCurrent = currentFloorHeight;
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    int[] floors = { 0, 5, 0, 4, 1, 0, 1, 3, 2, 2, 1 };
    System.out.println(Arrays.toString(new IdentifySeaViewApts().identify(floors)));
  }

  
  
}
