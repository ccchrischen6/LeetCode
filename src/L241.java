import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class L241 {
    Map<String, List<Integer>> map = new HashMap();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList();
        if (input == null || input.length() == 0) return res;

        if (map.containsKey(input)) return map.get(input);

        //check if input is pure number
        int idx = 0;
        int num = 0;
        while (idx < input.length() && Character.isDigit(input.charAt(idx))) {
            num = num * 10 + input.charAt(idx) - '0';
            idx++;
        }


        if (idx == input.length()) {
            res.add(Integer.parseInt(input));
            return res;
        }

        //if not pure num
        for (idx = 0; idx < input.length(); idx++) {
            char c = input.charAt(idx);
            if (Character.isDigit(c)) continue;

            List<Integer> res1 = diffWaysToCompute(input.substring(0, idx));
            List<Integer> res2 = diffWaysToCompute(input.substring(idx + 1));

            for (int i = 0; i < res1.size(); i++) {
                for (int j = 0; j < res2.size(); j++) {
                    res.add(calculate(res1.get(i), c, res2.get(j)));
                }
            }
        }

        map.put(input, res);
        return res;

    }

    private int calculate(int x, char op, int y) {
        switch (op) {
            case '+':
                return x + y;

            case '-':
                return x - y;

            case '*':
                return x * y;
        }

        return -1;

    }
}

