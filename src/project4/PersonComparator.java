package project4;

import java.util.Comparator;
/**
 * Project #3 CS 2334, Section 010 
 * Mar 27, 2015
 * <P>
 * A PersonComparator is used to compare Person objects
 * </P>
 * 
 * @version 1.0
 */

public class PersonComparator implements Comparator<Person> {
	
	/**
	 * Default Constructor for PersonComparator
	 * 
	 * <dl>
	 * <dt><b>Conditions:</b>
	 * <dd>PRE - 
	 * <dd>POST -
	 * </dl> 
	 */
	public PersonComparator()
	{
		
	}

	/**
	 * This method finds compare two persons by first name
	 *
	 * @param 		person1 			object person
	 * @param 		person2 object person
	 * @return integer result
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - 
	 *<dd>POST- The returned list may be empty if there are no matches
	 *</dl>
	 */
	public int compare(Person person1, Person person2) {
		int compareValue = person1.getFirstName().compareToIgnoreCase(person2.getFirstName());
		if (compareValue != 0)
		{
			return compareValue;
		}
		else{
			compareValue = person1.getLastName().compareToIgnoreCase(person2.getLastName());
			if (compareValue != 0)
			{
				return compareValue;
			}
			else{
				compareValue = person1.getMiddleName().compareToIgnoreCase(person2.getMiddleName());
				return compareValue;
			}
		}
	}
}
