import java.util.Arrays;

public class L14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        return smallScale(strs, 0 , strs.length - 1);
    }

    public static String smallScale(String[] strs, int l, int r){
       if (l==r) return strs[l];
       else {
           int mid = (l+r)/2;
           String left = smallScale(strs, l, mid);
           String right = smallScale(strs, mid+1, r);
           return common(left, right);
       }
    }

    public static String common(String a, String b){
        int al = a.length();
        int bl = b.length();
        if (al*bl == 0) return "";
        for (int i=1; i<=al && i<=bl; i++){
            if (!a.substring(0, i).equals(b.substring(0,i))) return a.substring(0,i-1);
        }
        return a.substring(0, Math.min(al, bl));
    }

    public static void main(String[] args) {
        String[] a = new String[]{"A"};
//        System.out.println(smallScale(a,0,0));
        System.out.println("A".substring(0,1));
//
    }
}
