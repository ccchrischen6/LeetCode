import java.util.HashMap;
import java.util.Map;

public class L242 {
    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] sc = new int[26];
        for (int i=0; i<s.length(); i++){
            sc[s.charAt(i)-'a']++;
            sc[t.charAt(i)-'a']--;
        }

        for (int j: sc){
            if (j!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
