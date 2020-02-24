import java.util.ArrayList;
import java.util.List;

public class L93_recursion {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList();
        helper(s, "", res, 0, 0);
        return res;
    }

    private void helper(String s, String current, List<String> res, int idx, int count){
        if(count>4) return;
        if(count==4 && idx==s.length()) res.add(current);

        for(int i=1; i<4; i++){
            if(idx+i>s.length()) break;
            String fregment = s.substring(idx, idx+i);
            if(fregment.startsWith("0") || Integer.parseInt(fregment)>255) continue;
            helper(s, current + (count==0? fregment : "."+fregment), res, idx+i, count+1);
        }
    }
}
