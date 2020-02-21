public class L20 {
    public static boolean isValid(String s) {
        if (s.length() == 0 || s == null) return true;
        if (s.length()%2 != 0) return false;
        boolean ip = true;
        boolean ib = true;
        boolean ic = true;
        while (ip || ib || ic){
            System.out.println(s);
            if (s.contains("()")){
                s = s.replace("()", "");
                ip = true;
            }
            else ip = false;

            if (s.contains("[]")){
                s = s.replace("[]", "");
                ib = true;
            }
            else ib = false;

            if (s.contains("{}")){
                s= s.replace("{}", "");
                ic = true;
            }
            else ic = false;
        }
        if (s.length() == 0 || s == null) return true;
        else return false;
    }
public static void main(String[] args) {
    String s = "((()(())))";
    System.out.println(isValid(s));
}
}
