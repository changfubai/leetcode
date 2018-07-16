package code1;

/**
 * Created by changfubai96@gmail.com on 2018/7/12
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0){
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int p1 = i + j, p2 = i + j + 1;
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = num + res[p2];

                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : res){
            if(!(sb.length() == 0 && num == 0)){
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
