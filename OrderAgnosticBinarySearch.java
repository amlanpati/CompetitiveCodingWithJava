import java.util.Scanner;

class Solution {
    public int orderAgnosticBinarySearch(int[] array, int val) {
        int left = 0;
        int right = array.length -1;

        boolean isAsc = array[left] < array[right];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == val) {
                return mid;
            }
            else {
                if (isAsc) {
                    if (array[mid] < val) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
                else {
                    if (array[mid] < val) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Number of elements in the sorted array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements in the sorted array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter target element: ");
        int target = scn.nextInt();
        Solution obj = new Solution();
        System.out.println("The target element is at index " + obj.orderAgnosticBinarySearch(arr, target) + ".");
        scn.close();
    }
}
