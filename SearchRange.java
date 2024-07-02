// Find First and Last Position of Element in Sorted Array

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = binarySearch(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = binarySearch(nums, target, false);
        }
        return ans;
    }
    public int binarySearch(int[] nums, int target, boolean isFirstIndexSearch) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                ans = mid;
                if (isFirstIndexSearch) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}

public class SearchRange {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Number of elements in the sorted array: ");
        int n = scn.nextInt();
        System.out.println("Enter elements of the sorted array: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
        System.out.println("Enter target element: ");
        int target = scn.nextInt();
        Solution obj = new Solution();
        System.out.println("Range: " + Arrays.toString(obj.searchRange(nums, target)));
        scn.close();
    }
}