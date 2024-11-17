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
        if (txt.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty.");
        }
    
        String[] rows = txt.split("\n");
    
        if (rows.length == 9 && rows[0].contains(" ")) {
            for (int i = 0; i < rows.length; i++) {
                String row = rows[i].trim();
                String[] cells = row.split("\\s+");
                if (cells.length != 9) {
                    throw new IllegalArgumentException("Each row must have exactly 9 cells.");
                }
                for (int j = 0; j < 9; j++) {
                    char cell = cells[j].charAt(0);
                    if (cell == '0') cell = '.';
                    if (cell != '.' && (cell < '1' || cell > '9')) {
                        throw new IllegalArgumentException("Invalid character '" + cell + "' at row " + (i + 1) + ", column " + (j + 1));
                    }
                    board[i][j] = cell;
                }
            }
        }
        else if ((rows.length == 9 && !rows[0].contains(" ")) || (rows.length == 1 && rows[0].length() == 81)) {
            String continuousInput = rows.length == 1 ? rows[0] : String.join("", rows);
            if (continuousInput.length() != 81) {
                throw new IllegalArgumentException("Input must have exactly 81 characters.");
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char cell = continuousInput.charAt(i * 9 + j);
                    if (cell == '0') cell = '.';
                    if (cell != '.' && (cell < '1' || cell > '9')) {
                        throw new IllegalArgumentException("Invalid character '" + cell + "' at position " + (i * 9 + j + 1));
                    }
                    board[i][j] = cell;
                }
            }
        } else {
            throw new IllegalArgumentException("Input format is invalid. Must be 9 rows with 9 cells each, or a single 81-character string.");
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