public class L9_optl_best {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x%10 == 0 && x!=0)) return false;
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x%10;
            x /= 10;
        }
        if (x == reverse || x == reverse/10) return true;
        return false;
}

    public static void main(String[] args) {
        int a = 10;
        System.out.println(isPalindrome(a));
    }
}
