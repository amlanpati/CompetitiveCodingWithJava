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
    Scanner scn = new Scanner(System.in);
    System.out.println("Number of elements in the sorted (ascending) array: ");
    int n = scn.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter elements of the sorted (ascending) array: ");
    for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
    }
    System.out.println("Enter target element: ");
    int target = scn.nextInt();
    Solution obj = new Solution();
    System.out.println("The target element is at index " + obj.infiniteArray(arr, target) + ".");
    scn.close();
   }
}
