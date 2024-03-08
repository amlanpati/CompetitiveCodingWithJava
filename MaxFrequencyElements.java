// Count Elements With Maximum Frequency
// You are given an array nums consisting of positive integers.

// Return the total frequencies of elements in nums such that those elements all have the maximum frequency.

// The frequency of an element is the number of occurrences of that element in the array.

 

// Example 1:

// Input: nums = [1,2,2,3,1,4]
// Output: 4
// Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
// So the number of elements in the array with maximum frequency is 4.
// Example 2:

// Input: nums = [1,2,3,4,5]
// Output: 5
// Explanation: All elements of the array have a frequency of 1 which is the maximum.
// So the number of elements in the array with maximum frequency is 5.
 

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100

import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        int maxFreq = Integer.MIN_VALUE;
        for (int freq : mp.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        for (int freq : mp.values()) {
            if (freq == maxFreq)
                count += maxFreq;
        }
        return count;
    }
}

class MaxFrequencyElements {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Solution obj = new Solution();
        System.out.print("Enter the number of test cases: ");
        int numTestCases = scn.nextInt();

        for (int i = 0; i < numTestCases; i++) {
            System.out.print("Enter the size of the array for test case " + (i + 1) + ": ");
            int n = scn.nextInt();

            int[] nums = new int[n];
            System.out.println("Enter the elements of the array for test case " + (i + 1) + ": ");
            for (int j = 0; j < n; j++) {
                nums[j] = scn.nextInt();
            }

            int count = obj.maxFrequencyElements(nums);
            System.out.println("Array: " + java.util.Arrays.toString(nums) + ", Maximum Frequency Elements: " + count);
        }
    }
}