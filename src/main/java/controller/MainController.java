package controller;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import model.Guide;
import model.SudokuSolver;
import model.SudokuValid;
import view.InputScreen;
import view.MainScreen;

public class MainController implements ActionListener{
    private MainScreen mainScreen;
    private InputScreen inputScreen;
    private String ans;
    
    public MainController(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        this.inputScreen = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mainScreen.input && inputScreen == null) {
                inputScreen = new InputScreen();
                inputScreen.setVisible(true);

                mainScreen.title.setText("Nhấn INPUT để summit/exit");
            }
            else {
                if(inputScreen != null) {
                    System.out.println(inputScreen.textArea.getText());
                    if(!SudokuValid.isValidSudokuInput(inputScreen.textArea.getText())) {
                        mainScreen.textScreen.setText(SudokuValid.getErrorString());
                        inputScreen.dispose();
                        inputScreen = null;
                        return;
                    }
  
                    SudokuSolver solver = new SudokuSolver(inputScreen.textArea.getText());
                    if(solver.solveSudoku()) {
                        mainScreen.textScreen.setText(solver.buildSudoku().toString());
                        this.ans = solver.BoardString();
                    }
                    else {
                        mainScreen.textScreen.setText("Invalid Input");
                    }
                    inputScreen.dispose();
                    inputScreen = null;
                }
                mainScreen.title.setText("Sudoku Solving Application");
            }
            if(e.getSource() == mainScreen.guide) {
                Guide guide = new Guide();
                mainScreen.textScreen.setText(guide.getStringBuilder().toString());
            }
            if(e.getSource() == mainScreen.sourceCode) {
                try {
                    URI uri = new URI("https://github.com/MegumiKatou02/Sudoku-Solver");
                    Desktop.getDesktop().browse(uri); 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if(e.getSource() == mainScreen.copy) {
                if(this.ans != null) {
                    String text = this.ans;
                    if (!text.isEmpty()) {
                        StringSelection selection = new StringSelection(text);
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
                    }
                }
            }
    }
    
}

/*
 5 3 . . 7 . . . .
6 . . 1 9 5 . . .
. 9 8 . . . . 6 .
8 . . . 6 . . . 3
4 . . 8 . 3 . . 1
7 . . . 2 . . . 6
. 6 . . . . 2 8 .
. . . 4 1 9 . . 5
. . . . 8 . . 7 9

53..7....
6..195...
.98....6.
8...6...3
4..8.3..1
7...2...6
.6....28.
...419..5
....8..79

 */