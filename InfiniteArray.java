// We do not use .length method assuming Infinite Array.

import java.util.Scanner;

class Solution {
    public int infiniteArray(int [] nums, int target) {
        int start = 0;
        int end = 1;
        int ans = 0;
        while (true) {
            if (nums[0] > target) {
                return -1;
            }
            else if (nums[end] < target) {
                int temp = end + 1;
                end = end + (end - start + 1) * 2;
                start = temp;
            }
            else {
                ans = binarySearch(nums, target, start, end);
                return ans;
            }
        }
    }
    public int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

public class InfiniteArray {
   public static void main(String[] args) {
    int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
    int target = 10;
    Solution obj = new Solution();
    System.out.println("The target element is at index " + obj.infiniteArray(arr, target) + ".");
   }
}
