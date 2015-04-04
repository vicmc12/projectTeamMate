package project4;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class CityEntryView extends JFrame implements ActionListener {
	/** Needs a serialVersionUID because the class is Serializable */
	private static final long serialVersionUID = 1L;

	//The model for this view.
	private TeamMateModel model;
	
	//The GUI elements for this view.
	private JTextField textFieldCityName;
	private JTextField textFieldLatitude;
	private JTextField textFieldLongitude;
	JLabel lblLatitude = new JLabel("Latitude");
	JLabel lblName = new JLabel("Name");
	JLabel lblLongitude = new JLabel("Longitude");
	JLabel messageArea = new JLabel("");
	JButton btnAddCity = new JButton("Add City");
	JButton btnCancel = new JButton("Cancel");
	/** The default constructor*/
	CityEntryView() {
		
		setBounds(100, 100, 201, 285);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblEnterTheCitys = new JLabel("Enter the city's information");
		lblEnterTheCitys.setBounds(10, 11, 134, 14);
		getContentPane().add(lblEnterTheCitys);
		
		
		lblName.setBounds(10, 36, 46, 14);
		getContentPane().add(lblName);
		
		
		lblLatitude.setBounds(10, 78, 46, 14);
		getContentPane().add(lblLatitude);
		
		
		lblLongitude.setBounds(10, 117, 57, 14);
		getContentPane().add(lblLongitude);
		
		textFieldCityName = new JTextField();
		textFieldCityName.setBounds(66, 36, 86, 20);
		getContentPane().add(textFieldCityName);
		textFieldCityName.setColumns(10);
		
		textFieldLatitude = new JTextField();
		textFieldLatitude.setBounds(66, 75, 86, 20);
		getContentPane().add(textFieldLatitude);
		textFieldLatitude.setColumns(10);
		
		textFieldLongitude = new JTextField();
		textFieldLongitude.setBounds(66, 114, 86, 20);
		getContentPane().add(textFieldLongitude);
		textFieldLongitude.setColumns(10);
		
		
		messageArea.setBounds(0, 185, 175, 50);
		getContentPane().add(messageArea);
		
		
		btnAddCity.setBounds(10, 157, 89, 23);
		getContentPane().add(btnAddCity);
		
		
		btnCancel.setBounds(106, 157, 79, 23);
		getContentPane().add(btnCancel);
		setVisible(true);
	}
	
	public void setModel(TeamMateModel model) {
		/** Set a model */
		this.model = model;
		if (this.model != null){
			model.addActionListener(this);
			// Register the view as listener for the model

		}
	}
	
	/**
	 * ActionListener for the method.
	 * <P>
	 * @param      actionEvent     an event				
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getActionCommand().equals("Select State")) {
			
		}
	}
	
	public void addAddCityListener(ActionListener listenAddCityButton ){
		btnAddCity.addActionListener(listenAddCityButton);
	}
	public void addCancelListener(ActionListener listenForCancelButton ){
		btnCancel.addActionListener(listenForCancelButton);
	}


	public String getCityName() {
		// TODO Auto-generated method stub
		return textFieldCityName.getText();
	}

	public Double getLatitude() {
		// TODO Auto-generated method stub
		return Double.parseDouble(textFieldLatitude.getText());
		
	}

	public Double getLongitude() {
		// TODO Auto-generated method stub
		return Double.parseDouble(textFieldLongitude.getText());
	}
}