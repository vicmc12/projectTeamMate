package project4;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
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
public class TeamMateModel {
	/** Register an action event listener */
	private ArrayList<ActionListener> actionListenerList;
	private PersonList listOfPersons;
	private String selectedState = null;
	private String[] stateList;
	private String selectedPlaceState = null;
	private City city;
	protected List<City> cities = new ArrayList<City>();
    private City selectedPlace;
	private int indexSelectedPlace;

	public synchronized void addActionListener(ActionListener l) {
		System.out.println("Test1");
		if (actionListenerList == null) {
			actionListenerList = new ArrayList<ActionListener>();
		}
		actionListenerList.add(l);
	}

	/** Remove an action event listener */
	public synchronized void removeActionListener(ActionListener l) {
		if (actionListenerList != null && actionListenerList.contains(l)) {
			actionListenerList.remove(l);
		}
	}

	/** Fire Event */
	private void processEvent(ActionEvent e) {
		System.out.println("Test");
		ArrayList<ActionListener> list;
		synchronized (this) {
			if (actionListenerList == null)
				return;
			// Do not worry about the cast warning here.
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}
		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	}
	/**
	 * 
	 */
	public void addPerson(Person person){
		
	}
	/**
	 * 
	 */
	public void editPerson(Person person){
		
	}
	/**
	 * 
	 */
	public void addToSelectedList(int index) {
		selectedState =stateList[index];
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Select State"));
		System.out.println(selectedState);
		// Notify the listener of the change in subList

	}
	public void addToPlaceList(int index) {
		selectedPlaceState =stateList[index];
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Select State"));
		System.out.println(selectedState);
		// Notify the listener of the change in subList

	}
	public void deletePerson(Person person){
		
	}
	/**
	 * 
	 */
	public void addTeam(Team team){
    	
    }
	/**
	 * 
	 */
	public void editTeam(Team team){
		
	}
	/**
	 * 
	 */
	public void deleteTeam(Team team){
		
	}
	/**
	 * 
	 */
	public void addPlace(State state, City city){
		
	}
	/**
	 * 
	 */
	public void editPlace(State state, City city){
		
	}
	/**
	 * 
	 */
	public void deletePlace(State state, City city){
		
	}
	/**
	 * 
	 */
	public void loadData(String fileName){
		
	}
	/**
	 * 
	 */
	public void loadData(String fileTeam,String fileCity, String filePlayers){
		
	}
	/**
	 * 
	 */
	public void saveData(String fileName){
		
	}
	/**
	 * 
	 */
	public void saveData(String fileTeam,String fileCity, String filePlayers){
		
	}
	/**
	 * 
	 */
	public void exportData(String fileTeam,String fileCity, String filePlayers){
		
	}
	/**
	 * 
	 */
	public void exportData(String fileName){
		
	}
	/**
	 * 
	 */
	public void importData(String fileName){
		
	}
	/**
	 * 
	 */
	public void graphPieChart(){
		
	}
	/**
	 * 
	 */
	public void graphMap(){
		
	}
	public String getState(){
		return selectedState;
		
	}
	
	public PersonList getPeopleList(){
		
		return listOfPersons;
	}
	public TeamList getTeamsList(){
		return null;
		
	}
	public void setPlacesList(){
		
		
	}
	
	public void setPeopleList(PersonList listOfPersons){
		
		this.listOfPersons = listOfPersons;

		
	}
	public void setTeamsList(){
		
		
	}
	public String getSelectedStateList() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setStateList(String[]stateList){
		this.stateList = stateList;
	}
	

	public void addCityToList(String cityName, Double latitude, Double longitude) {
		
		
		
		
		try {
			city = new City(cityName, selectedState, latitude, longitude);
		} catch (Exception e) {
			System.out.println("error 404");
		}
		try {
			System.out.println(cityName + " "+selectedState +" " +latitude +" "+ longitude);
			cities.add(city);
		} catch (Exception e) {
			System.out.println("error 405");
		}
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "City Added"));

	}

	public List<City> getCityList() {
		// TODO Auto-generated method stub
		return cities;
	}

	public void selectedPlace(int index) {
		selectedPlace = cities.get(index);
		indexSelectedPlace = index;
		
	}
	public void editSelectedPlace(String editedTeamName, Double editedLatitude, Double editedLongitude){
		System.out.println("State: "+selectedPlaceState);
		City editedCity = new City(editedTeamName, selectedPlaceState, editedLatitude, editedLongitude);
		cities.remove(indexSelectedPlace);
		cities.add(indexSelectedPlace, editedCity);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Place Edited"));
	}
	public String getSelectedPlaceState(){
		selectedPlaceState = selectedPlace.getStateName();
		return selectedPlace.getStateName();
	}

	public void deletePlace(int index) {
		cities.remove(index);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Place Deleted"));
		
	}

}
