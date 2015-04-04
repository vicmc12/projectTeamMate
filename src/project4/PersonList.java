package project4;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//import project2.Person;

/**
 * Project #3 
 * CS 2334, Section 010 
 * Mar 27, 2015
 * <P>
 * A list of people, it can add people to the list and search for them by name
 * </P>
 * 
 * @version 1.0
 */
public class PersonList implements Serializable{

	/** A private static final long to store the serial version.*/
	private static final long serialVersionUID = -6198559225184284762L;
	/** A private List of Persons that stores all of the Person objects */
	private List<Person> listOfPersons=null;

	/**
	 * Default Constructor for PersonList
	 * 
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE - 
	 * <dd>POST -
	 * </dl> 
	 */
	public PersonList() {
		listOfPersons = new ArrayList<Person>();
	}
	
	/**
	 * A constructor for PersonList
	 * 
	 * @param 		existingList			A List of Person to create the 
	 * 										PersonList from
	 *
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - 
	 *<dd>POST -
	 *</dl>
	 */
	public PersonList(List<Person> existingList)
	{
		this.listOfPersons = existingList;
	}
	
	
	/**
	 * Adds a new person to the list of people	
	 * @param 		characteristics 	An array of Strings
	 * @exception  	Exception			characteristics must have the correct
	 * 									number of elements.
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE-							characteristics must be in the proper 
	 * 									format for a Person object
	 * <dd>POST-						Correctly formatted strings will result
	 * 									in Person object being added with the 
	 * 									information of the String array
	 *</dl>
	 */
	public void addPerson(String[] characteristics) 
	{
		Person addedPerson = null;
		try {
			addedPerson = new Person(characteristics);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error personListAddPerson1");
		}
		try {
			listOfPersons.add(addedPerson);
			System.out.println(listOfPersons.size());
		} catch (Exception e) {
			System.out.println("error personListAddPerson2");
		}

	}
	
	/**
	 * Adds a new person to the list of people	
	 * @param 		actualPerson	 	A Person to add to the list.
	 *
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE-							
	 * 									
	 * <dd>POST-						
	 * 	
	 *</dl>
	 */
	public void addPerson(Person actualPerson)
	{
		
		listOfPersons.add(actualPerson);
	}

	//TODO: Javadoc
	public void addPerson(String name, Calendar birthDate, City birthCity)
	{
		Person aPerson = new Person(name, birthDate, birthCity);
		listOfPersons.add(aPerson);
	}
	
	//TODO: Javadoc
	public void addPerson(String name, Calendar birthDate, City birthCity, Calendar deathDate)
	{
		Person aPerson = new Person(name, birthDate, birthCity, deathDate);
		listOfPersons.add(aPerson);
	}
	
	/**
	 * Searches the list of people, returns the person if they are found,
	 * otherwise null. If two people exactly match, the last person that 
	 * matches will be returned.
	 * 
	 * @param 		name			The name of the person to be searched for
	 * @return 		searchedPerson 	The person with the searched name, or null
	 *  							if no person was found with that name.
	 *@throws		Exception		if there is not a name given, an exception is thrown
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - The name must be an exact match including punctuation,
	 *					ignoring case
	 *<dd>POST- A person exactly matching the inputed name will be
	 *   			      returned.
	 *</dl>
	 */
	public Person searchForPersonByExactName(String name)  throws Exception {//replace with binary search
		List<Person> sortedList = listOfPersons;
		Person searchedPerson = null;
		PersonComparator persComp = new PersonComparator();
		Collections.sort(sortedList, persComp);
		String[] characteristics = new String[4];
		characteristics[0] = name;
		characteristics[1] = "1/1/2001";//date is unimportant for comparisons
		characteristics[2] = "AcityNamePlaceHolderForSearches";//city is unimportant for comparisons
		characteristics[3] = "AstateNamePlaceHolderForSearches";//state is unimportant for comparisons
		
		Person key = new Person(characteristics);
		
		int index = Collections.binarySearch(sortedList, key, persComp);
		if (index >= 0)
		{
			searchedPerson = sortedList.get(index);
		}
	
		return searchedPerson;
	}

	/**
	 * Searches the list of people, returns the person if they are found,
	 * otherwise null
	 * 
	 * @param			name		The name of the person to be searched for
	 * @return		 searchedPerson The person with the searched name, or null
	 *  							if no person was found with that name.
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - 
	 *<dd>POST- The returned list may be empty if there are no matches
	 *</dl>
	 */
	public List<Person> searchForPersonByPartialName(String name) {
		List<Person> searchedPeople = new ArrayList<Person>();
		
		for(Person comparedPerson: listOfPersons)
		{
			String fullName = comparedPerson.getFullName().toLowerCase();
			String searchedName = name.toLowerCase();
			if (fullName.contains(searchedName))
			{
				searchedPeople.add(comparedPerson);
			}
		}
		return searchedPeople;
	}
	
	/**
	 *this method sorts listOfPersons by first name
	 *@return listOfPersons sorted listOfPersons
	 */
	public List<Person> sortByFirstName() {
		List<Person> sortedList = listOfPersons;
		Collections.sort(sortedList, new PersonComparator());
		return sortedList;
	}

	/**
	 * this method sorts listOfPersons by last name
	 *@return listOfPersons sorted listOfPersons
	 */
	public List<Person> sortByLastName() {
		List<Person> sortedList = listOfPersons;
		Collections.sort(sortedList);
		return sortedList;
	}
	
	/**
	 * Searches for the city and state, then returns a list of the people
	 * belonging to the city
	 * 
	 * @param 			cityName     The name of the city the people belong to
	 * @param			stateName	 The name of the state the people belong to
	 *            
	 * @return 			peopleInCity  A List of the person objects that belong
	 * 									to the city and state
	 *
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - 
	 *<dd>POST- The returned list may be empty if there are no matches
	 *</dl>
	 */
	public List<Person> searchPeopleByCity(String cityName, String stateName){
		City searchedCity = City.searchForCity(cityName, stateName);
		List<Person> peopleInCity = null;
		if (searchedCity != null)
		{
			peopleInCity = searchedCity.getPeopleBornInCity();
		}
		return peopleInCity;		
	}
	
	public List<Person> getListOfPersons()
	{
		
		return listOfPersons;
		
	}
	
	/**
	 * Writes the PersonList object to a file
	 * 
	 * @param 		filename 			the name of the file to be saved to
	 * @param 		personList			the team object to be save
	 * 
	 * @exception	IOException			may be problems with writing files
	 */
	public static void writePersonList(String filename, PersonList personList) throws IOException
	{
		FileOutputStream fileOutputStream = new FileOutputStream(filename);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(personList);
		objectOutputStream.close();
	}
	
	/**
	 * Reads a PersonList object from a file
	 * 
	 * @param       filename					the file to be read
	 * 
	 * @return		personList					the read PersonList
	 * 
	 * @exception	IOException					may be problems with reading files
	 * @exception 	ClassNotFoundException		may be problems with reading files
	 */
	public static PersonList readPersonList(String filename) throws IOException, ClassNotFoundException
	{
		FileInputStream fileInputStream = new FileInputStream(filename);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		PersonList personList = (PersonList) objectInputStream.readObject();
		objectInputStream.close();
		return personList;
	}
	
}