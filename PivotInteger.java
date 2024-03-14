// Find the Pivot Integer
// Given a positive integer n, find the pivot integer x such that:

// The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
// Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.

 

// Example 1:

// Input: n = 8
// Output: 6
// Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
// Example 2:

// Input: n = 1
// Output: 1
// Explanation: 1 is the pivot integer since: 1 = 1.
// Example 3:

// Input: n = 4
// Output: -1
// Explanation: It can be proved that no such integer exist.
 

// Constraints:

// 1 <= n <= 1000

import java.util.Scanner;

class Solution {
    public int pivotInteger(int n) {
      int sum = n * (n + 1) / 2;
        double potentialRoot = Math.sqrt(sum);
        if (potentialRoot % 1 != 0) {
            return -1; 
        }
        return (int) potentialRoot;
    }
}
class PivotInteger {
    public static void main(String[] args) {
        Solution obj = new Solution();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number to find it's pivot integer: ");
        int n = scn.nextInt();
        System.out.println("The pivot integer for " + n + " is " + obj.pivotInteger(n) + ".");
        scn.close();
    }
}