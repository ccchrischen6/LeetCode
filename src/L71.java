import java.util.LinkedList;

public class L71 {
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        LinkedList<String> list = new LinkedList();
        for (String s : path.split("/")){
            if (s.equals("..")){
                if (!list.isEmpty()) list.removeLast();
            }
            else if (!s.equals(".") && !s.equals("")) list.add(s);
        }

        for (String s : list) res.append("/" + s);
        if (list.isEmpty()) return "/";
        return res.toString();
    }
}
