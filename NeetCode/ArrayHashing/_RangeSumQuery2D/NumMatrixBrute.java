package _RangeSumQuery2D;


//TC : O(M*N*Q) where Q is the number of calls made

public class NumMatrixBrute {
    private int[][] matrix;

    public NumMatrixBrute(int[][] incomingMatrix) {
        this.matrix=incomingMatrix;

    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;

        for(int i=row1;i<=row2;i++){
            for(int j=col1;j<=col2;j++){
                sum+=this.matrix[i][j];
            }
        }

        return sum;
    }

}
