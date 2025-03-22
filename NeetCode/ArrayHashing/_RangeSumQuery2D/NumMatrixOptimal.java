package _RangeSumQuery2D;



//TC: O(1*Q) for sumRegion
//SC: O(M*N)
public class NumMatrixOptimal {
    private int[][] matrix;

    private int[][] prefSumMatrix;

    public NumMatrixOptimal(int[][] matrix) {
        this.matrix=matrix;

        int numRows=this.matrix.length;
        int numCols=this.matrix[0].length;

        this.prefSumMatrix=new int[numRows][numCols];

        int sumRow=0;

        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                if(i==0){
                    sumRow+=this.matrix[i][j];

                    this.prefSumMatrix[i][j]=sumRow;
                }else if(j==0){
                    this.prefSumMatrix[i][j]=this.prefSumMatrix[i-1][j]+this.matrix[i][j];
                }else{
                    this.prefSumMatrix[i][j]=this.prefSumMatrix[i-1][j]+this.prefSumMatrix[i][j-1]-this.prefSumMatrix[i-1][j-1]+this.matrix[i][j];
                }
            }

        }
    }



    public int sumRegion(int row1, int col1, int row2, int col2) {

        if(row1-1>=0 && col1-1>=0){
            return this.prefSumMatrix[row2][col2]-this.prefSumMatrix[row1-1][col2]-this.prefSumMatrix[row2][col1-1]+this.prefSumMatrix[row1-1][col1-1];
        }else if(row1-1<0 && col1-1<0){
            return this.prefSumMatrix[row2][col2];
        }else if(row1-1<0){
            return this.prefSumMatrix[row2][col2]-this.prefSumMatrix[row2][col1-1];
        }else{
            return this.prefSumMatrix[row2][col2]-this.prefSumMatrix[row1-1][col2];
        }


    }



}
