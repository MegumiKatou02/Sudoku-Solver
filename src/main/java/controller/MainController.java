package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.InputScreen;
import view.MainScreen;

public class MainController implements ActionListener{
    private MainScreen mainScreen;
    
    public MainController(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mainScreen.input) {
                InputScreen inputScreen = new InputScreen();
                inputScreen.setVisible(true);
            }
    }
    
}
