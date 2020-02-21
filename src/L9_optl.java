public class L9_optl {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        int pop;
        int reverse = 0;
        int xcop = x;
        while (x!=0){
            pop = x%10;
            reverse = reverse*10 + pop;
            x/=10;
        }
        if (xcop == reverse){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 132321;
        System.out.println(isPalindrome(a));
    }
}
