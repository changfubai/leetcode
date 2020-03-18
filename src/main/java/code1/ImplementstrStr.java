package code1;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        if (needle.equals(haystack) || needle.equals("")) return 0;
        for (int i = 0; i <= hay.length - nee.length; i++) {
            for (int j = 0; j < nee.length; j++) {
                if (nee[j] != hay[i + j]) break;
                if (j == nee.length - 1) return i;
            }
        }
        return -1;
    }

}
