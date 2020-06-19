import java.util.HashMap;
import java.util.Map;

public class DoubleLinkedList {
    Node head;
    Node tail;
    int length = 0;

    public void insertAfter(Node prevNode, int val){
        if(prevNode == null) throw new NullPointerException("prevNode is null");
        if(prevNode == tail) {
            append(val);
            return;
        }
        Node node = new Node(val);
        node.next = prevNode.next;
        node.next.prev = node;
        prevNode.next = node;
        node.prev = prevNode;
        length++;

    }

    public void append(int val){
        Node node = new Node(val);
        if(head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
    }

    public void addFirst(int val){
        if(head == null) append(val);
        else{
            Node node = new Node(val);
            node.next = head;
            head.prev = node;
            head = node;
            length++;
        }


    }

    public void remove(Node node){
        if(node == tail) remove();
        else if(node == head) removeHead();
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            length--;
        }
    }

    public void removeHead(){
        if(length == 1){
            head = null;
            tail = null;
        }else{
            Node newHead = head.next;
            head.next = null;
            newHead.prev = null;
            head = newHead;
        }
        length--;
    }

    public void remove(){
        if(length == 1){
            head = null;
            tail = null;
        }else{
            Node newTail = tail.prev;
            tail.prev = null;
            tail = newTail;
            tail.next = null;
        }
        length--;
    }

    public int get(Node node){
        return node.val;
    }

    public String toString(){
        Node dummy = new Node(0);
        dummy.next = head;
        StringBuilder sb = new StringBuilder();
        while(dummy.next != null){
            Node cur = dummy.next;
            sb.append(cur.val + "->");
            dummy = dummy.next;
        }
        return sb.substring(0, sb.length()-2).toString();
    }

    public static class Node{
        Node prev;
        Node next;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(1);
        System.out.println(list.toString());
        list.append(2);
        System.out.println(list.toString());
        list.addFirst(0);
        System.out.println(list.toString());
        list.removeHead();
        System.out.println(list.toString());
        list.remove();
        System.out.println(list.toString());
        list.remove();


    }
}
