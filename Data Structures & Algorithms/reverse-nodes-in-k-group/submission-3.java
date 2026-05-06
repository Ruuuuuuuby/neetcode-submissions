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
class Solution{
    public ListNode reverseKGroup(ListNode head, int k){
        if(head == null || k == 1){
            return head;
        }
        ListNode cur = head;
        int count = 0;
        while(cur != null && count < k){
            cur = cur.next;
            count++;
        }
        if(count < k){
            return head;
        }//总数小于k
        ListNode reversed = reverseKGroup(cur, k);//cur此时等于第二部分的第一个值
        while(count-- > 0){//先看count是否>0，然后--
            ListNode next = head.next;
            head.next = reversed;
            reversed = head;
            head = next;
            //head，next，reversed变为next，head，reversed
        }
        return reversed;//head此时为null，reversed是真正的head；
    }
}
