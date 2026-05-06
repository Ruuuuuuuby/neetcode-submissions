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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        while(head != null){
            ListNode groupEnd = head;
            ListNode groupStart = head;
            for(int i = 1; i < k && groupEnd != null; i++){
                groupEnd = groupEnd.next;
            }
            if(groupEnd == null){
                break;
            }
            ListNode nextGroupStart = groupEnd.next;

            groupEnd.next = null;
            ListNode reverseGroup = reverse(groupStart);

            prevGroupEnd.next = reverseGroup;
            groupStart.next = nextGroupStart;

            prevGroupEnd = groupStart;
            head = nextGroupStart;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
        
    }
}
