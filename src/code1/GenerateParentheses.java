package code1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, n, "", res);
        return res;
    }

    void generate(int left, int right, String sb, List<String> res) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        generate(left - 1, right, sb + "(", res);
        generate(left, right - 1, sb + ")", res);
    }
}
