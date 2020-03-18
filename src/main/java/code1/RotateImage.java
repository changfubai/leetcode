package code1;

/**
 * Created by changfubai96@gmail.com on 2018/7/16
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n <= 1){
            return;
        }
        for (int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i; j++){
                swap1(matrix, i, j, n);
            }
        }

        for (int i = 0; i < n / 2; i++){
            for (int j = 0; j < n; j++){
                swap2(matrix, i, j, n);
            }
        }

    }
    private void swap1(int[][] a, int i, int j, int n){
        int tmp = a[i][j];
        a[i][j] = a[n - j - 1][n - i - 1];
        a[n - j - 1][n - i - 1] = tmp;
    }
    private void swap2(int[][] a, int i, int j, int n){
        int tmp = a[i][j];
        a[i][j] = a[n - i - 1][j];
        a[n - i - 1][j] = tmp;
    }
}
