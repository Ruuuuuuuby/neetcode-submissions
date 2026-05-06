/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
.*/

class Solution{
    public ListNode reverseKGroup (ListNode head, int k){
        if(head == null || k == 1){
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode end = dummy;
        while(true){
            for(int i = 0; i < k && end != null; i++){
            end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode next = end.next;
            ListNode start = prev.next;
            end.next = null;//断开

            prev.next = reverse(start);//

            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;      
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
