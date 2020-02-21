public class L70 {
    public static int climbStairs(int n) {
        return climb(0, n);
    }

    public static int climb(int i, int n){
        if (i>n) return 0;
        if (i==n) return 1;
        return climb(i+1, n) + climb(i+2, n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
