import java.util.HashMap;
import java.util.Map;

/**
 * time: O(n)
 * space: O(n)
 */
public class L138_CopyList_withRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node,Node> map = new HashMap();

        Node pre = head;
        Node cur = head.next;
        map.put(pre, new Node(pre.val));
        while(cur != null){
            map.put(cur, new Node(cur.val));
            map.get(pre).next = map.get(cur);
            pre = cur;
            cur = cur.next;
        }

        pre = head;
        while(pre != null){
            map.get(pre).random = map.get(pre.random);
            pre = pre.next;
        }
        return map.get(head);
    }

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
}
