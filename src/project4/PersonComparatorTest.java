package project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonComparatorTest {

	@Test
	public void testCompare() {
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
		
		PersonComparator perscomp = new PersonComparator();
		
		assertEquals(0, perscomp.compare(person1,person2));
		int value1 = perscomp.compare(person1, person3);
		assertFalse(value1 < 0);
		int value2 = perscomp.compare(person3, person1);
		assertFalse(value2 > 0);//may be <0 and >0
	}

}
