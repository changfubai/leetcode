package code1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 * 采用滑动窗口的思路，学习自 http://blog.csdn.net/linhuanmars/article/details/20342851
 *
 */
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(s==null || s.length()==0 || words==null || words.length==0)return res;
        //存放词和对应出现的次数
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) map.put(words[i], map.get(words[i]) + 1);
            else map.put(words[i], 1);
        }
        for (int i = 0; i < words[0].length(); i++) {
            //作为局部变量，避免对其进行clear
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            int count = 0;
            int left = i;
            for (int j = i; j <= s.length() - words[0].length(); j += words[0].length()) {
                String str = s.substring(j, j + words[0].length());
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str))
                        curMap.put(str, curMap.get(str) + 1);
                    else
                        curMap.put(str, 1);
                    if (curMap.get(str) <= map.get(str))
                        count++;
                    else {
                        //将多余的不合格的词跳过  做缓存处理
                        while (curMap.get(str) > map.get(str)) {
                            String temp = s.substring(left, left + words[0].length());
                            if (curMap.containsKey(temp)) {
                                curMap.put(temp, curMap.get(temp) - 1);
                                if (curMap.get(temp) < map.get(temp))
                                    count--;
                            }
                            left += words[0].length();
                        }
                    }
                    if (count == words.length) {
                        res.add(left);
                        String temp = s.substring(left, left + words[0].length());
                        if (curMap.containsKey(temp))
                            curMap.put(temp, curMap.get(temp) - 1);
                        count--;
                        left += words[0].length();
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = j + words[0].length();
                }
            }
        }
        return res;
    }
}
