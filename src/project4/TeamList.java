package project4;

//import java.util.ArrayList;
import java.util.LinkedHashMap;
//import java.util.List;
import java.util.Map;
import java.lang.String;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Project #3 
 * CS 2334, Section 010 
 * Mar 27, 2015
 * <P>
 * A team list contains multiple teams
 * </P>
 * 
 * @version 1.0
 */
public class TeamList implements Serializable{

	/** A private static final long to store the serial version.*/
	private static final long serialVersionUID = 7038729279561889424L;
	/** A private static Map to store all of the Teams. */
	private Map<String, Team> mapOfTeams = new LinkedHashMap<String,Team>(); 
	
	/**
	 * A constructor for a TeamList
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE - 
	 * <dd>POST -
	 * </dl> 
	 */
	public TeamList(){
		
	}
	
	/**
	 * Adds a new person to the list of people	
	 * @param 		teamName 	A String that contains the name of a team
	 * @param 		city 		A City that contains the city of a team
	 * @param 		roster 		A PersonList that contains the roster of a team
	 * 
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE-							
	 * 									
	 * <dd>POST-						
	 * 									
	 * 									
	 *</dl>
	 */
	public void addTeam(String teamName, City city, PersonList roster){
		
		Team team = new Team(teamName, city, roster);
		mapOfTeams.put(teamName, team);
	}
	
	/**
	 * Searches the list of team, returns the team if they are found,
	 * otherwise null. 
	 * 
	 * @param 		teamName	    The name of the team to be searched for
	 * @return 		searchedTeam 	The team with the searched name, or null
	 *  							if no team was found with that name.
	 *@throws		Exception		if there is not a name given, an exception is thrown
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - The name must be an exact match including punctuation,
	 *					ignoring case
	 *<dd>POST- A team exactly matching the inputed name will be
	 *   			      returned.
	 *</dl>
	 */
	public Team searchForTeam(String teamName) throws Exception{
		//List<Map.Entry<String, Team>> entries = new ArrayList<Map.Entry<>
		Team searchedTeam = null;
		
		for(Map.Entry<String, Team> entry : mapOfTeams.entrySet())
		{
			String key = entry.getKey();
			if (teamName.equalsIgnoreCase(key))
			{
				searchedTeam = mapOfTeams.get(key);
			}
		}
		return searchedTeam;	
	}
	
	/**
	 * Writes the TeamList object to a file.
	 * 
	 * @param 		filename 			the name of the file to be saved to
	 * @param 		teamList				the teamList object to be save
	 * 
	 * @exception	IOException			may be problems with writing file
	 */
	public static void writeTeamList(String filename, TeamList teamList) throws IOException
	{
		FileOutputStream fileOutputStream = new FileOutputStream(filename);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(teamList);
		objectOutputStream.close();
	}
	
	/**
	 * Reads a TeamList object from a file.
	 * 
	 * @param       filename				the file to be read
	 * 
	 * @return		teamList				the read teamList
	 * 
	 * @exception	IOException				may be problems with reading files
	 * @exception 	ClassNotFoundException  may be problems with reading files
	 */
	public static TeamList readTeamList(String filename) throws IOException, ClassNotFoundException
	{
		FileInputStream fileInputStream = new FileInputStream(filename);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		TeamList teamList = (TeamList) objectInputStream.readObject();
		objectInputStream.close();
		return teamList;
	}
}
