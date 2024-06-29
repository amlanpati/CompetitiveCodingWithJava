import java.util.Scanner;

class Solution {
    public int binarySearch(int[] array, int val) {
        int left = 0;
        int right = array.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == val) {
                return mid;
            }
            else if (array[mid] < val) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Number of elements in the sorted array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the sorted array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter target element: ");
        int target = scn.nextInt();
        Solution obj = new Solution();
        System.out.println("The target element is at index " + obj.binarySearch(arr, target) + ".");
        scn.close();
    }
}