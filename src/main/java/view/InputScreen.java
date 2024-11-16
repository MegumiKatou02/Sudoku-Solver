package view;

import java.awt.BorderLayout;
import java.awt.Color;
// import java.awt.EventQueue;

// import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
// import javax.swing.JLabel;
import java.awt.Font;

public class InputScreen extends JFrame {
    private static final long serialVersionUID = 1L;
	private JPanel contentPane;

    public InputScreen() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.decode("#DFF2EB"));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setBounds(100, 100, 200, 200);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        contentPane.add(textArea);
    }
}