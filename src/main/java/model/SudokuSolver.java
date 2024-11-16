package model;

public class SudokuSolver {
    private String txt;
    private char[][] board;

    public SudokuSolver(String txt) {
        this.txt = txt;
        this.board = new char[9][9];
        FixString();
    }
    private void FixString() {
        if(txt.isEmpty()) return;
        String[] rows = txt.split("\n");
        for (int i = 0; i < rows.length; i++) {
            String[] numbers = rows[i].trim().split("\\s+");
            for (int j = 0; j < numbers.length; j++) {
                board[i][j] = numbers[j].charAt(0); 
            }
        }
    }
    private boolean isValid(int row, int col, char num) {
        for (int x = 0; x < 9; ++x) {
            if (board[row][x] == num) return false;
        }
    
        for (int x = 0; x < 9; ++x) {
            if (board[x][col] == num) return false;
        }
    
        int startRow = 3 * (row / 3), startCol = 3 * (col / 3);
        for (int i = startRow; i < startRow + 3; ++i) {
            for (int j = startCol; j < startCol + 3; ++j) {
                if (board[i][j] == num) return false;
            }
        }
    
        return true;
    }
    public boolean solveSudoku() {
        if(txt.isEmpty()) return false;
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; ++num) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num;
    
                            if (solveSudoku()) return true;
    
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public StringBuilder buildSudoku() {
        StringBuilder builder = new StringBuilder("<html><pre>");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                builder.append(board[i][j] + " ");
            }
            builder.append("<br>");
        }
        builder.append("<pre></html>");
        return builder;
    }
    public void PrintBoard() { // debug
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public String BoardString() {
        String ans = "";

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(j == 8) ans += board[i][j];
                else ans += board[i][j] + " ";
            }
            ans += "\n";
        }
        return ans;
    }
}