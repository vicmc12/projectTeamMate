package project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeamListTest {

	/**
	 *  Tests if the addTeam() and searchForTeam() methods are functioning.
	 */
	@Test
	public void testSearchForTeam() {
		TeamList teamList = new TeamList();
		String teamName = "Team1";
		City aCity = null;
		PersonList roster = null;
		double latitude = 0;
		double longitude = 0;
		
		try {
			aCity = City.findCity("Norman", "OK", latitude, longitude);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] characteristics1 = {"Name 1","1/1/2001","Norman", "OK"};
		String[] characteristics2 = {"Name 2","2/2/2002","Norman", "OK"};
       
		roster = new PersonList();
		
		try {
			roster.addPerson(characteristics1);
			roster.addPerson(characteristics2);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		
		
		Team team1 = new Team(teamName, aCity, roster);
		teamList.addTeam(teamName, aCity, roster);

		try {
			assertEquals(teamList.searchForTeam("Team1").getTeamName(), team1.getTeamName());
			assertEquals(teamList.searchForTeam("Team1").getCity(), team1.getCity());
			assertEquals(teamList.searchForTeam("Team1").getRoster(), team1.getRoster());
			assertEquals(teamList.searchForTeam("Team1").getState(), team1.getState());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
