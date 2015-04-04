package project4;



/**
 * Project #4 
 * CS 2334, Section 010 
 * Mar 31, 2015
 * <P>
 * The class driver class of the TeamMate project
 * </P>
 * 
 * @version 1.0
 */
public class TeamMateDriver{
	MainView mainView = new MainView();
	
	TeamMateModel model;
	TeamMateController controller = new TeamMateController();
	
	public TeamMateDriver(){
		model = new TeamMateModel();
		mainView.setModel(model);
		controller.setModel(model);
		controller.setView(mainView);
	}
	public static void main(String[]args){
		
		new TeamMateDriver();
		
	}
}
