package code1;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return match(s, p, true);
    }

    public boolean match(String s, String p, boolean initial) {
        if (s.equals(p)) {
            return true;
        }

        if (initial) {
            if (s.equals("")) {
                if (p.length() % 2 == 0) {
                    for (int i = 0; i < p.length(); i = i + 2) {
                        if (p.charAt(i + 1) != '*') {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            if (p.contains("*")) {
                int i = p.lastIndexOf("*");
                int len = p.length() - i;
                if (i == p.length() - 1) {
                    while (true) {
                        p = p.substring(0, p.length() - 1);
                        if (p.length() < 2) {
                            char c = p.charAt(0);
                            if (c == '.') {
                                return true;
                            }
                            while (true) {
                                if (s.length() == 0) {
                                    return true;
                                }
                                if (s.charAt(s.length() - 1) != c) {
                                    return false;
                                }
                                s = s.substring(0, s.length() - 1);
                            }
                        }
                        if (p.charAt(p.length() - 1) != p.charAt(p.length() - 2)) {

                            char c = p.charAt(p.length() - 1);
                            if (c != '.') {
                                int x = 0;
                                while (true) {
                                    if (p.charAt(x + 1) == '*' && p.length() > x + 2) {
                                        x = x + 2;
                                        p = p.substring(0, x) + p.substring(x + 1, p.length());
                                        s = s.substring(0, x) + s.substring(x + 1, s.length());
                                    } else {
                                        break;
                                    }
                                }
                                while (true) {
                                    if (s.length() == 0 || s.charAt(s.length() - 1) != c) {
                                        return match(s, p.substring(0, p.length() - 1), true);
                                    }
                                    s = s.substring(0, s.length() - 1);
                                }
                            } else {
                                boolean tmp = false;
                                while (s.length() > 0) {
                                    tmp = tmp || match(s, p.substring(0, p.length() - 1), true);
                                    s = s.substring(0, s.length() - 1);
                                }
                                return tmp;
                            }


                        }
                    }
                }
                if (len > s.length()) {
                    return false;
                }
                return match(s.substring(s.length() - len + 1, s.length()), p.substring(i + 1, p.length()), false) &&
                        match(s.substring(0, s.length() - len + 1), p.substring(0, i + 1), true);
            } else {
                return match(s, p, false);
            }
        }
        if (s.length() != p.length() || s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (p.charAt(i) != '.' && s.charAt(i) != p.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
