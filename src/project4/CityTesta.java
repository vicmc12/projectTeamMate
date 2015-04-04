package project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CityTesta {

	@Test
	public void testFindCity() {
		String cityName1 = "Norman";
		String cityName2 = "Oklahoma City";
		String cityName3 = "Chicago";
		String stateName1 = "OK";
		String stateName2 = "OK";
		String stateName3 = "IL";
		double latitude1 = 0.;
		double latitude2 = 1.;
		double latitude3 = 2.;
		double longitude1 = 3.;
		double longitude2 = 4.;
		double longitude3 = 5.;
		City city1 = null;
		City city2 = null;
		City city3 = null;
		City comparedCity1 = null;
		City comparedCity2 = null;
		City comparedCity3 = null;
		try {
			city1 = City.findCity(cityName1, stateName1, latitude1, longitude1);
			city2 = City.findCity(cityName2, stateName2, latitude2, longitude2);
			city3 = City.findCity(cityName3, stateName3, latitude3, longitude3);
			comparedCity1 = City.searchForCity(cityName1, stateName1);
			comparedCity2 = City.searchForCity(cityName2, stateName2);
			comparedCity3 = City.searchForCity(cityName3, stateName3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(city1, comparedCity1);
		assertEquals(city2, comparedCity2);
		assertEquals(city3, comparedCity3);
	}

	

	

}
