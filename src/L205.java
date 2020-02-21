import java.util.HashMap;
import java.util.Map;

public class L205 {
    public static boolean isIsomorphic(String s, String t) {
        if (s==null && t==null) return true;
        if (s.length() != t.length()) return false;
        if (!sub(s, t) || !sub(t, s)) return false;
        else return true;
    }
    public static boolean sub(String s, String t){
        Map<Character, Character> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i), t.charAt(i));
            if (map.get(s.charAt(i)) != t.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab", "aa"));
    }
}
