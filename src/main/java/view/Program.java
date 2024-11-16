package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

public class Program extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel l1, l2, l3, l4, nameGroup;
	
	Generation gen = new Generation();
	private ArrayList<Member> members = gen.getMembers();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					Program frame = new Program();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// test new
	public Program() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		l1 = new JLabel(members.get(0).getName());
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l1.setBounds(108, 83, 242, 28);
		contentPane.add(l1);
		
		l2 = new JLabel(members.get(1).getName());
		l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l2.setBounds(108, 121, 242, 28);
		contentPane.add(l2);
		
		l3 = new JLabel(members.get(2).getName());
		l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l3.setBounds(108, 159, 242, 28);
		contentPane.add(l3);
		
		l4 = new JLabel(members.get(3).getName());
		l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l4.setBounds(108, 197, 242, 28); 
		contentPane.add(l4);
		
		nameGroup = new JLabel("Group 3");
		nameGroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameGroup.setBounds(108, 23, 242, 28);
		contentPane.add(nameGroup);
	}
	public JLabel getL1() {
        return l1;
    }

    public JLabel getL2() {
        return l2;
    }

    public JLabel getL3() {
        return l3;
    }

    public JLabel getL4() {
        return l4;
    }
	public JLabel getNameGroup() {
        return nameGroup;
    }
}
