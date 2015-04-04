package project4;

import static org.junit.Assert.*;


import org.junit.Test;

public class PersonTest {

	

	@Test
	public void testCompareTo() {
		String[] characteristics = {"A Name", "1/1/1970", "Batavia", "IL"};
		String[] characteristics2 = {"A LastName", "1/1/1970", "Batavia", "IL"};
		Person person1 = null;
		Person person2 = null;
		Person person3 = null;
		try{
		person1 = new Person(characteristics);
		person2 = new Person(characteristics);
		person3 = new Person(characteristics2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(0, person1.compareTo(person2));
		assertFalse(0 > person1.compareTo(person3));//may not be actual values, 
		assertFalse(0 < person3.compareTo(person1)); //probalbly <0 and >0
		
	}
	

}
