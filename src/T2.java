import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("one", "1");
        System.out.println(map);
        map.remove("one");
        System.out.println(map.isEmpty());
    }
}
