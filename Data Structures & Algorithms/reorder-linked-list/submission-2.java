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

//快慢指针可以检查环，也可以找中点，奇数时slow为median，偶数时slow为右半部分第一个值

//总数为奇 fast走到末尾时slow在正中间，为偶时，fast走到倒数第二个时，slow在左半部分最后一个
//跳出循环时，slow要么在正中间要么在右半部分第一个
// class Solution{
//     public ListNode reorderList(ListNode head){
//         if(head == null || head.next == null){
//             return null;
//         }
//         ListNode slow = head;
//         ListNode fast = head;
        
//         while(fast != null && fast.next != null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         ListNode cur = slow.next;
//         ListNode prev = null;

//         while(cur != null){
//             ListNode next = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = next;
//         }

//         slow.next = null;

//         ListNode first = head;
//         ListNode second = prev;

//         while(second != null){
//             ListNode temp1 = first.next;
//             ListNode temp2 = second.next;
//             first.next = second;
//             second.next = temp1;
//             first = temp1;
//             second = temp2;
//         }
//         return head;
//     }
// }


class Solution{
    public ListNode reorderList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode list2 = prev;
        slow.next = null;
        ListNode list1 = head;
        
        while(list2 != null){
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;
            list1.next = list2;
            list2.next = next1;
            list1 = next1;
            list2 = next2;
        }
        return head;

    }
}
