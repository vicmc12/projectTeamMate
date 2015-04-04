package project4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

/**
 * Project #4 
 * CS 2334, Section 010 
 * Mar 31, 2015
 * <P>
 * </P>
 * 
 * @version 1.0
 */
public class AddPersonView extends JFrame implements ActionListener {


	//TODO: Javadoc comments
	
	private TeamMateModel model;
	
	private static final long serialVersionUID = -7963248643895827608L;
	private JTextField textFieldName;
	private JTextField textFieldBirthDate;
	private JTextField textFieldDeathDate;
	private JLabel lblEnterThePersons;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JList<String> stateList;
	private JScrollPane scrollPane;
	private JLabel lblcity;
	private JButton btnSelect;
	private JLabel lblBirthDate;
	private JLabel lblDeathDate;
	private JButton btnAddPerson;
	private JButton btnCancel;
	private JLabel lblMessageArea;
	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");;
	

	/**
	 * Initialize the contents of the frame.
	 */
	public AddPersonView() {
		setTitle("Add Person");
		setBounds(100, 100, 450, 478);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(72, 42, 171, 22);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		lblEnterThePersons = new JLabel("Enter the person's information.");
		lblEnterThePersons.setBounds(12, 13, 184, 16);
		getContentPane().add(lblEnterThePersons);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(22, 42, 38, 16);
		getContentPane().add(lblName);
		
		lblNewLabel = new JLabel("Select a state then a city.");
		lblNewLabel.setBounds(12, 77, 156, 16);
		getContentPane().add(lblNewLabel);
		
		stateList = new JList<String>();//TODO: add state names
		scrollPane = new JScrollPane(stateList);
		scrollPane.setBounds(12, 106, 156, 65);
		getContentPane().add(scrollPane);
		
		lblcity = new JLabel("(City)");
		lblcity.setBounds(12, 178, 56, 16);
		getContentPane().add(lblcity);
		
		btnSelect = new JButton("Select");
		btnSelect.setBounds(180, 127, 97, 25);
		getContentPane().add(btnSelect);
		
		lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setBounds(12, 227, 69, 16);
		getContentPane().add(lblBirthDate);
		
		textFieldBirthDate = new JTextField();//TODO: replace with JDatePicker or something
		textFieldBirthDate.setBounds(161, 224, 116, 22);
		getContentPane().add(textFieldBirthDate);
		textFieldBirthDate.setColumns(10);
		
		lblDeathDate = new JLabel("Death Date: (optional)");
		lblDeathDate.setBounds(12, 256, 127, 16);
		getContentPane().add(lblDeathDate);
		
		textFieldDeathDate = new JTextField();//TODO: replace with JDatePicker
		textFieldDeathDate.setColumns(10);
		textFieldDeathDate.setBounds(161, 253, 116, 22);
		getContentPane().add(textFieldDeathDate);
		
		btnAddPerson = new JButton("Add Person");
		btnAddPerson.setBounds(72, 303, 97, 25);
		getContentPane().add(btnAddPerson);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(241, 303, 97, 25);
		getContentPane().add(btnCancel);
		
		lblMessageArea = new JLabel("(Message Area)");
		lblMessageArea.setBounds(161, 353, 116, 16);
		getContentPane().add(lblMessageArea);
		setVisible(true);
		
	}

	public String getPersonName()
	{
		return textFieldName.getText();
	}
	
	public Calendar getBirthDate()
	{
		String birthDateText = textFieldBirthDate.getText();
		Calendar birthDate = new GregorianCalendar();
		Date birth;
		try {
			birth = formatter.parse(birthDateText);
			birthDate.setTime(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// If the date can't be formatted, the user needs to be notified
			e.printStackTrace();
		}
		 
		return birthDate;
	}
	
	public Calendar getDeathDate()
	{
		String deathDateText = textFieldDeathDate.getText();
		if (deathDateText == null)
		{
			return null;
		}
		//TODO: parse into Calendar
		Calendar deathDate = new GregorianCalendar();
		Date death;
		try {
			death = formatter.parse(deathDateText);
			deathDate.setTime(death);
		} catch(ParseException e){
			// TODO Auto-generated catch block
			// If the date can't be formatted, the user needs to be notified
			e.printStackTrace();
		}
		
		return deathDate;
	}
	
	public City getBirthCity()
	{
		//TODO: somehow, the City from the City selection view needs to be returned so that the
		//			Controller can make a Person
		// I think it will involve the AddPersonSelectListener class of the Controller
	}
	
	//TODO: Javadoc
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//TODO:Javadoc
	public void addSelectListener(ActionListener listenSelectButton)
	{
		btnSelect.addActionListener(listenSelectButton);
	}
	
	//TODO: Javadoc
	public void addAddPersonListener(ActionListener listenAddPersonButton)
	{
		btnAddPerson.addActionListener(listenAddPersonButton);
	}
	
	//TODO: Javadoc
	public void addCancelListener(ActionListener listenCancelButton)
	{
		btnCancel.addActionListener(listenCancelButton);
	}
	
	public void setModel(TeamMateModel model)
	{
		/** Set a model */
		this.model = model;
		if (this.model != null){
			model.addActionListener(this);
			// Register the view as listener for the model

		}
	}
}
