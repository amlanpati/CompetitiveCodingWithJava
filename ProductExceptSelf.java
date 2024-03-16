// Product of Array Except Self
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]
 

// Constraints:

// 2 <= nums.length <= 105
// -30 <= nums[i] <= 30
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

// Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        int product = 1;
        int zeros = 0;
        for (int num: nums) {
            if (num == 0) {
                zeros++;
                continue;
            }
            product *= num;
        }
        if (zeros == 1) {
            for (int i = 0; i < n; i++) {
                ans[i] = nums[i] == 0 ? product : 0;
            }
        } else if (zeros == 0) {
            for (int i = 0; i < n; i++) {
                ans[i] = product / nums[i];
            }
        }
        return ans;
    }
}
public class ProductExceptSelf {
    public static void main(String[] args) {
        Solution obj = new Solution();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements in input array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            arr[i] = scn.nextInt();
        }
        System.out.println("The output string is: " + Arrays.toString(obj.productExceptSelf(arr)));
        scn.close();
    }
}