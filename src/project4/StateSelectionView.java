package project4;



import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Project #4 
 * CS 2334, Section 010 
 * Mar 31, 2015
 * <P>
 * </P>
 * 
 * @version 1.0
 */
public class StateSelectionView extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1147279642739035733L;
	private TeamMateModel model;

	
	JButton select = new JButton("Select");
	JButton cancel = new JButton("Cancel");
	private DefaultListModel StateListModel = new DefaultListModel();
	JList<String> stateList = new JList<String>(StateListModel);
	private JScrollPane scrollPaneStates = new JScrollPane(stateList);
	String[] statesString = {"AL","AK","AZ","AR","CA","CO", //TODO: list edited
			"CT","DE","DC","FL","GA","HI","ID","IL","IN","IA",//Do they need to 
			"KS","KY","LA","ME","MD","MA","MI","MN","MS","MO",//be alphabetical
			"MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH",//order by state name
			"OK","OR","PA","RI","SC","SD","TN","TX","UT","VT",//or by state abreviation
			"VA","WA","WV","WI","WY"};

	public StateSelectionView(){
	populateJList();
	setTitle("State Selection");	
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 203, 256);
	getContentPane().setLayout(null);
	
	
	scrollPaneStates.setBounds(10, 11, 170, 149);
	getContentPane().add(scrollPaneStates);
	
	
	select.setBounds(10, 171, 82, 27);
	getContentPane().add(select);
	
	
	cancel.setBounds(91, 171, 89, 27);
	getContentPane().add(cancel);
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
	private void populateJList() {
		StateListModel.clear();
		
		if (statesString != null){
			for (int i = 0; i < statesString.length; i++) {
				StateListModel.addElement((statesString[i]));
			}
		}
	}
	public JButton getStateButton(){
		return select;
	}
	public JList getStateList() {
		return stateList;
	}
	public String[] getStatesString(){
		return statesString;
	}
	public void addCancelListener(ActionListener listenForCancelButton ){
		cancel.addActionListener(listenForCancelButton);
	}
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getActionCommand().equals("Select State")) {
			System.out.println("TESATASTR");
		}
	}

	public void addCityToList(String string) {
		// TODO Auto-generated method stub
		
	}
}
