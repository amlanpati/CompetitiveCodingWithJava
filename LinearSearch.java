import java.util.Scanner;

class Solution {
    public int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Number of elements in the array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter the target: ");
        int target = scn.nextInt();
        Solution obj = new Solution();
        System.out.println("The target element is at index " + obj.linearSearch(arr, target) + ".");
        scn.close();
    }
}
