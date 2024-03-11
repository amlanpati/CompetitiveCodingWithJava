// Intersection of Two Arrays
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.
 

// Constraints:

// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }
        Set<Integer> intersection = new HashSet<>();
        for (int num: nums2) {
            if (set1.contains(num)) {
                if (!intersection.contains(num)) {
                    intersection.add(num);
                }
            }
        }
        return intersection.stream().mapToInt(i -> i).toArray();
    }
}

class Intersection {
    public static void main(String[] args) {
        Solution obj = new Solution();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements in Array 1:");
        int m = scn.nextInt();
        int[] arr1 = new int[m];
        System.out.println("Enter the elements of Array 1:");
        for (int i = 0; i < m; i++) {
            arr1[i] = scn.nextInt();
        }
        System.out.println("Enter the number of elements in Array 2:");
        int n = scn.nextInt();
        int[] arr2 = new int[n];
        System.out.println("Enter the elements of Array 2:");
        for (int i = 0; i < n; i++) {
            arr2[i] = scn.nextInt();
        }
        System.out.println("The intersection list is " + Arrays.toString(obj.intersection(arr1, arr2)));
        scn.close();
    }
}