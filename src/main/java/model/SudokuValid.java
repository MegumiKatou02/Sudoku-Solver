package model;

public class SudokuValid {
    public static boolean isValidSudokuInput(String input) {
        if (input == null || input.isEmpty()) {
            System.err.println("Input is empty or null.");
            return false;
        }

        String[] rows = input.split("\n");
        if (rows.length != 9) {
            System.err.println("Input must have exactly 9 rows.");
            return false;
        }

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].trim();
            String[] cells = row.split("\\s+");
            if (cells.length != 9) {
                System.err.println("Row " + (i + 1) + " must have exactly 9 cells.");
                return false;
            }

            for (String cell : cells) {
                if (!cell.matches("[1-9\\.]")) {
                    System.err.println("Invalid character '" + cell + "' in row " + (i + 1));
                    return false;
                }
            }
        }

        System.out.println("Input is valid.");
        return true;
    }
}
