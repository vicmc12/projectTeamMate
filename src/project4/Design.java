package project4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Design {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Design window = new Design();
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
	public Design() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 207, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEditTheCitys = new JLabel("Edit the city's information");
		lblEditTheCitys.setBounds(10, 11, 157, 14);
		frame.getContentPane().add(lblEditTheCitys);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 51, 46, 14);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(66, 48, 101, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 126, 101, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 157, 101, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel label = new JLabel("Latitude");
		label.setBounds(10, 129, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Longitude");
		label_1.setBounds(10, 160, 57, 14);
		frame.getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("Edit City");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 189, 86, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Cancel");
		button.setBounds(106, 189, 76, 23);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 223, 171, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(76, 72, 76, 14);
		frame.getContentPane().add(label_2);
	}
}
