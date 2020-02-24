import java.util.ArrayList;
import java.util.List;

public class L93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        StringBuilder ip = new StringBuilder();
        for (int a=1; a<4 && len-a>2; a++)
            for (int b=1; b<4 && len-a-b>1; b++)
                for (int c=1; c<4 && len-a-b-c>0; c++){
                    String s1 = s.substring(0,a),
                            s2 = s.substring(a,a+b),
                            s3 = s.substring(a+b,a+b+c),
                            s4 = s.substring(a+b+c);
                    if (skip(s1) || skip(s2) || skip(s3) || skip(s4)) continue;
                    res.add(ip.append(s1).append(".").append(s2).append(".").append(s3).append(".").append(s4).toString());
                    ip = new StringBuilder();
                }
        return res;
    }

    private boolean skip(String s){
        if (s.length()==0 || (s.length()>3) ||
                (s.length()>1 && s.startsWith("0")) ||
                (Integer.parseInt(s)>255)) return true;
        else return false;
    }
}
