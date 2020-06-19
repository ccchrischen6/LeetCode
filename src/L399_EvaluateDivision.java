import java.util.HashMap;
import java.util.Map;

public class L399_EvaluateDivision {
    public double[] calcEquation(String[][] e, double[] values, String[][] q) {
        double[] res = new double[q.length];
        Map<String, String> root = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();
        for (int i = 0; i < e.length; i++) {
            String r1 = find(root, dist, e[i][0]);
            String r2 = find(root, dist, e[i][1]);
            root.put(r1, r2);
            dist.put(r1, dist.get(e[i][1]) * values[i] / dist.get(e[i][0]));
        }
        for (int i = 0; i < q.length; i++) {
            if (!root.containsKey(q[i][0]) || !root.containsKey(q[i][1])) {
                res[i] = -1.0;
                continue;
            }
            String r1 = find(root, dist, q[i][0]);
            String r2 = find(root, dist, q[i][1]);
            if (!r1.equals(r2)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = (double) dist.get(q[i][0]) / dist.get(q[i][1]);
        }
        return res;
    }

    private String find(Map<String, String> root, Map<String, Double> dist, String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if (root.get(s).equals(s)) return s;
        String lastP = root.get(s);
        String p = find(root, dist, lastP);
        root.put(s, p);
        dist.put(s, dist.get(s) * dist.get(lastP));
        return p;

    }

    /*
    [["a","b"],["b","c"]]
    [2.0,3.0]
    [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     */

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 2, 5, 2, 5, 2, 2, 1, 4, 1, 4, 1, 3, 1};
        String[][] e = new String[][]{{"a", "b"}, {"b", "c"}};
        double[] values = new double[]{2.0, 3.0};
        String[][] q = new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};

        L399_EvaluateDivision test = new L399_EvaluateDivision();
        test.calcEquation(e, values, q);
    }
}
