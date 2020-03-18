package code1;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && (divisor == 1 || divisor == -1))
            return divisor == -1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return (int) divideLong(dividend, divisor);
    }

    long divideLong(long dd, long ds) {
        boolean isNeg = dd >= 0 && ds < 0 || dd < 0 && ds >= 0;
        dd = Math.abs(dd);
        ds = Math.abs(ds);
        int digits = 0;
        while (dd >= ds) {
            ds <<= 1;
            digits++;
        }
        ds >>= digits;
        digits--;
        long res = 0;
        while (digits >= 0) {
            if (dd >= (ds << digits)) {
                dd -= (ds << digits);
                res += (1 << digits);
            }
            digits--;
        }
        return isNeg ? - res : res;
    }
}
