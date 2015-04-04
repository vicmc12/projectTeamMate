package project4;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;
/**
 * Project #4 
 * CS 2334, Section 010 
 * Mar 31, 2015
 * <P>
 * </P>
 * 
 * @version 1.0
 */
public class MainView extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4582672152738496131L;
	// The model for this view.
	private TeamMateModel model;
	/** MenuBar that contains menuFile and menuGraph. */
	private JLabel placeListTitle;
	private JLabel peopleListTitle;
	private JLabel teamsListTitle;
	private JMenuBar menuBar = new JMenuBar();
	/** Menu that contains loadDataItem, saveDataItem, importDataItem, exportDataItem. */
	private JMenu menuFile = new JMenu("File");
	/** Menu that contains graphItem and pieChartItem. */
	private JMenu menuGraph = new JMenu("Graph");
	/** menuItem that loads a file. */
	private JMenuItem loadDataItem = new JMenuItem("Load TeamMate Data");
	/** menuItem that save a file. */
	private JMenuItem saveDataItem = new JMenuItem("Save TeamMate Data");
	/** menuItem that imports a file. */
	private JMenuItem importDataItem = new JMenuItem("Import TeamMate Data");
	/** menuItem that exports a file. */
	private JMenuItem exportDataItem = new JMenuItem("Export TeamMate Data");
	/** menuItem that graphs in a map. */
	private JMenuItem graphItem = new JMenuItem("Graph");
	/** menuItem that graphs a pie chart. */
	private JMenuItem pieChartItem = new JMenuItem("Pie Chart");
	/** list that contains a list of places. */
	private DefaultListModel listModelPlaces = new DefaultListModel();
    private JList placesList=new JList(listModelPlaces);
    private JScrollPane scrollPanePlaces = new JScrollPane(placesList);
    /** list that contains a list of people. */
    private DefaultListModel listModelPeople = new DefaultListModel();
    private JList peopleList=new JList(listModelPeople);
    private JScrollPane scrollPanePeople = new JScrollPane(peopleList);
    private DefaultListModel listModelTeams = new DefaultListModel();
    /** list that contains a list of teams. */
    private JList teamsList=new JList(listModelTeams);
    private JScrollPane scrollPaneTeams = new JScrollPane(teamsList);
    /** Button to add a place to the place list. */
    private JButton addPlace = new JButton("Add");
    /** Button to edit a place in the place list. */
    private JButton editPlace = new JButton("Edit");
    /** Button to delete a place from the place list. */
    private JButton deletePlace = new JButton("delete");
    /** Button to add a person to the person list. */
    private JButton addPeople = new JButton("Add");
    /** Button to edit a person in the person list. */
    private JButton editPeople = new JButton("Edit");
    /** Button to delete a person from the person list. */
    private JButton deletePeople = new JButton("delete");
    /** Button to add a team to the team list. */
    private JButton addTeam = new JButton("Add");
    /** Button to edit a team in the team list. */
    private JButton editTeam = new JButton("Edit");
    /** Button to delete a team from the team list. */
    private JButton deleteTeam = new JButton("delete");
public MainView(){
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setBounds(100, 100, 617, 387);
	this.setTitle("TeamMate");
	this.setLayout(null);
	placeListTitle = new JLabel("Place List");
	peopleListTitle = new JLabel("People List");
	teamsListTitle = new JLabel("Teams List");
	
	

//	teamMatePanel.add(menuBar, BorderLayout.SOUTH);
//	teamMatePanel.add(placeListTitle);
//	teamMatePanel.add(peopleListTitle);
//	teamMatePanel.add(teamsListTitle);
//	
//	attributeLists();
//	teamMatePanel.add(placesList);
//	teamMatePanel.add(peopleList);
//	teamMatePanel.add(teamsList);
//	this.add(teamMatePanel);
	
	scrollPanePlaces.setBounds(42, 63, 144, 178);
	add(scrollPanePlaces);
	
	
	addPlace.setBounds(77, 252, 77, 23);
	add(addPlace);
	
	
	editPlace.setBounds(77, 275, 77, 23);
	add(editPlace);
	
	
	deletePlace.setBounds(77, 298, 77, 23);
	add(deletePlace);
	
	
	scrollPanePeople.setBounds(244, 63, 144, 178);
	add(scrollPanePeople);
	
	
	
	addPeople.setBounds(285, 252, 77, 23);
	add(addPeople);
	
	
	editPeople.setBounds(285, 275, 77, 23);
	add(editPeople);
	
	
	deletePeople.setBounds(285, 298, 77, 23);
	add(deletePeople);
	

	scrollPaneTeams.setBounds(430, 63, 144, 178);
	add(scrollPaneTeams);
	

	addTeam.setBounds(469, 252, 77, 23);
	add(addTeam);
	
	
	editTeam.setBounds(469, 275, 77, 23);
	add(editTeam);
	

	deleteTeam.setBounds(469, 298, 77, 23);
	add(deleteTeam);
	
	
	menuFile.add(loadDataItem);
	menuFile.add(saveDataItem);
	menuFile.add(importDataItem);
	menuFile.add(exportDataItem);
	menuGraph.add(graphItem);
	menuGraph.add(pieChartItem);
	menuBar.add(menuFile);
	menuBar.add(menuGraph);
	

	menuBar.setBounds(0, 0, 80, 23);
	add(menuBar);
	
	placeListTitle = new JLabel("Places");
	placeListTitle.setBounds(42, 41, 144, 23);
	add(placeListTitle);
	
    peopleListTitle = new JLabel("People");
	peopleListTitle.setBounds(244, 41, 144, 23);
	add(peopleListTitle);
	
	teamsListTitle = new JLabel("Teams");
	teamsListTitle.setBounds(430, 41, 144, 23);
	add(teamsListTitle);
	setVisible(true);

}


