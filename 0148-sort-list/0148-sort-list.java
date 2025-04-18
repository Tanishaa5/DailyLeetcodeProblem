/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return divideList(head);
    }

    // Merge Sort - Divide the list
    public ListNode divideList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = middle(head);
        ListNode lefthead = head;
        ListNode righthead = mid.next;
        mid.next = null; // Break the list into two halves

        lefthead = divideList(lefthead); // Recursively sort the left half
        righthead = divideList(righthead); // Recursively sort the right half

        return sortAndMerge(lefthead, righthead); // Merge two sorted halves
    }

    // Find the middle of the linked list
    public ListNode middle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted linked lists
    public ListNode sortAndMerge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining nodes
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }
}
