public class L70 {
    public int f(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        return f(n-1) + f(n-2);
    }

    public static void main(String[] args) {
        L70 test = new L70();
        for(int i=0; i<20; i++){
            System.out.println("i = " + i + ", f(i) = " + test.f(i));
        }
    }
}
