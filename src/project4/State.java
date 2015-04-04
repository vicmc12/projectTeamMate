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
 * A state has a name and a list of cities, and a static map of all other states
 * </P>
 * 
 * @version 1.0
 */
public class State implements Serializable{
	
	/** A private static final long to store the serial version.*/
	private static final long serialVersionUID = 827689313793600258L;
	/** A private List of Cities that contains the cities that are in the State*/
	private List<City> citiesInState;
	/** A private Map to store the states. */
	private static Map<String, State> mapOfStates = new HashMap<String,State>(); 
	/** A private String to store */
	private String stateName;

	/**
	 * A constructor for a state
	 * 
	 * @param 		name 		A String that contains the name of a state.
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE -
	 * <dd>POST -
	 * </dl> 
	 */
	private State(String name) {
		this.stateName = name;
		citiesInState = new ArrayList<City>();
	}
	
	/**
	 * This method finds the state from stateName. If the city does not already
	 * exist, it will create it before returning
	 *
	 * @param 		name		 	name of the state
	 * @return 					The found state
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public static State findState(String name) {
		State result = null;
		
		result = mapOfStates.get(name);
		if (result == null)
		{
			result = new State(name);
			mapOfStates.put(name, result);
		}
		
		return result;
	}

	
	/**
	 * An accessor for the variable <code>stateName</code>.
	 * 
	 * @return		 The name of the state.
	 */
	public String getStateName()
	{
		return stateName;
	}
	
	/**
	 * This method returns the searched state. It will NOT create a new state
	 * if the state is not found
	 *
	 * @param 		name		 	name of the state
	 * @return 					The state
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public static State searchForState(String name){
		State result = null;
		
		result = mapOfStates.get(name);
		return result;
	}
	
	/**
	 * 
	 * This method adds a city to the list of cities in the state.
	 * @param		 aCity		the City to be added
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public void addCity(City aCity)
	{
		citiesInState.add(aCity);
	}
	
	/**
	 * An accessor for the variable <code>citiesInState</code>.
	 * 
	 * @return		 The cities in the state.
	 */
	public List<City> getCitiesInState()
	{
		return citiesInState;
	}
}