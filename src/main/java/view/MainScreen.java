package view;

import java.awt.Color;
// import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class MainScreen extends JFrame{
    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JLabel title;
    private JButton input;
    private JButton sourceCode;
    private JButton guide;
    private JLabel textScreen;

    public MainScreen() {
        setTitle("Sudoku Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.decode("#DFF2EB"));

		setContentPane(contentPane);
		contentPane.setLayout(null);

        title = new JLabel("Sudoku Solving Application");
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setBounds(100, 4, 242, 28);
        contentPane.add(title);

        input = new JButton("INPUT");
        input.setFont(new Font("Tahoma", Font.PLAIN, 20));
		input.setBounds(0, 50, 100, 28);
        input.setFocusable(false);
        input.setBackground(Color.decode("#7AB2D3"));
        contentPane.add(input);
        
        guide = new JButton("GUIDE");
        guide.setFont(new Font("Tahoma", Font.PLAIN, 20));
		guide.setBounds(118, 50, 100, 28);
        guide.setFocusable(false);
        guide.setBackground(Color.decode("#7AB2D3"));
        contentPane.add(guide);

        sourceCode = new JButton("SOURCE CODE");
        sourceCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sourceCode.setBounds(235, 50, 200, 28);
        sourceCode.setFocusable(false);
        sourceCode.setBackground(Color.decode("#7AB2D3"));
        contentPane.add(sourceCode);

        textScreen = new JLabel("ddfdfd");
        textScreen.setOpaque(true);
        textScreen.setBackground(Color.WHITE);
		textScreen.setBounds(0, 85, 434, 180 - 6);
        contentPane.add(textScreen);
    }
}