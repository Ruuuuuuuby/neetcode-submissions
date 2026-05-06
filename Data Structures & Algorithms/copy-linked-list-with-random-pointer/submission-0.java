/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        while(cur != null){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        Node newHead = head.next;
        Node oldNode = head;
        Node newNode = newHead;

        while(oldNode != null){
            oldNode.next = oldNode.next.next;
            newNode.next = (newNode.next != null) ? newNode.next.next : null;
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return newHead;
    }
}
