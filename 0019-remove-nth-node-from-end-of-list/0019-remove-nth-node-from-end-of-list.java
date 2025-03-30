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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        
        // Count the total number of nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        
        // If we need to remove the first node
        if (count == n) {
            return head.next;
        }
        
        ListNode temp1 = head;
        int i = count - n; // Stop one node before the target
        int j = 1;
        
        // Move temp1 to (i-1)th node
        while (j < i) {
            temp1 = temp1.next;
            j++;
        }
        
        // Remove the nth node
        temp1.next = temp1.next.next;
        
        return head;
    }
}
