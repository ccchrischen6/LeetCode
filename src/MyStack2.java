import java.util.LinkedList;
import java.util.Queue;

class MyStack2 {
    Queue<Integer> qm = new LinkedList();
    Queue<Integer> qs = new LinkedList();
    int top;
    /** Initialize your data structure here. */
    public MyStack2() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        while (!qm.isEmpty()) qs.add(qm.poll());
        qm.offer(x);
        while (!qs.isEmpty()) qm.add(qs.poll());
        top = x;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int pvalue = qm.poll();
        if (!qm.isEmpty()) this.top = qm.element();
        return pvalue;
    }

    /** Get the top element. */
    public int top() {
        return this.top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return qm.isEmpty();
    }

    public static void main(String[] args) {
        MyStack2 ms = new MyStack2();
        ms.push(1);
        System.out.println(ms.pop());
//        System.out.println(ms.empty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */