import java.util.HashSet;
import java.util.Set;

public class L507 {
    public boolean checkPerfectNumber(int num) {
        if (num==0 || num==1) return false;
        Set<Integer> set = new HashSet();
        set.add(1);
        for(int i=2; i<=Math.sqrt(num); i++){
            if (num%i==0){
                set.add(i);
                set.add(num/i);
            }
        }
        int res = 0;
        for (int e : set) res += e;
        return res==num;
    }
}
