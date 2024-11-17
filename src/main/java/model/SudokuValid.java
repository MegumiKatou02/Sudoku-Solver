package model;

public class SudokuValid {
    public static boolean isValidSudokuInput(String input) {
        final int SUDOKU_SIZE = 9;

        if (input == null || input.isEmpty()) {
            System.err.println("Input is empty or null.");
            return false;
        }

        String[] rows = input.split("\n");

        if (rows.length == SUDOKU_SIZE && rows[0].contains(" ")) {
            for (int i = 0; i < SUDOKU_SIZE; i++) {
                String row = rows[i].trim();
                String[] cells = row.split("\\s+"); // Tách các ô theo khoảng trắng

                if (cells.length != SUDOKU_SIZE) {
                    System.err.println("Row " + (i + 1) + " must have exactly " + SUDOKU_SIZE + " cells separated by spaces.");
                    return false;
                }

                for (int j = 0; j < SUDOKU_SIZE; j++) {
                    char cell = cells[j].charAt(0);

                    if (cell != '.' && cell != '0' && (cell < '1' || cell > '9')) {
                        System.err.println("Invalid character '" + cell + "' at row " + (i + 1) + ", column " + (j + 1));
                        return false;
                    }
                }
            }
        } 
        // Trường hợp input không có khoảng trắng (chuỗi liên tiếp 81 ký tự)
        else if ((rows.length == SUDOKU_SIZE && !rows[0].contains(" ")) || (rows.length == 1 && rows[0].length() == SUDOKU_SIZE * SUDOKU_SIZE)) {
            String continuousInput = rows.length == 1 ? rows[0] : String.join("", rows);

            if (continuousInput.length() != SUDOKU_SIZE * SUDOKU_SIZE) {
                System.err.println("Input must have exactly " + (SUDOKU_SIZE * SUDOKU_SIZE) + " characters.");
                return false;
            }

            for (int i = 0; i < continuousInput.length(); i++) {
                char cell = continuousInput.charAt(i);

                if (cell != '.' && cell != '0' && (cell < '1' || cell > '9')) {
                    int row = i / SUDOKU_SIZE + 1;
                    int col = i % SUDOKU_SIZE + 1;
                    System.err.println("Invalid character '" + cell + "' at row " + row + ", column " + col);
                    return false;
                }
            }
        } 
        else {
            System.err.println("Input format is invalid. Must be 9 rows with spaces or a single 81-character string.");
            return false;
        }

        System.out.println("Input is valid.");
        return true;
    }
}