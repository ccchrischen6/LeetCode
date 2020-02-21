public class L9 {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        String str = Integer.toString(x);
        String[] n = str.split("");
        for (int i=0; i<n.length/2; i++){
            if (!n[i].equals(n[n.length-1-i])) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int a = 12323321;
        System.out.println(isPalindrome(a));
    }
}
