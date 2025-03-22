package _RangeSumQuery2D;


// TC :O(M*Q) for sum region
// SC :O(M*N)

public class NumMatrixOptimalI {
    private int[][] matrix;
    private int[][] prefRowMatrix;


    public NumMatrixOptimalI(int[][] incomingMatrix) {
        this.matrix=incomingMatrix;

        int numRows=this.matrix.length;

        int numCols=this.matrix[0].length;

        this.prefRowMatrix=new int[numRows][numCols];

        for(int i=0;i<numRows;i++){
            int sum=0;
            for(int j=0;j<numCols;j++){
                sum+=this.matrix[i][j];
                this.prefRowMatrix[i][j]=sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;

        for(int i=row1;i<=row2;i++){
            sum+=this.prefRowMatrix[i][col2]-this.prefRowMatrix[i][col1] + this.matrix[i][col1];
        }

        return sum;
    }


}
