package info.bamzy;

public class Rotate2DArray {
    int[][] rotateImage(int[][] array) {
        int n = array.length - 1, tempVal1, tempVal2, tempVal3;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j < n - i ; j++) {
                tempVal1 = array[j][n-i];
                array[j][n-i] = array[i][j];
                tempVal2 = array[n - i][n - j];
                array[n - i][n - j] = tempVal1;
                tempVal3 = array[n-j][i];
                array[n-j][i] = tempVal2;
                array[i][j] = tempVal3;
            }
        }
        return array;
    }
}
