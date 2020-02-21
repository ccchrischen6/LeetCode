public class L70_f_formula {
    public static int climbStairs(int n) {
        double a = (1 + Math.pow(5, 0.5))/2;
        double b = (1 - Math.pow(5, 0.5))/2;
        return (int) (1/Math.pow(5, 0.5)*(Math.pow(a, n+1) - Math.pow(b,n+1)));
    }

    public static void main(String[] args) {
        for (int i=1; i<6; i++)
            System.out.println(climbStairs(i));
    }
}
