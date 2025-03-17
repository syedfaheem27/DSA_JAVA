package _ValidSudoku;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class main {
    //TC: O(1)
    //SC: O(1)
    //Because it's always a 9*9 matrix
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rowMap=new HashMap<>();
        Map<Integer,Set<Character>> colMap=new HashMap<>();
        Map<Integer,Set<Character>> subMatrixMap=new HashMap<>();

        for(int i=0;i<9;i++){
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            subMatrixMap.put(i, new HashSet<>());
        }


        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                Set<Character> rowSet=rowMap.get(i);
                Set<Character> colSet=colMap.get(j);

                int subMatrixIndex=this.getSubMatrixIndex(i, j);
                Set<Character> subMatrixSet=subMatrixMap.get(subMatrixIndex);

                Character ch=board[i][j];

                if(ch=='.'){
                    continue;
                }

                if(rowSet.contains(ch) || colSet.contains(ch) || subMatrixSet.contains(ch)){
                    return false;
                }

                rowSet.add(ch);
                colSet.add(ch);
                subMatrixSet.add(ch);
            }
        }


        return true;

    }

    private int getSubMatrixIndex(int x,int y){
        return (int) (Math.floor((double)(x/3))*3 + Math.floor((double)(y/3)));
    }


    public boolean validSudokuOptimal(char[][] board){
        boolean[][] boolBoard=new boolean[9][9];

        int[][] intervalMap={{0,2},{3,5},{6,8}};


        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char num=board[i][j];

                if(num=='.'){
                    continue;
                }

                if(boolBoard[i][num] || boolBoard[num][j]){
                    return false;
                }

                boolBoard[i][num]=true;
                boolBoard[num][j]=true;

                int subMatrixRow=(int)Math.floor((double)(i/3));
                int subMatrixCol=(int)Math.floor((double)(j/3));

                int[] topLeft={intervalMap[subMatrixRow][0],intervalMap[subMatrixCol][0]};

                int newRow=topLeft[0] + (int)Math.floor(num/3);
                int newCol=topLeft[1] +(int)Math.floor(num%3);

                if(boolBoard[newRow][newCol]){
                    return false;
                }

                boolBoard[newRow][newCol]=true;
            }
        }


        return true;
    }




}
