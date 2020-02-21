import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L20_stack {
    public static boolean isValid(String s) {
        if (s.length() == 0 || s == null) return true;
        if (s.length()%2 == 1) return false;
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if(stack.isEmpty() || stack.pop() != map.get(c)) return false;
            }else stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "){";
        System.out.println(isValid(s));
    }
}
