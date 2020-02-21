import java.util.ArrayList;
import java.util.List;

public class L155 {
    static class MinStack {
        List<Integer> list = new ArrayList<>();
        public MinStack() {
        }

        public void push(int x) {
            list.add(0,x);
        }

        public void pop() {
            list.remove(0);
        }

        public int top() {
            return list.get(0);
        }

        public int getMin() {
            int min = list.get(0);
            for (int i=1; i<list.size(); i++)
                min = Math.min(min, list.get(i));
            return min;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
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
