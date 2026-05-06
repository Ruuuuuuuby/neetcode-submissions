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


class Solution{
    public Node copyRandomList(Node head){
        if (head == null){
            return null;
        }
        //首先用Node，并不是ListNode
        Node cur = head;//不需要完全新建cur，新建cur指向head即可
        HashMap<Node, Node> hs = new HashMap<>();
        while(cur != null){
            hs.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;//一定要重新定义cur，
        while(cur != null){
            hs.get(cur).next = hs.get(cur.next);
            hs.get(cur).random = hs.get(cur.random);
            cur = cur.next;
        }
        return hs.get(head);
    }

}
