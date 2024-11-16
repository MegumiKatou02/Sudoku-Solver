package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import model.Guide;
import view.InputScreen;
import view.MainScreen;

public class MainController implements ActionListener{
    private MainScreen mainScreen;
    private InputScreen inputScreen;
    
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
                    inputScreen.dispose();
                    inputScreen = null;
                }
                mainScreen.title.setText("Sudoku Solving Application");

                // solve code
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
    }
    
}
