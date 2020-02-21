import java.util.LinkedList;
import java.util.Queue;

class MyStack3 {
    Queue<Integer> q = new LinkedList();
    int top;
    /** Initialize your data structure here. */
    public MyStack3() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.top = x;
        q.add(x);
        while (q.peek() != x) q.add(q.remove());
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int pvalue = q.remove();
        if (!q.isEmpty()) this.top = q.peek();
        return pvalue;
    }

    /** Get the top element. */
    public int top() {
        return this.top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
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