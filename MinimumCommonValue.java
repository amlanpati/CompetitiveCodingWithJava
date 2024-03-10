// Minimum Common Value
// Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.

// Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.

 

// Example 1:

// Input: nums1 = [1,2,3], nums2 = [2,4]
// Output: 2
// Explanation: The smallest element common to both arrays is 2, so we return 2.
// Example 2:

// Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
// Output: 2
// Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
 

// Constraints:

// 1 <= nums1.length, nums2.length <= 105
// 1 <= nums1[i], nums2[j] <= 109
// Both nums1 and nums2 are sorted in non-decreasing order.

import java.util.Scanner;

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int common = -1;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                common = nums1[i];
                break;
            }
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            else {
                i++;
            }
        }
        return common;
    }
}

class MinimumCommonValue {
    public static void main(String[] args) {
        Solution obj = new Solution();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements in array 1:");
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        for (int j = 0; j < n; j++) {
            System.out.println("Enter the elements of array 1:");
            arr1[j] = scn.nextInt();
        }
        System.out.println("Enter the number of elements in array 2:");
        int p = scn.nextInt();
        int[] arr2 = new int[p];
        for (int k = 0; k < p; k++) {
            System.out.println("Enter the elements of array 2:");
            arr2[k] = scn.nextInt();
        }
        System.out.println("Array 1: " + java.util.Arrays.toString(arr1) + "and Array 2: " + java.util.Arrays.toString(arr2));
        System.out.println("Minimum common value is " + obj.getCommon(arr1, arr2));
        scn.close();
    }
}