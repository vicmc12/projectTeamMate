
package project4;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
//import java.awt.Image;
import javax.swing.*;
import java.io.*;
import javax.imageio.*; 
//import javax.swing.JFrame;


/**
 * Project #3
 * CS 2334, Section 010 
 * Mar 27, 2015
 * <P>
 * This class creates a graphical map that displays cities and their names.
 * </P>
 * 
 * @version 1.0
 */
public class GraphMap extends JPanel {
	
	/** A private static final long to store the serial version.*/
	private static final long serialVersionUID = -1151136803912982714L;
	/** A private City to store the city to which the team belongs.*/
	private City teamCity = null;
	/** A private ArrayList of City to store the cities that need to be displayed.*/
	private ArrayList<City> mapCities = new ArrayList<City>();
	/** A private boolean for whether lines need to connect the cities.*/
	private boolean connectCities = false;
	/** A private ImageIcon to store the background map image.*/
	private ImageIcon mapImage;
	
	/** A public final double that scales from longitude to the x coordinate of the map*/
	public final double longitudeScaleFactor = 9.3090909;
	/** A public final double that shifts from longitude to the x coordinate of the map*/
	public final double longitudeShiftFactor = 1582.5455;
	/** A public final double that scales from latitude to the y coordinate of the map*/
	public final double latitudeScaleFactor = -9.5428571;
	/** A public final double that shifts from latitude to the y coordinate of the map*/
	public final double latitudeShiftFactor = 763.42857;

	/**
	 * A constructor for GraphMap
	 * 
	 * @param 		windowTitle				A string that will be used to title
	 * 										the window of the GraphMap.
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - 
	 *<dd>POST -
	 *</dl>
	 */
	public GraphMap(String windowTitle)
	{
		super();
		   try{
				mapImage = new ImageIcon(ImageIO.read(new File("politicalUSEnlarged.png")));
			}catch(IOException e){
				System.out.println("The map image can't be found");
			}
	}
	
	/**
	 * 	Overwrites the getPreferredSize() method of JComponent. The preferred 
	 * 		size is the size of the background map.
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public Dimension getPreferredSize() {
		   return new Dimension(1024, 668);//TODO: replace hard code
		}
	
	/**
	 * 	Overwrites the paintComponent(Graphics g) method of JComponent. 
	 * 		In particular it plots the cities and labels them.
	 * 
	 * @param				g 		the Graphics object to protect.
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(mapImage.getImage(),0,0, 1024, 668, null );//TODO replace hard code
		
		for (City c : this.mapCities) {
	       	if(c == null) continue;
			double latitude = c.getLatitude();
	    	double longitude = c.getLongitude();
	    	
	    	int xCoor = (int) Math.round(longitudeScaleFactor * longitude + longitudeShiftFactor); 
	    	int yCoor = (int) Math.round(latitudeScaleFactor * latitude + latitudeShiftFactor);
	        g.setColor(Color.WHITE);
	    	g.fillRoundRect(xCoor - 3,yCoor - 3, 6, 6, 8, 8);  // Draw a dotpl
            g.setColor(Color.BLACK);
	    	g.drawString(c.getName(), xCoor + 12, yCoor);  // Move string to side of dot   
           // System.out.println(xCoor +" , " + yCoor + " , " + c.getName());
		}
		
		if(connectCities)
		{
			double teamLatitude = teamCity.getLatitude();
			double teamLongitude = teamCity.getLongitude();
	    	int teamXCoor = (int) Math.round(longitudeScaleFactor * teamLongitude + longitudeShiftFactor); 
	    	int teamYCoor = (int) Math.round(latitudeScaleFactor * teamLatitude + latitudeShiftFactor);
	        g.setColor(Color.BLUE);
	    	g.fillRoundRect(teamXCoor - 5,teamYCoor - 5, 10, 10, 8, 8);  // Draw a dot
            g.setColor(Color.BLACK);
	    	g.drawString(teamCity.getName(), teamXCoor + 12, teamYCoor);  // Move string to side of dot
			g.setColor(Color.RED);
			for (City c: this.mapCities)
			{
		       	double latitude = c.getLatitude();
		    	double longitude = c.getLongitude();
				
		    	int xCoor = (int) Math.round(longitudeScaleFactor * longitude + longitudeShiftFactor); 
		    	int yCoor = (int) Math.round(latitudeScaleFactor * latitude + latitudeShiftFactor);
				g.drawLine(xCoor, yCoor, teamXCoor, teamYCoor);
			}
		}
	}
	
	/**
	 * 	Graphs an individual city on the map.
	 * 
	 * @param		city		The city to be graphed.
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public void graph(City city) {
		List<City>cities = new ArrayList<City>();
		cities.add(city);
		graph(cities);
	}

	/**
	 * 	Graphs a List of City on the map.
	 * 
	 * @param		cityList		The List of City to be graphed.
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public void graph(List<City> cityList) {
		mapCities.addAll(cityList);
	}

	/**
	 * 	Graphs the cities of a PersonList on the map.
	 * 
	 * @param		aPersonList		The PersonList to graph the cites of. 
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public void graph(PersonList aPersonList) {
	
		List<City>cityList = new ArrayList<City>();
		List<Person> people = aPersonList.getListOfPersons();
		for(Person aPerson: people)
		{
			if(aPerson != null)
			{	
				if(aPerson.getBirthCity() != null)
				{
					cityList.add(aPerson.getBirthCity());
				}
			}
		}
		graph(cityList);
	}
	
	/**
	 * 	Graphs the city of a Person on the map.
	 * 
	 * @param		aPerson			The Person to graph the city of.
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public void graph(Person aPerson)
	{
		PersonList individualList = new PersonList();
		individualList.addPerson(aPerson);
		
		graph(individualList);
	}
	
	/**
	 * 	Graphs the cities of a State on the map.
	 * 
	 * @param		aState		The state to graph the cities of.
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public void graph(State aState)
	{
		List<City> cities = aState.getCitiesInState();
		graph(cities);
	}
	
	/**
	 * 	Graphs the cities of a Team on the map. The city of the team and the
	 * 		cities of the of the team members will be connected by lines.
	 * 
	 * @param		aTeam		The team to graph the cities of.
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE-
	 *<dd>POST-
	 *</dl>
	 */
	public void graph(Team aTeam)
	{
		this.connectCities = true;
		this.teamCity = aTeam.getCity();
		PersonList teamRoster = aTeam.getRoster();
		graph(teamRoster);
	}
}