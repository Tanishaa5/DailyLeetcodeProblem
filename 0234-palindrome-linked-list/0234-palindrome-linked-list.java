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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reverse=reverseSecond(slow);

        //compare the reverse list with first half
        ListNode temp=head;
        while(reverse!=null){//kyuki end tak jana hi h
            if(reverse.val!=temp.val){
                return false;

            }
            temp=temp.next;
            reverse=reverse.next;
            

        }
        return true;
        }
         public ListNode reverseSecond(ListNode slow) {
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}