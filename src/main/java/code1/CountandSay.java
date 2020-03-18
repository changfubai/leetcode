package code1;

public class CountandSay {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        StringBuilder sb1 = new StringBuilder();
        if (n <= 0) return "";
        while (n-- > 1) {
            int count = 0;
            char tmp = '0';
            for (int i = 0; i < sb.length(); i++) {
                if (tmp == '0') tmp = sb.charAt(i++);
                while (i < sb.length() && tmp == sb.charAt(i)) {
                    i++;
                    count++;
                }
                i--;
                sb1.append(count + 1);
                sb1.append(tmp);
                tmp = '0';
                count = 0;
            }
            sb = new StringBuilder(sb1);
            sb1 = new StringBuilder();
        }
        return sb.toString();
    }
}
