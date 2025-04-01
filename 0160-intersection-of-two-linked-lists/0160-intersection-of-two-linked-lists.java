/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp=headA;
        ListNode temp1=headB;
        ListNode temp2=headA;
        ListNode temp3=headB;
        int count=0;
        int count1=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        while(temp1!=null){
            count1++;
            temp1=temp1.next;
        }
        int i=0;
        if(count1>count){
        while(i<count1-count){
            temp3=temp3.next;
            i++;
            }
        }
        else{
            while(i<count-count1){
                temp2=temp2.next;
                i++;
            }

        }
        
            while(temp2!=null && temp3!=null){
                if(temp2 == temp3){
                    return temp2;
                    }
                    temp2=temp2.next;
                    temp3=temp3.next;
        }
        return null;
        
        
        
        
    }
}