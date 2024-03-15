// Binary Subarrays With Sum
// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

// A subarray is a contiguous part of the array.

 

// Example 1:

// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// Example 2:

// Input: nums = [0,0,0,0,0], goal = 0
// Output: 15
 

// Constraints:

// 1 <= nums.length <= 3 * 104
// nums[i] is either 0 or 1.
// 0 <= goal <= nums.length

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefSumFreqMp = new HashMap<>();
        int prefSum = 0;
        prefSumFreqMp.put(0, 1); 
        int subArrayCnt = 0;
        for (var num: nums) {
            prefSum += num;
            if (prefSumFreqMp.containsKey(prefSum - goal)) {
                subArrayCnt += prefSumFreqMp.get(prefSum - goal);
            }
            prefSumFreqMp.put(prefSum, prefSumFreqMp.getOrDefault(prefSum, 0) + 1);
        }
        return subArrayCnt;
    }
}
class NumSubarraysWithSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Solution obj = new Solution();
        System.out.println("Enter the number of elements in the input integer array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1));
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter the goal: ");
        int goal = scn.nextInt();
        System.out.println("The number of subarrays with sum equal to goal is " + obj.numSubarraysWithSum(arr, goal) + ".");
        scn.close();
    }
}