package code1;

/**
 *
 Determine whether an integer is a palindrome. Do this without extra space.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.

 关键词： 数学关系 效率优先
 *
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x >= 0 && x <= 9)
            return true;
        if (x < 0 || x / 10 == 0)
            return false;
        int tmp = x;
        int tens = 1;
        while (tmp / 10 > 0) {
            tens *= 10;
            tmp /= 10;
        }
        while (tens >= 10){
            if (x / tens != x % 10) {
                return false;
            }
            x = x % tens;
            x = x / 10;
            tens /= 100;
        }
        return true;
    }
}
