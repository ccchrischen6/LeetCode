import java.util.Stack;

class MyQueue {
    Stack<Integer> sm = new Stack<>();
    Stack<Integer> ss = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!sm.isEmpty()) ss.push(sm.pop());
        sm.push(x);
        while (!ss.isEmpty()) sm.push(ss.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return sm.pop();
    }

    /** Get the front element. */
    public int peek() {
        return sm.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return sm.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.peek());


    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */