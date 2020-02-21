public class L275 {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n;
        int mid;
        while (l < r){
            mid = l + (r-l)/2;
            if (citations[mid] == n-mid){
                return n-mid;
            }
            else if (citations[mid] < n-mid){
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return n - l;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,5,7,8};
        System.out.println(hIndex(a));
    }
}
