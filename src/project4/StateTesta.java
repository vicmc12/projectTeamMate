package project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateTesta {

	

	@Test
	public void testFindState() {
		State state1 = State.findState("IL");
		State state2 = State.findState("OK");
		State comparedState1 = State.searchForState("IL");
		State comparedState2 = State.searchForState("OK");
		
		assertEquals(state1, comparedState1);
		assertEquals(state2, comparedState2);
	}

	//can't properly test because City has a private constructor, but will be utilized by city
//	@Test
//	public void testAddCity() {
//
//	}

}
