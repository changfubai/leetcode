package code1;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits.length() == 0) return list;
        String[] ditStr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            String str = ditStr[digits.charAt(i) - '0'];
            List<String> tmp = new LinkedList<>();
            for (int j = 0; j < str.length(); j++) {
                for (String ss : list) {
                    tmp.add(ss + str.charAt(j));
                }
            }
            list.clear();
            list.addAll(tmp);
        }
        return list;
    }
}
