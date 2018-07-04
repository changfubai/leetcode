package greatAlgo;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        if (dividend == 0 || lDividend < lDivisor) {
            return 0;
        }
        int q = 0;
        boolean diffSign = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            diffSign = true;
        }
        while (lDividend >= lDivisor) {
            long temp = lDivisor;
            long multiplier = 1;
            while (lDividend >= temp << 1) {
                temp <<= 1;
                multiplier <<= 1;
            }
            lDividend -= temp;
            q += multiplier;
        }
        if (diffSign) {
            return q * (-1);
        } else {
            return q;
        }

    }
}
