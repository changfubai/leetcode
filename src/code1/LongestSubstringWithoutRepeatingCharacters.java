package code1;

/**
 *
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 关键词：三种循环方式：前腿走路、后腿走路、双腿走路
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        if (s.equals("")){
            return 0;
        }
        for (int i = 0; i < s.length(); i++){
            NotRepeatingStr ss = new NotRepeatingStr();
            int j = i;
            while (j < s.length()){
                if(!ss.addCharacter(s.charAt(j))){
                    max = max > ss.getLength()? max : ss.getLength();
                    break;
                }
                j++;
                if(j == s.length()){
                    max = max > ss.getLength()? max : ss.getLength();
                    break;
                }

            }
        }
        return max;
    }

    class NotRepeatingStr{
        StringBuilder str = null;
        public NotRepeatingStr(){
            str = new StringBuilder();
        }

        int getLength(){
            return str.length();
        }

        boolean addCharacter(char c){
            if (str.indexOf(String.valueOf(c)) == -1){
                str.append(c);
                return true;
            }
            return false;
        }

    }
}
