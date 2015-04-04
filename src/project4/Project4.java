package project4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JMenuBar;

public class Project4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project4 window = new Project4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Project4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 617, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(77, 252, 77, 23);
		frame.getContentPane().add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(42, 63, 144, 178);
		frame.getContentPane().add(list);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(77, 275, 77, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(77, 298, 77, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JList list_1 = new JList();
		list_1.setBounds(244, 63, 144, 178);
		frame.getContentPane().add(list_1);
		
		JButton button = new JButton("Add");
		button.setBounds(285, 252, 77, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Edit");
		button_1.setBounds(285, 275, 77, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.setBounds(285, 298, 77, 23);
		frame.getContentPane().add(button_2);
		
		JList list_2 = new JList();
		list_2.setBounds(430, 63, 144, 178);
		frame.getContentPane().add(list_2);
		
		JButton button_3 = new JButton("Add");
		button_3.setBounds(469, 252, 77, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Edit");
		button_4.setBounds(469, 275, 77, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Delete");
		button_5.setBounds(469, 298, 77, 23);
		frame.getContentPane().add(button_5);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 601, 23);
		frame.getContentPane().add(menuBar);
		
		JLabel lblNewLabel = new JLabel("Places");
		lblNewLabel.setBounds(42, 41, 144, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("People");
		label.setBounds(244, 41, 144, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Teams");
		label_1.setBounds(430, 41, 144, 23);
		frame.getContentPane().add(label_1);
		


		
	
	}
}
