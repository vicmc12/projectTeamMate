package project4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

/**
 * Project #3 
 * CS 2334, Section 010 
 * March 27, 2015
 * <P>
 * A team has a name, a roster, a city and a state
 * </P>
 * 
 * @version 1.0
 */
public class Team implements Serializable {

	/** A private static final long to store the serial version.*/
	private static final long serialVersionUID = 4454844661439110782L;
	/** A private String to store the name of the team. */
	private String teamName;
	/** A private PersonList to store the team's roster. */
	private PersonList roster;
	/** A private City to store the team's city. */
	private City city;
	/** A private String to store the team's state. */
	private State state ;
	
	/**
	 * A constructor for a team
	 * 
	 * @param teamName
	 *            A String that contains the name of a team.
	 * @param city
	 *            A City that contains the team's city.
	 * @param roster
	 *            A PersonList that contains the team's roster.
	 * 
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE - 
	 * <dd>POST -
	 * </dl> 
	 */
	public Team(String teamName, City city, PersonList roster){
		this.teamName = teamName;
		this.city = city;
		this.roster = roster;
		this.state = city.getState();
	}
	
	/**
	 * An accessor for the variable <code>teamName</code>.
	 * 
	 * @return 				 The name of the team.
	 */
	public String getTeamName() {
		return teamName;
	}
	
	/**
	 * An accessor for the variable <code>roster</code>.
	 * 
	 * @return 				 The team's roster.
	 */
	public PersonList getRoster() {
		return roster;
	}
	
	/**
	 * An accessor for the variable <code>city</code>.
	 * 
	 * @return 				 The name of the city of the team.
	 */
	public City getCity() {
		return city;
	}
	
	/**
	 * An accessor for the variable <code>state</code>.
	 * 
	 * @return 				 The name of the state of the team.
	 */
	public State getState() {
		return state;
	}
//	public static Team findTeam(String teamName) throws Exception{//change exception type
//		Team result = null;
//		String key = null;
//		
//		if ( teamName == null)
//		{
//			throw new Exception("Team name is required");//change exception type
//		}
//		
//		key = teamName;
//		
//		result = mapOfTeams.get(key);
//		if ( result == null) 
//		{
//			result = new Team(cityName, stateName);
//			mapOfCities.put(key, result);
//		}
//		
//		return result;
//	}
	
	
	/**
	 * Writes the team object to a file
	 * 
	 * @param 		filename 			the name of the file to be saved to
	 * @param 		team				the team object to be save
	 * 
	 * @exception	IOException			may be problems with writing files
	 */
	public static void writeTeam(String filename, Team team) throws IOException
	{
		FileOutputStream fileOutputStream = new FileOutputStream(filename);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(team);
		objectOutputStream.close();
	}
	
	/**
	 * Reads a team object from a file
	 * 
	 * @param       filename				the file to be read
	 * 
	 * @return      team					the read team object
	 * 
	 * @exception	IOException				may be problems with reading files
	 * @exception 	ClassNotFoundException  may be problems with reading files
	 */
	public static Team readTeam(String filename) throws IOException, ClassNotFoundException
	{
		FileInputStream fileInputStream = new FileInputStream(filename);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Team team = (Team) objectInputStream.readObject();
		objectInputStream.close();
		return team;
	}
}