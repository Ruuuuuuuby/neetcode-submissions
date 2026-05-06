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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;

        while(p != null || q != null || carry != 0){
            int n1 = p != null ? p.val : 0;
            int n2 = q != null ? q.val : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(q != null){
                q = q.next;
            }
            if(p != null){
                p = p.next;
            }

        }
        return dummyHead.next;
        
    }
}
