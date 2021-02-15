# Missing Numbers
This is to find missing number(s) in the sorted array.

a) Single missing number 
   there are 3 options to do.
     1. using binary search 
         time : o(log n) - best one 
     2. using calculation 
         lead to integer overflow
     3. using xor
         good approach, but still o(n) time.
 
 b)Multiple missing numbers
      using xor is best option.
