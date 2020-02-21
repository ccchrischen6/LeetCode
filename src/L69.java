public class L69 {
    public static int mySqrt(int x) {
        if (x == 1 || x == 2 || x == 3) return 1;
        if (x == 0) return 0;
        int end = x / 2;
        int start = 0;
        int mid = (start + end) / 2;

        while (true) {
            if (mid == x / mid) return mid;
            if (mid > x / mid) {
                end = mid - 1;
            }
            if (mid < x / mid) {
                start = mid + 1;
                if (mid + 1 > x / (mid + 1)) return mid;
            }
            mid = (start + end) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(5));
    }
}
