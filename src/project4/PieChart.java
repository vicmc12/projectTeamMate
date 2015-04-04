package project4;

import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;


/**
 * Project #3
 * CS 2334, Section 010 
 * Mar 27, 2015
 * <P>
 * This class creates a graphical pie chart to show the age distribution of 
 *	 groups of people.
 * </P>
 * 
 * @version 1.0
 */
public class PieChart extends JFrame {
	
	/** A private static final long to store the serial version.*/
	private static final long serialVersionUID = -3316840649398939384L;
	/** A private PersonList to contain the group of people to display the ages of.*/
	private PersonList personList;
	/** A private array of integers*/
	private int[] ages = new int[2500];//may need to enlarge
	/** A private integer to store the number of people between 0 and 10 years old.*/
	private int value0_10 = 0;
	/** A private integer to store the number of people between 11 and 20 years old.*/
	private int value11_20 = 0;
	/** A private integer to store the number of people between 21 and 30 years old.*/
	private int value21_30 = 0;
	/** A private integer to store the number of people between 31 and 40 years old.*/
	private int value31_40 = 0;
	/** A private integer to store the number of people between 41 and 50 years old.*/
	private int value41_50 = 0;
	/** A private integer to store the number of people between 51 and 60 years old.*/
	private int value51_60 = 0;
	/** A private integer to store the number of people between 61 and 70 years old.*/
	private int value61_70 = 0;
	/** A private integer to store the number of people between 71 and 80 years old.*/
	private int value71_80 = 0;
	/** A private integer to store the number of people between 81 and 90 years old.*/
	private int value81_90 = 0;
	/** A private integer to store the number of people between 91 and 100 years old.*/
	private int value91_100 = 0;
	/** A private integer to store the number of people older than 100 years old.*/
	private int value100plus = 0;
	
	/**
	 * A constructor for PieChart
	 * 
	 * @param 		chartTitle				The title to be displayed
	 * @param		personList				The personList to be displayed	
	 * 									
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - 
	 *<dd>POST -
	 *</dl>
	 */
	public PieChart(String chartTitle, PersonList personList){
		this.personList = personList;
		PieDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset, chartTitle);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 400));
		setContentPane(chartPanel);
	}

	/*
	 * Creates the dataset to be displayed
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - 
	 *<dd>POST -
	 *</dl>
	 */
	private PieDataset createDataset(){
		DefaultPieDataset result = new DefaultPieDataset();
	    findAges();
	    result.setValue("0-10", value0_10);
	    result.setValue("11-20", value11_20);
	    result.setValue("21-30", value21_30);
	    result.setValue("31-40", value31_40);
	    result.setValue("41-50", value41_50);
	    result.setValue("51-60", value51_60);
	    result.setValue("61-70", value61_70);
	    result.setValue("71-80", value71_80);
	    result.setValue("81-90", value81_90);
	    result.setValue("91-100", value91_100);
	    result.setValue("100+", value100plus);

		return result;
	}
	
	/*
	 * determines the ages for every Person of personList
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - 
	 *<dd>POST -
	 *</dl>
	 */
	private void findAges(){
		List<Person> list = personList.getListOfPersons();
		for(Person aPerson: list)
		{ 	
			if(aPerson!= null)
			{	
				int age = aPerson.getAge();
				if(age>=0&&age<=10){
					value0_10++;	
				}
				if(age>=11&&age<=20){
					value11_20++;
				}
				if(age>=21&&age<=30){
					value21_30++;
				}
				if(age>=31&&age<=40){
					value31_40++;
				}
				if(age>=41&&age<=50){
					value41_50++;
				}
				if(age>=51&&age<=60){
					value51_60++;
				}
				if(age>=61&&age<=70){
					value61_70++;
				}
				if(age>=71&&age<=80){
					value71_80++;
				}
				if(age>=81&&age<=90){
					value81_90++;
				}
				if(age>=91&&age<=100){
					value91_100++;
				}
				if(age>=101){
					value100plus++;
				}
			
				int newAge = ages[age]+1;
				ages[age] = newAge;
			}
		}
	}
	
	/*
	 * Creates the chart that will be displayed.
	 * 
	 *<dl>
	 *<dt><b>Conditions:</b>
	 *<dd>PRE - 
	 *<dd>POST -
	 *</dl>
	 */
	private JFreeChart createChart(PieDataset dataset, String title){
		JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
		
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setStartAngle(0);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;
	}
}
