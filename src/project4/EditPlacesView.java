package project4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Project #4 
 * CS 2334, Section 010 
 * Mar 31, 2015
 * <P>
 * </P>
 * 
 * @version 1.0
 */

public class EditPlacesView extends JFrame implements ActionListener {

  private JTextField textFieldName = new JTextField();;
  private JTextField textFieldLatitude = new JTextField();
  private JTextField textFieldLongitude = new JTextField();;
  JLabel labelLatitude = new JLabel("Latitude");
  JLabel labelLongitude = new JLabel("Longitude");
  JButton editCityButton = new JButton("Edit City");
  JButton cancelButton = new JButton("Cancel");
  JLabel commentLablel= new JLabel("");
  JLabel stateLabel = new JLabel("");
  private TeamMateModel model;



EditPlacesView(){
		setBounds(100, 100, 207, 332);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblEditTheCitys = new JLabel("Edit the city's information");
		lblEditTheCitys.setBounds(10, 11, 157, 14);
		getContentPane().add(lblEditTheCitys);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 51, 46, 14);
		getContentPane().add(lblName);

		textFieldName.setBounds(66, 48, 101, 20);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		textFieldLatitude.setColumns(10);
		textFieldLatitude.setBounds(66, 126, 101, 20);
		getContentPane().add(textFieldLatitude);
		

		textFieldLongitude.setColumns(10);
		textFieldLongitude.setBounds(66, 157, 101, 20);
		getContentPane().add(textFieldLongitude);
		
		
		labelLatitude.setBounds(10, 129, 46, 14);
		getContentPane().add(labelLatitude);
		
		
		labelLongitude.setBounds(10, 160, 57, 14);
		getContentPane().add(labelLongitude);
		
		
		editCityButton.setBounds(10, 189, 86, 23);
		getContentPane().add(editCityButton);
		
		
		cancelButton.setBounds(106, 189, 76, 23);
		getContentPane().add(cancelButton);
		
		
		commentLablel.setBounds(10, 223, 171, 60);
		getContentPane().add(commentLablel);
		
		
		stateLabel.setBounds(76, 72, 76, 14);
		getContentPane().add(stateLabel);
		setVisible(true);
  }
	
	
    public void addEditButtonlListener(ActionListener listenForEditButton ){
    	editCityButton.addActionListener(listenForEditButton);
   }
    public void addCancelButtonListener(ActionListener listenForCancelButton ){
    	cancelButton.addActionListener(listenForCancelButton);
   }
	
	
	
	
    public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getActionCommand().equals("Select State")) {
			System.out.println("TESATASTR");
		}
	}


	public void setModel(TeamMateModel model) {
		/** Set a model */
		this.model = model;
		if (this.model != null){
			model.addActionListener(this);
			// Register the view as listener for the model

		}
	}
	
	public void setSelectedState(String stateName){
		stateLabel.setText(stateName);
	}
	public String getCityName() {
		// TODO Auto-generated method stub
		return textFieldName.getText();
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
