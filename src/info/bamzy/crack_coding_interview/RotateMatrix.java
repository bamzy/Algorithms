package info.bamzy.crack_coding_interview;

public class RotateMatrix {
    public int[][] rotate(int[][] matrix){
        int w = matrix[0].length;
        int h = matrix.length;
        int[][] res = new int[w][h];
        for(int i = 0; i< h; i++){
            for(int j=0;j<w;j++){
                res[j][h-1-i] = matrix[i][j];
            }
        }
        return res;
    }
    public void rotateInPlace(int[][] matrix){

    }

    public static void runTest(){
        RotateMatrix rm = new RotateMatrix();
        //1 2 3     7  4  1
        //4 5 6     8  5  2
        //7 8 9     9  6  3
        int[][] res = rm.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
