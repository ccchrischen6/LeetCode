import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> qm = new LinkedList();
    Queue<Integer> qs = new LinkedList();
    int top;
    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
         top = x;
         qm.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (qm.size() != 1) qs.add(qm.remove());
        int pvalue = qm.remove();
        while (!qs.isEmpty()) this.push(qs.remove());
        return pvalue;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return qm.isEmpty();
    }
}

