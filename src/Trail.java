import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;

public class Trail {
    public static int calculate(String s) {
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = num * 10 + c - '0';
            if (i == s.length() - 1 || !Character.isDigit(c) && c!=' ') {
                switch(lastSign) {
                    case '+':
                        sum+=tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        sum+=tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                }
                lastSign = c;
                num=0;
            }
        }
        sum+=tempSum;
        return sum;
    }




    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

//        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.add("a");
//        linkedList.addFirst("b");
//
//        System.out.println(linkedList);
//        linkedList.add(2,"C");
//        System.out.println(linkedList);
//        linkedList.offer("L");
//        System.out.println(linkedList);
//        linkedList.push("A");
//        System.out.println(linkedList);
//        System.out.println(linkedList.get(0));
//
//        Stack<Integer> stack = new Stack<>();
//        List<Integer> queue = new ArrayList<Integer>();
//        Queue<Integer> q = new LinkedList<>();
//
//        Deque<Integer> dq = new LinkedList<>();
//        queue.add(3); //offer
//        queue.remove(0); //poll
//
//        Math.pow(1,2);

        System.out.println(calculate("1+2*3"));

    }


}
