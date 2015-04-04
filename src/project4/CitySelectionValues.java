package project4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CitySelectionValues {

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
					CitySelectionValues window = new CitySelectionValues();
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
	public CitySelectionValues() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 201, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterTheCitys = new JLabel("Enter the city's information");
		lblEnterTheCitys.setBounds(10, 11, 134, 14);
		frame.getContentPane().add(lblEnterTheCitys);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setBounds(10, 78, 46, 14);
		frame.getContentPane().add(lblLatitude);
		
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setBounds(10, 117, 57, 14);
		frame.getContentPane().add(lblLongitude);
		
		textField = new JTextField();
		textField.setBounds(66, 36, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 75, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 114, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 185, 175, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAddCity = new JButton("Add City");
		btnAddCity.setBounds(10, 157, 89, 23);
		frame.getContentPane().add(btnAddCity);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(106, 157, 79, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
