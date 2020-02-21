public class L67 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        int sum;
        while (i >= 0 || j >=0 || carry != 0){
            sum = 0;
            if (i>=0){
                sum += a.charAt(i--) - '0';
            }
            if (j>=0){
                sum += b.charAt(j--) - '0';
            }
            sb.append((sum + carry)%2);
            carry = (sum + carry)/2;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String A = "10011";
        String B = "110";
        System.out.println(addBinary(A, B));
    }
}
