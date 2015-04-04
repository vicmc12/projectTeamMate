package project4;

import java.util.List;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

/**
 * Project #3 
 * CS 2334, Section 010 
 * Mar 27, 2015
 * <P>
 * A city has a name, people that belong to the city, a state,  
 * and a static map of other cities that belong to the state .
 * </P>
 * 
 * @version 1.0
 */
public class City implements Serializable {

	/** A private static final long to store the serial version.*/
	private static final long serialVersionUID = 1525932746067327192L;
	/** A private State to store the state to which the city belongs. */
	private State state;
	/** A private static Map to store all of the cities that belong to a state. */
	private static Map<String,City> mapOfCities = new HashMap<String,City>(); 
	/** A private String to store the name of the city.*/
	private String cityName;
	/** A private List of Person objects to store the people born in the city.*/
	private List<Person> cityPeople;
	/** A private double to store the latitude of the city.*/
	private double latitude;
	/** A private double to store the longitude of the city.*/
	private double longitude;

	/**
	 * A constructor for a city
	 * 
	 * @param cityName				A String that contains the name of a city.
	 * 
	 * @param stateName				A String that contains the name of a state  
	 * 								of the city.	
	 * @param latitude				A double that contains the latitude of the 
	 * 								city
	 * @param longitude				A double that contains the longitude of the
	 * 								city
	 * 
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE - 
	 * <dd>POST -
	 * </dl> 
	 */
	City(String cityName, String stateName, double latitude, double longitude) {
		this.cityName = cityName;
		cityPeople = new ArrayList<Person>();
		this.state = State.findState(stateName);
		state.addCity(this);
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * An accessor for the variable <code>cityName</code>.
	 * 
	 * @return 				 The name of the city
	 */
	public String getName()
	{
		return cityName;
	}

	/**
	 * An accessor for the variable <code>stateName</code>.
	 * 
	 * @return 				 The name of the state the city belongs.
	 */
	public State getState() {
		return state;
	}
	public String getStateName() {
		return state.getStateName();
	}
	
	/**
	 * This method finds the city, or creates one if one was not found.
	 *
	 * @param 		cityName		The name of the city
	 * @param 		stateName		The name of the state
	 * @param		latitude		The latitude of the city
	 * @param 		longitude		The longitude of the city
	 *
	 * @return 				The city that has been found on the map of cities
	 * @throws      Exception        Throws an exception if a name is not given
	 * <dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-	
	 *</dl>	
	 */
	public static City findCity(String cityName, String stateName, double latitude, double longitude) throws Exception{//change exception type
		City result = null;
		String key = null;
		
		if ( cityName == null || stateName == null)
		{
			throw new Exception("State and City names are required");//change exception type
		}
		
		key = cityName + "_" + stateName;
		
		result = mapOfCities.get(key);
		if ( result == null) 
		{
			result = new City(cityName, stateName, latitude, longitude);
			mapOfCities.put(key, result);
		}
		
		return result;
	}
	
	/**
	 * This method returns the searched city. It will NOT create a new city
	 * if the city is not found
	 *
	 * @param		cityName		name of the city
	 * @param 		stateName		 	name of the state
	 * @return 					The city
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public static City searchForCity(String cityName, String stateName)
	{
		City result = null;
		String key = null;
		
		key = cityName + "_" + stateName;
		result = mapOfCities.get(key);
		return result;
	}
	
	/**
	 * This method adds a person the the list of people.
	 * 
	 * @param		 aPerson 		the person to be added to the list
	 */
	public void addPerson(Person aPerson){
		cityPeople.add(aPerson);
	}

	/**
	 * This method returns all the people that were born in this city
	 * 
	 * @return       a list of the people born in the city
	 * <dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST- 
	 *</dl>
	 */
	public List<Person> getPeopleBornInCity(){
		return cityPeople;
	}
	
	/**
	 * An accessor for the variable <code>latitude</code>.
	 * 
	 * @return		 The latitude of the city.
	 */
	public double getLatitude()
	{
		return latitude;
	}
	
	/**
	 * An accessor for the variable <code>longitude</code>.
	 * 
	 * @return		 The longitude of the city.
	 */
	public double getLongitude()
	{
		return longitude;
	}
	
	/**
	 * This method returns the attributes of this class as a single string.
	 * 
	 * @return String representing the contents of this object.
	 */
	public String toString()
	{
		
		return (cityName + ", "+ state.getStateName());
	}

}
