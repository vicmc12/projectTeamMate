package project4;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * A person has first, middle, and last names, a birth date, a birth city,
 * and a birth state
 * </P>
 * 
 * @version 1.0
 */

public class Person implements Comparable<Person>, Serializable {

	/** A private static final long to store the serial version.*/
	private static final long serialVersionUID = 2614134590565380129L;
	/** A private String to store the first name of the person. */
	private String firstName;
	/** A private String to store the middle name(s) of the person. */
	private String middleName;
	/** A private String to store the last name of the person. */
	private String lastName;
	/** A private String to store the full name of the person. */
	private String fullName;
	/** A private String to store the name of the person's birth city. */
	private String cityName;
	/** A private City to store the birth city of the person. */
	private City birthCity;
	/** A private String to store the name of the person's birth state. */
	private String stateName;
	/** A private int to store the person's age. */
	private int age;
	/** A private String to store the birth date of the person*/
	private String birthDateString;
	/** A private Calendar to store the birth date of the person. */
	private Calendar birthDate;
	/** A private String to store the death date of the person*/
	private String deathDateString;
	/** A private Calendar to store the death date of the person. */
	private Calendar deathDate;
	/**
	 * A private SimpleDateFormat to parse the date Strings and convert them to
	 * Dates
	 */
	private SimpleDateFormat formatter;

	/**
	 * A constructor for a person
	 * 
	 * @param 		characteristics			An array of Strings that contain 
	 * 										information about the person.
	 * @exception 	Exception	            Thrown if their are an improper 
	 * 										number of arguments for the number 
	 * 										of traits
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - The String[] passed in contains 4 Strings.
	 *<dd>POST -
	 *</dl>
	 */
	public Person(String[] characteristics) throws ParseException, Exception {
		
		 if (characteristics.length < 4 || characteristics.length > 5) {
		 throw new Exception("Invalid number of arguments");
		 }
		
		String name = characteristics[0];
		this.fullName = name.trim();
		String[] names = fullName.split(" ");
		this.firstName = names[0];
		this.lastName = names[names.length - 1];
		this.middleName = "";
		if (names.length>2)
		{
			for (int i = 1; i > names.length - 1; i++){
				this.middleName += names[i] + " ";
			}
		}
		
		this.birthDateString = characteristics[1];
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		 birthDate = new GregorianCalendar();
		 Date birth = formatter.parse(characteristics[1]);
		 this.birthDate.setTime(birth);
		
		this.cityName = characteristics[2];
		this.stateName = characteristics[3];
		if(cityName.equalsIgnoreCase("AcityNamePlaceHolderForSearches") && 
				stateName.equalsIgnoreCase("AstateNamePlaceHolderForSearches"))
		{
			//This branch should only be entered as a result of searching for
			//a person in the PersonList class. It is to prevent the error message
			//for not finding a city to be presented, because in a search fake 
			//cities are created but they do not matter.If for some reason this is the
			//actual name of a city or state combination, the code should work
			//anyway. If it does not exist but a Person with those values is create,
			//the user will not be notified.
			try{
				this.birthCity = City.searchForCity(this.cityName, this.stateName);		
				this.birthCity.addPerson(this);
			} catch (Exception e)
			{
				//This exception isn't actually a problem, just a result of searching
			}
		}
		else{	
			try{
				this.birthCity = City.searchForCity(this.cityName, this.stateName);		
				this.birthCity.addPerson(this);
			} catch (Exception e)
			{
				System.out.println("There is a problem asociating " + fullName + " with " 
					+"their birthCity. \n"+ fullName + " may not be included on any maps.");
			}
		}	
		
			if(characteristics.length==5){
			this.deathDateString = characteristics[4];
			deathDate = new GregorianCalendar();
			Date death = formatter.parse(characteristics[4]);
			this.deathDate.setTime(death);
		}
		this.age = calculateAge();
	}

	public Person(String name, Calendar birthDate, City birthCity)
	{
		this.fullName = name.trim();
		String[] names = fullName.split(" ");
		this.firstName = names[0];
		this.lastName = names[names.length - 1];
		this.middleName = "";
		if (names.length>2)
		{
			for (int i = 1; i > names.length - 1; i++){
				this.middleName += names[i] + " ";
			}
		}
		
		this.birthDate = birthDate;
		this.birthDateString = "";//TODO: conversion
		this.birthCity = birthCity;
		this.cityName = birthCity.getName();
		this.stateName = birthCity.getState().getStateName();
		
		try
		{
			this.age = calculateAge();
		} catch(Exception ageException)//TODO: Change exception type
		{
			//TODO: the birthdate is after the present date, do something
		}
		
	}
	
	public Person(String name, Calendar birthDate, City birthCity, Calendar deathDate)
	{
		this.fullName = name.trim();
		String[] names = fullName.split(" ");
		this.firstName = names[0];
		this.lastName = names[names.length - 1];
		this.middleName = "";
		if (names.length>2)
		{
			for (int i = 1; i > names.length - 1; i++){
				this.middleName += names[i] + " ";
			}
		}
		
		this.birthDate = birthDate;
		this.birthDateString = birthDate.get(Calendar.DATE) + "/" + birthDate.get(Calendar.MONTH)
				+ "/" + birthDate.get(Calendar.YEAR); 
		this.birthCity = birthCity;
		this.cityName = birthCity.getName();
		this.stateName = birthCity.getState().getStateName();
		this.deathDate = deathDate;
		this.deathDateString = deathDate.get(Calendar.DATE) + "/" + deathDate.get(Calendar.MONTH)
				+ "/" + deathDate.get(Calendar.YEAR);
		try
		{
			this.age = calculateAge();
		} catch(Exception ageException)//TODO: Change exception type
		{
			//TODO: the birth date is after the death date, do something
		}
	}
	
