

// class Solution{
//     public ListNode reverseList(ListNode head){
//         // if(head == null || head.next == null){
//         //     return head;
//         // }
//         // ListNode newHead = reverseList(head.next);
//         // head.next.next = head;
//         // head.next = null;
//         // return newHead;

//         ListNode prev = null;
//         ListNode cur = head;
//         while(cur != null){
//             ListNode next = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = next;
//         }
//         return prev;
//     }
// }

// class Solution{
//     public ListNode reverseList(ListNode head){
//         if(head == null || head.next == null){
//             return head;
//         }
//         ListNode next = reverseList(head.next);
//         head.next.next = head;
//         head.next = null;
//         return next;
//     }
// }

class Solution{
    public ListNode reverseList(ListNode head){
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




