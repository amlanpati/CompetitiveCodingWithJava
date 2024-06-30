// Find Smallest Letter Greater Than Target
// You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

// Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

 

// Example 1:

// Input: letters = ["c","f","j"], target = "a"
// Output: "c"
// Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
// Example 2:

// Input: letters = ["c","f","j"], target = "c"
// Output: "f"
// Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
// Example 3:

// Input: letters = ["x","x","y","y"], target = "z"
// Output: "x"
// Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
 

// Constraints:

// 2 <= letters.length <= 104
// letters[i] is a lowercase English letter.
// letters is sorted in non-decreasing order.
// letters contains at least two different characters.
// target is a lowercase English letter.

import java.util.Scanner;

class Solution {
    public char nextGreatestLetter(char[] letters, int val) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > val) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}

public class NextGreatestLetter {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Number of elements in the character array: ");
        int n = scn.nextInt();
        char[] arr = new char[n];
        System.out.println("Enter elements of the character array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.next().charAt(0);
        }
        System.out.println("Enter target element: ");
        char target = scn.next().charAt(0);
        Solution obj = new Solution();
        System.out.println("The next greatest letter is " + obj.nextGreatestLetter(arr, target) + ".");
        scn.close();
    }
}