/**
 * This method sets the model for this view and registers the view as a listener with the model.
 * @param model  The model to be set.
 */
public void setModel(TeamMateModel model) {
	this.model = model;
	if (this.model != null) {
		model.addActionListener(this);
		// Register the view as listener for the model

	}
}

/**
 * This method pulls the names of the places from the state list and
 * stores them in the JList of selected places for detailed display.
 */
//public void populatePlaceList() {
//	listModelPlaces.clear();
//	if (model.getPlacesList() != null)
//		for (int i = 0; i < model.getPlacesList().size(); i++) {
//			listModelPlaces.addElement((model.getPlacesList().get(i)
//					.getPlaceName()));
//		}
//}
/**
 * This method pulls the names of the places from the state list and
 * stores them in the JList of selected places for detailed display.
 */
private void populatePlaceList() {
	listModelPlaces.clear();
	if (model.getCityList() != null)
		for (int i = 0; i < model.getCityList().size(); i++) {
			listModelPlaces.addElement((model.getCityList().get(i)
					.toString()));
		}
}
/**
 * This method pulls the names of the places from the state list and
 * stores them in the JList of selected places for detailed display.
 */
//public void populateTeamsList() {
//	listModelTeams.clear();
//	if (model.getTeamsList() != null)
//		for (int i = 0; i < model.getTeamsList().size(); i++) {
//			listModelTeams.addElement((model.getTeamsList().get(i)
//					.getTeamName()));
//		}
//}

/** 
 * listens for the load option
 * @param listenForLoadButton
 */
public void addLoadListener(ActionListener listenForLoadButton ){
	loadDataItem.addActionListener(listenForLoadButton);
}
/** 
 * listens for the save option
 * @param listenForSaveButton
 */
public void addSaveListener(ActionListener listenForSaveButton ){
	saveDataItem.addActionListener(listenForSaveButton);
}
/** 
 * listens for the import option
 * @param listenForImportButton
 */
public void addImportListener(ActionListener listenForImportButton ){
	importDataItem.addActionListener(listenForImportButton);
}
/** 
 * listens for the export option
 * @param listenForExportButton
 */
public void addExportListener(ActionListener listenForExportButton ){
	exportDataItem.addActionListener(listenForExportButton);
}
/** 
 * listens for the graph option
 * @param listenForGraphButton
 */
public void addGraphListener(ActionListener listenForGraphButton ){
	graphItem.addActionListener(listenForGraphButton);
}
/** 
 * listens for the add place button
 * @param listenForAddPlaceButton
 */
void addAddPlaceListener(ActionListener listenForAddPlaceButton ){
	addPlace.addActionListener(listenForAddPlaceButton);
}
/** 
 * listens for the edit place button
 * @param listenForEditPlaceButton
 */
public void addEditPlaceListener(ActionListener listenForEditPlaceButton ){
	editPlace.addActionListener(listenForEditPlaceButton);
}
/** 
 * listens for the delete place button
 * @param listenFordeletePlaceButton
 */
public void addDeletePlaceListener(ActionListener listenFordeletePlaceButton ){
	deletePlace.addActionListener(listenFordeletePlaceButton);
}
/** 
 * listens for the add people button
 * @param listenForAddPeopleButton
 */
public void addAddPeopleListener(ActionListener listenForAddPeopleButton ){
	addPeople.addActionListener(listenForAddPeopleButton);
}
/** 
 * listens for the edit people button
 * @param listenForEditPeopleButton
 */
public void addEditPeopleListener(ActionListener listenForEditPeopleButton ){
	editPeople.addActionListener(listenForEditPeopleButton);
}
/** 
 * listens for the delete people button
 * @param listenFordeletePeopleButton
 */
public void addDeletePeopleListener(ActionListener listenFordeletePeopleButton ){
	deletePeople.addActionListener(listenFordeletePeopleButton);
}
/** 
 * listens for the add team button
 * @param listenForAddTeamButton
 * 
 */
public void addAddTeamListener(ActionListener listenForAddTeamButton ){
	addTeam.addActionListener(listenForAddTeamButton);
}
/** 
 * listens for the edit team button
 * @param listenForEditTeamButtton
 */
public void addEditTeamListener(ActionListener listenForEditTeamButton ){
	editTeam.addActionListener(listenForEditTeamButton);
}
/** 
 * listens for the delete team button
 * @param listenFordeleteTeamButton
 */
public void addDeleteTeamListener(ActionListener listenFordeleteTeamButton ){
	deleteTeam.addActionListener(listenFordeleteTeamButton);
}


public void actionPerformed(ActionEvent actionEvent) {
	if (actionEvent.getActionCommand().equals("City Added")) {
		populatePlaceList();
	}
	if (actionEvent.getActionCommand().equals("Place Edited")) {
		populatePlaceList();
	}
	if (actionEvent.getActionCommand().equals("Place Deleted")) {
		populatePlaceList();
	}
}


public void addCityToList(String city) {
	listModelPlaces.addElement(city);
	
	
}
public JList getplacesList(){
	return placesList;
}


}
