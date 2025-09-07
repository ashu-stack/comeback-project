package Recursion;

public class NQueensAndKnights {
    public static void main(String[] args) {
        boolean[][] board = {
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false}
        };
        knight(board,0,0,4);

    }

    public static void knight(boolean[][] board, int row, int col, int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length-1 && col == board.length){
            return;
        }
        if(col == board.length){
            knight(board, row+1, 0, knights-1);
            return;
        }

        if(isSafeK(board,row, col)){
            board[row][col] = true;
            knight(board, row, col+1, knights-1);
            board[row][col] = false;
        }
        knight(board,row, col+1, knights-1);

    }

    private static boolean isSafeK(boolean[][] board, int row, int col) {

        if(isValid(board, row-2,col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }

        if(isValid(board, row-2,col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }

        if(isValid(board, row-1,col-2)){
            if(board[row+1][col-2]){
                return false;
            }
        }

        if(isValid(board, row-1,col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col){

        if(row < 0 || row > board.length) return false;
        if(col < 0 || col > board.length) return false;
        return true;
    }
    public static void display(boolean[][] board){
        for(boolean[] row:board){
            for(boolean el: row){
                if(el){
                    System.out.print("K ");
                }else{
                    System.out.print("X ");
                }

            }
            System.out.println();
        }
        System.out.println();
    }
    static int queens(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            return 1;
        }
        int count=0;
        for(int col=0; col< board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += queens(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // vertical row:
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }
        int maxLeft = Math.min(row,col);
        for (int i = 1; i <= maxLeft ; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }
        int maxRight = Math.min(row, board.length-col-1);
        for (int i = 0; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
}