	/**
	 * An accessor for the variable <code>firstName</code>.
	 * 
	 * @return		 The first name of the person.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * An accessor for the variable <code>middleName</code>.
	 * 
	 * @return 		 The middle name of the person.
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * An accessor for the variable <code>lastName</code>.
	 * 
	 * @return 		 The last name of the person.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * An accessor for the variable <code>fullName</code>.
	 * 
	 * @return 		 The last name of the person.
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * An accessor for the variable <code>birthDate</code>.
	 * 
	 * @return		 The birth date of the person.
	 */
	public Calendar getBirthDate() {
		return birthDate;
	}

	/**
	 * An accessor for the variable <code>birthCity</code>.
	 * 
	 * @return 		The city the person was born in.
	 */
	public City getBirthCity() {
		return birthCity;
	}

	/**
	 * An accessor for the variable <code>state</code>.
	 * 
	 * @return state The state the person was born in
	 */
	public State getBirthState() {
		return birthCity.getState();
	}

	/**
	 *Compares to another person by name, with the last name taking precedence,
	 *returns a negative value if the person this method is called on precedes
	 *the other person, a positive value if the person this method is called on
	 *comes after the other person, and 0 if the people are the same.
	 *
	 * @see Comparable#compareTo(Object)
	 *
	 *@return  		the value found by comparing the people
	 */
	public int compareTo(Person otherPerson) {
		int compareValue = lastName.compareToIgnoreCase(otherPerson.getLastName());
		if (compareValue != 0)
		{
			return compareValue;
		}
		else{
			compareValue = firstName.compareToIgnoreCase(otherPerson.getFirstName());
			if (compareValue != 0)
			{
				return compareValue;
			}
			else{
				compareValue = middleName.compareToIgnoreCase(otherPerson.getMiddleName());
				return compareValue;
			}
		}
	}
	
	/**
	 * This method returns the attributes of this class as a single string.
	 * 
	 * @return String representing the contents of this object.
	 */
	public String toString()
	{
		String personInfo = fullName + "," + birthDateString + "," + cityName +","+ stateName;
		if (deathDateString != null)
		{
			personInfo += "," + deathDateString;
		}
		return personInfo;
	}

	/**
	 * If the person is dead it returns a date, else null
	 * 
	 * @return deathDate 		A Calendar of the date of death
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST- 				Returns true if the person has died, null if not
	 *</dl>
	 */
	public Calendar getDeathDate()
	{
		return deathDate;
	}
	
	/**
	 * Checks if the person has died by checking the value of the deathDate 
	 * variable,if the value is null it returns false, otherwise it returns true
	 * 
	 * @return 		deathStatus A boolean of if the person is dead or not. 
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE-
	 * <dd>POST-				The death status of the Person is calculated
	 * </dl>
	 */
	public boolean isDead()//checks if there is a death date, yes=dead, no=not
	{
		return (deathDate!= null);
	}
	
	/**
	 * Checks if the person is alive or dead, if the person is alive the 
	 * current age is returned, if the person is dead it returns the age at death
	 * 
	 * @return 		age			the age of the person	
	 * 
	 * @exception	Exception	An Exception is thrown if the date of birth is
	 * 							after the current date or the date of death.
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE - 				Dates and times are in GMT. Otherwise age 
	 * 							calculations may be off by one day.
	 * <dd>PRE - 				The birth date must be before the current date
	 * 							and death date
	 * <dd>POST - 				The age of the person is calculated.
	 * </dl>
	 */
	public int calculateAge()  throws Exception
	{
		int age;
		Calendar endDate = isDead()? deathDate : Calendar.getInstance();
		if (endDate.before(birthDate))
		{
			throw new Exception("There is a person of that name, but the dates"//TODO: change Exception type
					+ " are incorrectly entered, calling into question the "
					+ "accuracy of the entire entry.");
		}
		
		age = (endDate.get(Calendar.YEAR)- birthDate.get(Calendar.YEAR));
		if(endDate.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH))
		{
			age--;
		}
		else
		{
			if(endDate.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH) && 
				endDate.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH))
			{			
				age --;	
			}
		}
		return age;
	}
	
	/**
	 * An accessor for the variable <code>age</code>.
	 * 
	 * @return 	state 					The age of the person
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * Writes the Person object to a file.
	 * 
	 * @param 		filename 			the name of the file to be saved to
	 * @param 		person				the Person object to be save
	 * 
	 * @exception	IOException			there may be a problem with writing the file
	 */
	public static void writePerson(String filename, Person person) throws IOException
	{
		FileOutputStream fileOutputStream = new FileOutputStream(filename);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(person);
		objectOutputStream.close();
	}
	
	/**
	 * Reads a person object from a file
	 * 
	 * @param       filename			the file to be read
	 * 
	 * @return		person				the read Person
	 * 
	 * @exception	IOException				there may be a problem with reading the file
	 * @exception 	ClassNotFoundException	there may be a problem with reading the file
	 */
	public static Person readPerson(String filename) throws IOException, ClassNotFoundException
	{
		FileInputStream fileInputStream = new FileInputStream(filename);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Person person = (Person) objectInputStream.readObject();
		objectInputStream.close();
		return person;
	}
}
