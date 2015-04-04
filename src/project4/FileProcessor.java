package project4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;


/**
 * Project #3
 * CS 2334, Section 010 
 * Mar 27, 2015
 * <P>
 * This class reads file, and makes it readable for a PersonList, which
 * will be returned after all of the values have been read.
 * </P>
 * 
 * @version 1.0
 */
public class FileProcessor {
	/** A private String to store the name of the file. */
	private String fileName;
	List<String> stateList;
	/** A private String to store the file of the players. */
	private String filePlayers;
	/** A private String to store the file of the teams. */
	private String fileTeams;
	/** A private String to store the file of the cities. */
	private String fileCities;
	
	/** A private PersonList that contains the created Person objects. */
	private PersonList aPersonList = new PersonList();
	/** A private TeamList that contains the created Person objects. */
	private TeamList aTeamList = new TeamList();
	
	/**
	 * A private List of Integers that contains the line numbers of lines in the
	 * file that have format errors.
	 */
	private List<Integer> errorList = new ArrayList<Integer>();

	/**
	 * A constructor that creates a FileProcessor object.
	 * 
	 * 
	 * @param fileName           The name of the file to be processed.
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE -					 the file that fileName describes must be able
	 *							 to be found.
	 *<dd>POST -
	 *</dl>
	 */
	public FileProcessor(String fileName) {
		this.fileName = fileName;
	}
	
	
	/**
	 * A constructor that creates a FileProcessor object.
	 * 
	 * 
	 * @param filePlayers         The file of the players to be processed.
	 * @param fileTeams           The file of the teams to be processed.
	 * @param fileCities          The file of the cities to be processed.
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE -					 the file that fileName describes must be able
	 *							 to be found.
	 *<dd>PRE - 				 the files must be inputed in the correct order.
	 *
	 *<dd>POST -
	 *</dl>
	 */
	public FileProcessor(String filePlayers, String fileTeams, String fileCities) {
		this.filePlayers = filePlayers;
		this.fileTeams = fileTeams;
		this.fileCities = fileCities;
	}
	
	/**
	 * 	processes the created file
	 * @throws 		IOException		If there is a problem with inputting the 
	 * 								data, an error will be thrown.
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public void processFile() throws IOException // processes the file, creates
													// a PersonList
	{
		 FileReader fr = new FileReader(fileName);
		 BufferedReader br = new BufferedReader(fr);
		 int i = 0;
		 while(br.ready()) //should check if the file has another line or not
		 {
			 String nextLine = br.readLine();
		
		 	//breaks the String into substrings at the commas, and create an
		 	//array
		 	String[] stringArray = nextLine.split(",");//should there be some
		 	//sort of throws?
		
		 	i++;


		 		
		 		aPersonList.addPerson(stringArray);

		 }
		 br.close();
	}




	
	/**
	 * 	processes the created files
	 * @throws 		IOException		If there is a problem with inputting the 
	 * 								data, an error will be thrown.
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public void processTeamMateFiles() throws IOException
	{
		 FileReader fr1 = new FileReader(this.fileCities);
		 BufferedReader br1 = new BufferedReader(fr1);
		 int j = 0;
		 while(br1.ready()) //should check if the file has another line or not
		 {
			 String nextLine = br1.readLine();
		
		 	//breaks the String into substrings at the commas, and create an
		 	//array
		 	String[] cityInfo = nextLine.split("; ");//should there be some
		 	//sort of throws?
		 	j++;
		 	try
		 	{
		 		City.findCity(cityInfo[0], cityInfo[1], Double.parseDouble(cityInfo[2]), Double.parseDouble(cityInfo[3]));
		 	}
		 	catch (Exception readError)
		 	{
		 		readError.printStackTrace();
		 		System.out.println("There is a problem in the data of the City file at line" + j);
		 	}
		 }
		 br1.close();
	
		 FileReader fr2 = new FileReader(this.filePlayers);
		 BufferedReader br2 = new BufferedReader(fr2);
		 int k = 0;
		 while(br2.ready()) //should check if the file has another line or not
		 {
			 String nextLine = br2.readLine();
		
		 	//breaks the String into substrings at the commas, and create an
		 	//array
		 	String[] stringArray = nextLine.split(",");//should there be some
		 	//sort of throws?
		 	k++;
		 	try
		 	{
		 		aPersonList.addPerson(stringArray);
		 	}
		 	catch (Exception readError)
		 	{
		 		readError.printStackTrace();
		 		System.out.println("There is a problem in the Player file at line" + k);
		 	}
		 }
		 
		 br2.close();
	
		 
		 FileReader fr3 = new FileReader(this.fileTeams);
		 BufferedReader br3 = new BufferedReader(fr3);
		 int l = 0;
		 while(br3.ready()) //should check if the file has another line or not
		 {
			 String nextLine = br3.readLine();
		
		 	//breaks the String into substrings at the commas, and create an
		 	//array
		 	String[] teamInfo = nextLine.split("; ");//should there be some
		 	//sort of throws?
		 	
		 	City teamCity = City.searchForCity(teamInfo[1], teamInfo[2]);
		 	
		 	PersonList rosterList = new PersonList();
		 	
		 	for(int i = 3 ; i < teamInfo.length ; i++)
		 	{
		 		try {
					Person searchedPerson = aPersonList.searchForPersonByExactName(teamInfo[i]);
					rosterList.addPerson(searchedPerson);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("There is a problem with " + teamInfo[i]);
				}
		 	}
		 	
		 	l++;
		 	try
		 	{
		 		aTeamList.addTeam(teamInfo[0], teamCity, rosterList);
		 	}
		 	catch (Exception readError)
		 	{
		 		readError.printStackTrace();
		 		System.out.println("There is a problem in the team file at line" + l);
		 	}
	 }
		 br3.close();
	
	}

	/**
	 * An accessor for the variable <code>aPersonList</code>.
	 * 
	 * @return 				aPersonList A list of all the Person objects created
	 */
	public PersonList getCreatedPersonList() {
		return aPersonList;
	}
	
	/**
	 * An accessor for the variable <code>errorList</code>.
	 * @return 		errorList 		A list of lines of file with format errors
	 */
	public List<Integer> getErrorList() {
		return errorList;
	}

	/**
	 * An accessor for the variable <code>aTeamList</code>.
	 * 
	 * @return 				aTeamList A list of all the Team objects created
	 */
	public TeamList getCreatedTeamList() {
		return aTeamList;
	}
}

