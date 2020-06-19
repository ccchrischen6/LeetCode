import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L146_LRU_Cache {
    public class Node{
        Integer key;
        Integer val;
        Node prev;
        Node next;

        public Node(Integer key, Integer val){
            this.key = key;
            this.val = val;
        }

        public Node(){}
    }

    public class DoubleLinkedList{
        Node dummy = new Node(null, null);
        Node tail = dummy;

        private void add(Node n){
            tail.next = n;
            n.prev = tail;
            tail = n;
        }

        private void remove(Node n){
            n.prev.next = n.next;
            if(n.next == null) {
                tail = n.prev;
            }
            else{
                n.next.prev = n.prev;
            }
            n.prev = null;
            n.next = null;
        }

        private void moveToTail(Node n){
            remove(n);
            add(n);
        }

        private Node getHead(){
            return dummy.next;
        }
    }


    private DoubleLinkedList list = new DoubleLinkedList();
    private Map<Integer, Node> map = new HashMap();
    private int capacity;
    public L146_LRU_Cache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n = map.get(key);
        list.moveToTail(n);
        return n.val;
    }

    public void put(int key, int val) {
        if(!map.containsKey(key)){
            if(capacity == map.size()){
                Node head = list.getHead();
                list.remove(head);
                map.remove(head.key);
            }
            Node n = new Node(key, val);
            list.add(n);
            map.put(key, n);
        }

        else{
            Node n = map.get(key);
            n.val = val;
            list.moveToTail(n);
        }
    }

    public static void main(String[] args) {
        L146_LRU_Cache test = new L146_LRU_Cache(1);
        test.put(2,1);
        System.out.println(test.get(2));
        test.put(3,2);
        System.out.println(test.get(2));
        System.out.println(test.get(3));

    }
}



/*
["LRUCache","put",  "put",  "get",  "put",  "get",  "put",  "get",  "get",  "get"]
[[2],       [1,1],  [2,2],  [1],    [3,3],  [2],    [4,4],  [1],    [3],    [4]]


[null,      null,   null,   1,      null,   2,      null,   -1,     3,      4]
[null,      null,   null,   1,      null,   -1,     null,   -1,     3,      4]


*/

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

