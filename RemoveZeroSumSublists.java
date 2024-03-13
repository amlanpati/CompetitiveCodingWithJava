// Remove Zero Sum Consecutive Nodes from Linked List
// Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

// After doing so, return the head of the final linked list.  You may return any such answer.

 

// (Note that in the examples below, all sequences are serializations of ListNode objects.)

// Example 1:

// Input: head = [1,2,-3,3,1]
// Output: [3,1]
// Note: The answer [1,2,1] would also be accepted.
// Example 2:

// Input: head = [1,2,3,-3,4]
// Output: [1,2,4]
// Example 3:

// Input: head = [1,2,3,-3,-2]
// Output: [1]
 

// Constraints:

// The given linked list will contain between 1 and 1000 nodes.
// Each node in the linked list has -1000 <= node.val <= 1000.

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int prefixSum = 0;

        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();

        for (ListNode current = dummy; current != null; current = current.next) {
            prefixSum += current.val;
            if (prefixSumToNode.containsKey(prefixSum)) {
                ListNode prev = prefixSumToNode.get(prefixSum);
                ListNode toRemove = prev.next;
                int p = prefixSum + (toRemove != null ? toRemove.val : 0);
                while (p != prefixSum) {
                    prefixSumToNode.remove(p);
                    toRemove = toRemove.next;
                    p += (toRemove != null ? toRemove.val : 0);
                }
                prev.next = current.next;
            }
            else {
                prefixSumToNode.put(prefixSum, current);
            }
        }
        return dummy.next;
    }
}
public class RemoveZeroSumSublists {

    public static ListNode createLinkedList(Scanner scanner) {
        System.out.print("Enter the number of nodes in the linked list: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of nodes. Please enter a positive integer.");
            return null;
        }

        ListNode head = null;
        ListNode current = null;
        System.out.print("Enter the value for node 1: ");
        int value = scanner.nextInt();
        head = new ListNode(value);
        current = head;

        for (int i = 2; i <= n; i++) {
            System.out.print("Enter the value for node " + i + ": ");
            value = scanner.nextInt();
            current.next = new ListNode(value);
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        System.out.print("Linked list: ");
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListNode head = createLinkedList(scanner);
        if (head == null) {
            System.exit(1);  // Exit program if linked list creation fails
        }

        Solution solution = new Solution();
        ListNode newHead = solution.removeZeroSumSublists(head);

        System.out.println("Linked list after removing zero-sum sublists:");
        printLinkedList(newHead);

        scanner.close();
    }
}
