package model;

public class SudokuValid {
    private static String errorString = "";

    public static boolean isValidSudokuInput(String input) {
        final int SUDOKU_SIZE = 9;

        if (input == null || input.isEmpty()) {
            errorString = "Input is empty or null.";
            System.err.println("Input is empty or null.");
            return false;
        }

        String[] rows = input.split("\n");

        if (rows.length == SUDOKU_SIZE && rows[0].contains(" ")) {
            for (int i = 0; i < SUDOKU_SIZE; i++) {
                String row = rows[i].trim();
                String[] cells = row.split("\\s+");

                if (cells.length != SUDOKU_SIZE) {
                    errorString = "Error at row " + (i + 1);
                    System.err.println("Row " + (i + 1) + " must have exactly " + SUDOKU_SIZE + " cells separated by spaces.");
                    return false;
                }

                for (int j = 0; j < SUDOKU_SIZE; j++) {
                    char cell = cells[j].charAt(0);

                    if (cell != '.' && cell != '0' && (cell < '1' || cell > '9')) {
                        System.err.println("Invalid character '" + cell + "' at row " + (i + 1) + ", column " + (j + 1));
                        errorString = "Invalid character '" + cell + "' at row " + (i + 1) + ", column " + (j + 1);
                        return false;
                    }
                }
            }
        } 
        else if ((rows.length == SUDOKU_SIZE && !rows[0].contains(" ")) || (rows.length == 1 && rows[0].length() == SUDOKU_SIZE * SUDOKU_SIZE)) {
            String continuousInput = rows.length == 1 ? rows[0] : String.join("", rows);

            if (continuousInput.length() != SUDOKU_SIZE * SUDOKU_SIZE) {
                errorString = "Input must have exactly " + (SUDOKU_SIZE * SUDOKU_SIZE) + " characters.";
                System.err.println("Input must have exactly " + (SUDOKU_SIZE * SUDOKU_SIZE) + " characters.");
                return false;
            }

            for (int i = 0; i < continuousInput.length(); i++) {
                char cell = continuousInput.charAt(i);

                if (cell != '.' && cell != '0' && (cell < '1' || cell > '9')) {
                    int row = i / SUDOKU_SIZE + 1;
                    int col = i % SUDOKU_SIZE + 1;
                    errorString = "Invalid character '" + cell + "' at row " + row + ", column " + col;
                    System.err.println("Invalid character '" + cell + "' at row " + row + ", column " + col);
                    return false;
                }
            }
        } 
        else {
            errorString = "Input format is invalid. Must be 9 rows with spaces or a single 81-character string.";
            System.err.println("Input format is invalid. Must be 9 rows with spaces or a single 81-character string.");
            return false;
        }

        errorString = "Input is valid.";
        System.out.println("Input is valid.");
        return true;
    }

    public static String getErrorString() {
        return errorString;
    }
}