package code1;

public class FirstBadVersion extends VersionControl{
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            //用medium = (left + right) / 2;可能会越界
            int medium = left + (right - left) / 2;
            if (isBadVersion(medium)) right = medium;
            else left = medium + 1;
        }
        return left;
    }
}
abstract class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}
