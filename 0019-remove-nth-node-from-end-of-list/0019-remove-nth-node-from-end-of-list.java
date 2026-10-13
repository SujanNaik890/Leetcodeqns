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
        if(head==null  && n==0)return head;
        ListNode temp=head;
        
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }

        if(length==n)return head.next;

        temp=head;
        int size=length-n;

        for(int i=0;i<size-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}