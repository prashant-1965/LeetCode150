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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2==null) return l1;
        if(l1==null) return l2;
        ListNode temp,head = null,prev = null;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                temp = l2.next;
                l2.next = l1;
                if(head==null){
                    head = l2;
                }else{
                    prev.next = l2;
                }
                prev = l2;
                l2 = temp;
            }else{
                if(head==null)head = l1;
                prev = l1;
                l1 = l1.next;
            }
        }
        if(l1==null) prev.next = l2;
        return head;
    }
}