import java.util.Stack;

public class L155_optml {
    static class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int x) {
            if (minStack.isEmpty() || x < minStack.peek())
                minStack.push(x);
            else minStack.push(minStack.peek());
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack mk = new MinStack();
        mk.push(0);
        mk.push(-1);
        mk.push(0);
        mk.push(0);
        System.out.println(mk.getMin());
        mk.pop();
        System.out.println(mk.top());
        System.out.println(mk.getMin());
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
