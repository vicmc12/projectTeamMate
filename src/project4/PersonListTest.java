package project4;



import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import  org.junit.*;

public class PersonListTest  {

	
		
	//Cannot test on own, so functions are tested in testSearchForPersonByName() method
//	@Test
//	public void testAddPerson() {	
//	}
	
	/**
	 *  Tests if the addPerson() and searchForPersonByName() methods are functioning.
	 */
	@Test
	public void testSearchForPersonByName()
	{
		PersonList aList = new PersonList();
		//The traits of the people to be created
		String[] characteristics1 = {"Name 1","1/1/2001","Juneau", "AL"};
		String[] characteristics2 = {"Name 2","2/2/2002","Phoenix", "AZ"};
		String[] characteristics3 = {"Name 3","3/3/2003", "Montgomery", "AL"};
		String[] characteristics4 = {"Name 4","4/4/2004", "Little Rock", "AK"};

		
		Person person1 = null;
		Person person2 = null;
		Person person3 = null;
		Person person4 = null;
		try 
		{//creates Person objects from the same set of characteristics
			person1 = new Person(characteristics1);
			person2 = new Person(characteristics2);
			person3 = new Person(characteristics3);
			person4 = new Person(characteristics4);
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	
		try
		{//cannot currently assert to different Person objects as equal,
			//so instead compares values
			
			//exact test
			Person foundPerson1 = aList.searchForPersonByExactName("Name 1");
			assertEquals(person1.getBirthState(), foundPerson1.getBirthState());
			
			Person missingPerson = aList.searchForPersonByExactName("Name 7");
			assertNull(missingPerson);
			
			List<Person> comparisonList = new ArrayList<Person>();
			comparisonList.add(person1);
			comparisonList.add(person2);
			comparisonList.add(person3);
			comparisonList.add(person4);
			//partial test
			List<Person> foundPeople = aList.searchForPersonByPartialName("Name");
			for (int i = 0; i>4; i++)
			{
				assertEquals(foundPeople.get(i),comparisonList.get(i));
		
			}
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}
	@Test//the expected values are the same as they are supposed to be, I'm not sure what is being flagged
	public void testSortByFirstName() throws Exception{
		String[] characteristics1 = {"Lena Akiama","1/1/2001","Juneau", "AL"};
		String[] characteristics2 = {"John Michael","2/2/2002","Phoenix", "AZ"};
		String[] characteristics3 = {"Devid Michael","3/3/2003", "Montgomery", "AL"};

		
		PersonList actualListOfPerson = new PersonList();
		actualListOfPerson.addPerson(characteristics1);
		actualListOfPerson.addPerson(characteristics2);
		actualListOfPerson.addPerson(characteristics3);
		
		Person person1 = new Person(characteristics1);
		Person person2 = new Person(characteristics2);
		Person person3 = new Person(characteristics3);
		
		List<Person> expectedList = new ArrayList<Person>();
		expectedList.add(person3);
		expectedList.add(person2);
		expectedList.add(person1);
		
		
		List<Person> sortedByFirstName = new ArrayList<Person>();
		sortedByFirstName = actualListOfPerson.sortByFirstName();
		
		Assert.assertEquals(expectedList,sortedByFirstName);

         
	}
	public void testSortByLastName() throws Exception{
		String[] characteristics1 = {"Lena Akiama","1/1/2001","Juneau", "AL"};
		String[] characteristics2 = {"John Michael","2/2/2002","Phoenix", "AZ"};
		String[] characteristics3 = {"Devid Michael","3/3/2003", "Montgomery", "AL"};

		
		PersonList actualListOfPerson = new PersonList();
		actualListOfPerson.addPerson(characteristics1);
		actualListOfPerson.addPerson(characteristics2);
		actualListOfPerson.addPerson(characteristics3);
		
		Person person1 = new Person(characteristics1);
		Person person2 = new Person(characteristics2);
		Person person3 = new Person(characteristics3);
		
		List<Person> expectedList = new ArrayList<Person>();
		expectedList.add(person1);
		expectedList.add(person3);
		expectedList.add(person2);
		
		
		List<Person> sortedByLastName = new ArrayList<Person>();
		sortedByLastName = actualListOfPerson.sortByLastName();
		
		Assert.assertEquals(expectedList,sortedByLastName);

         
	}

}