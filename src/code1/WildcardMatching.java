package code1;

/**
 * Created by changfubai96@gmail.com on 2018/7/13
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int ss = 0, star = -1, i = 0, j = 0;

        while(i < s.length()){
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++;
                j++;
            }else if (j < p.length() && p.charAt(j) == '*'){
                ss = i;
                star = j;
                j++;
            }else if (star != -1){
                ss++;
                i = ss;
                j = star + 1;
            }else{
                return false;
            }
        }
        while(j < p.length() && p.charAt(j) == '*'){
            j++;
        }
        return j == p.length();

    }
}
