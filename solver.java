public class solver {
    public static void display(int [][] board){
        for(int r = 0; r < board.length;r++){
            for(int c = 0; c<board[0].length;c++){
                if(board[r][c]==0){
                    System.out.print("_ ");
                }
                else {
                    System.out.print(board[r][c] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void reset(int [][] board){
        for(int r = 0; r < board.length;r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = 0;
            }
        }
    }

    public static boolean is_Safe(int[][]board, int num, int currentRow, int currentCol) {
        for (int r = 0; r < board.length; r++) {
            if (num == board[r][currentCol]) {
                return false;
            }
        }
        for (int c = 0; c < board[0].length; c++) {
            if (num == board[currentRow][c]) {
                return false;
            }
        }
//        for (int r = 0; r < board.length; r += 3) {
//            for (int c = 0; c < board[0].length; c += 3) {
//                if (currentCol >= c && currentCol < 3 + c && currentRow >= r && currentRow < 3 + r) {
//                    for (int rr = r; rr < 3 + r; rr++) {
//                        for (int cc = c; cc < 3 + c; cc++) {
//                            if (num == board[rr][cc]) {
//                                return false;
//                            }
//                        }
//                    }
//                }
//            }
//        }
        int rowStart = currentRow - (currentRow %3);
        int colStart = currentCol - (currentCol %3);
        for(int r = rowStart; r< rowStart+3;r++) {
            for (int c = colStart; c < colStart + 3; c++) {
                if (board[r][c] == num)
                    return false;
            }
        }
        return true;
    }

    public static boolean solution(int[][] board){
        for(int r = 0; r<9;r++){
            for (int c = 0; c < 9; c++) {
                if(board[r][c]==0){
                    for (int i = 1; i <= 9; i++) {
                        if(is_Safe(board,i,r,c)){
                            board[r][c]=i;
                            if(solution(board)){
                                return true;
                            }
                        }
                        board[r][c]=0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String [] args){
        int [][] board = new int[][]{
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };
        int[][]board2 = new int[][]{
                {0,0,8,6,0,3,0,0,0},
                {0,0,0,7,0,0,0,3,0},
                {0,0,3,0,0,0,1,0,0},
                {0,0,7,9,4,5,6,1,0},
                {6,0,0,0,0,8,0,0,7},
                {0,0,0,2,0,6,0,8,4},
                {9,6,0,0,0,4,0,0,0},
                {3,0,0,0,0,0,0,0,0},
                {1,0,0,0,6,0,4,2,0},
        };
        display(board);
        solution(board);
        System.out.println();
        display(board);
    }
}
