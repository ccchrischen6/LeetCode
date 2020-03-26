import java.util.LinkedList;
import java.util.Queue;

public class L61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode root = head;
        int len = 0;
        while(root != null){
            root = root.next;
            len++;
        }
        root = head;
        int l = len - k%len, count=1;
        ListNode rs = new ListNode(0);
        while(root != null && root.next != null){
            System.out.println(l + " " + count);
            if (count++ == l){
                System.out.println("yes");
                rs = root.next;
                root.next = null;
                root = rs;
            }
            if (root.next == null) break;
            root = root.next;
        }

        return rs;
    }


}
