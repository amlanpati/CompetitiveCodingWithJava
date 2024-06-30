import java.util.Scanner;

class Solution {
    public int ceilingOfANumber(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (val > nums[nums.length -1]) {
                return -1;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] == val) {
                return mid;
            }
            else if (nums[mid] < val) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return nums[start];
    }
}

public class CeilingOfANumber {
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
        System.out.println("The ceiling of target is " + obj.ceilingOfANumber(arr, target) + ".");
        scn.close();
    }
}