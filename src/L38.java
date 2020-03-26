public class L38 {
    public static String countAndSay(int n) {
        if (n==1) return "1";
        StringBuilder sb = new StringBuilder();
        String str = countAndSay(n-1);
        char c;
        int count;
        for (int i=0; i<str.length(); i++){
            c = str.charAt(i);
            count = 1;
            while (i+1<str.length() && c==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(count + "" + c);
        }
        return sb.toString();
    }

}
