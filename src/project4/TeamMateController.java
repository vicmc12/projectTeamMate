package project4;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFileChooser;


/**
 * Project #4 
 * CS 2334, Section 010 
 * Mar 31, 2015
 * <P>
 * </P>
 * 
 * @version 1.0
 */
public class TeamMateController {
	private MainView mainView;
	private TeamMateModel model;
	private StateSelectionView stateSelectionView ;
	private CityEntryView cityEntryView ;
	private EditPlacesView editPlacesView;
	private AddPersonView addPersonView;
	
	public TeamMateController(){
		
	}
	
	class LoadListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String fileNamePlayers = null;
			String fileNameTeam = null;
			String fileNameCity = null;
			PersonList personList = null;
			TeamList teamList = null;
			List<Person> listOfPerson=null;
			List<Team> listOfTeam=null;
			
			JFileChooser fc1 = new JFileChooser();
			int returnVal1 = fc1.showOpenDialog(null);
			File f1;
			if(returnVal1==JFileChooser.APPROVE_OPTION){
				f1 = fc1.getSelectedFile();
				fileNamePlayers = f1.toString();
			}
//			JFileChooser fc2 = new JFileChooser();
//			int returnVal2 = fc2.showOpenDialog(null);
//			File f2;
//			if(returnVal2==JFileChooser.APPROVE_OPTION){
//				f2 = fc2.getSelectedFile();
//				fileNameTeam = f2.toString();
//			}
//			JFileChooser fc3 = new JFileChooser();
//			int returnVal3 = fc3.showOpenDialog(null);
//			File f3;
//			if(returnVal3==JFileChooser.APPROVE_OPTION){
//				f3 = fc3.getSelectedFile();
//				fileNameCity = f3.toString();
//
//			}
			FileProcessor fileProcessor = new FileProcessor(fileNamePlayers);
			
			
			try {
				fileProcessor.processFile();
			} catch (IOException e1) {
				System.out.print("N deu pra ler");
			}
			personList = fileProcessor.getCreatedPersonList();
			listOfPerson = personList.getListOfPersons();
			System.out.println(listOfPerson.size());
			model.setPeopleList(listOfPerson);
			model.setTeamsList();
			model.setPlacesList();

			try
		 	{
//				mainView.populatePeopleList(listOfPerson);
		 	}
		 	catch (Exception readError)
		 	{
		 		
		 		System.out.println("err");
		 	}
		}
		
	}

	/**
	 * 
	 */
	public class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test1");
		}
	}
	/**
	 * 
	 */
	public class ImportListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test2");
		}
	}
	/**
	 * 
	 */
	public class ExportListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test3");
		}
	}
	/**
	 * 
	 */
	public class GraphListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test4");
		}
	}
	/**
	 * 
	 */
	public class AddPlaceListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			stateSelectionView= new StateSelectionView();
			stateSelectionView.setModel(model) ;
			stateSelectionView.addCancelListener(new CancelStateListener());
			stateSelectionView.getStateButton().addActionListener(new SelectStateListener());
			System.out.println("test8");
		}
	}
	/**
	 * 
	 */
	public class SelectStateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// No model associated. Can't do anything.
			cityEntryView = new CityEntryView();
			cityEntryView.setModel(model) ;
			cityEntryView.addCancelListener(new CancelCityListener());
			cityEntryView.addAddCityListener(new AddCityListener());
						if (model == null)
							return;

						// Get the index of the selected item.
						int index = stateSelectionView.getStateList().getSelectedIndex();

						// Update the sublist, add the selected contact to the sublist.
						if (index > -1)
							model.setStateList(stateSelectionView.getStatesString());
							model.addToSelectedList(index);
					
			
		}
		
	}
	public class AddCityListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			String city = cityEntryView.getCityName();
			Double latitude = cityEntryView.getLatitude();
			Double longitude = cityEntryView.getLongitude();
//			String state = model.getState();
			model.addCityToList(city , latitude, longitude);
			cityEntryView.dispose();
			stateSelectionView.dispose();
			
		}
		
	}
	public class CancelStateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			stateSelectionView.dispose();
			
		}
		
	}
	public class CancelCityListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			cityEntryView.dispose();
			
		}
		
	}
	public class EditPlaceListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			editPlacesView = new EditPlacesView();
			editPlacesView.setModel(model) ;
			editPlacesView.addCancelButtonListener(new CancelEditListener());
			editPlacesView.addEditButtonlListener(new EditButtonlListener());
			if (model == null)
				return;

			// Get the index of the selected item.
			int index = mainView.getplacesList().getSelectedIndex();

			// Update the sublist, add the selected contact to the sublist.
			if (index > -1)

				model.selectedPlace(index);
			editPlacesView.setSelectedState(model.getSelectedPlaceState());
			System.out.println("test6");
		}
	}
	/**
	 * 
	 */
	public class CancelEditListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			editPlacesView.dispose();

		}
	}
	public class EditButtonlListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String editPlaceCityName = editPlacesView.getCityName();
			Double editPlaceLatitude = editPlacesView.getLatitude();
			Double editPlaceLongitude = editPlacesView.getLongitude();
			
			model.editSelectedPlace(editPlaceCityName, editPlaceLatitude, editPlaceLongitude);
			
		}
		
	}

	/**
	 * 
	 */
	public class AddPeopleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			addPersonView = new AddPersonView();
			addPersonView.setModel(model) ;
			addPersonView.addCancelListener(new CancelPersonListener());
			addPersonView.addAddPersonListener(new AddPersonListener());
			addPersonView.addSelectListener(new AddPersonSelectListener());
			
			System.out.println("test8");
		}
	}
	public class CancelPersonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			addPersonView.dispose();
		}
	}
	
	//TODO version difference
	public class AddPersonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO
			String personName = addPersonView.getPersonName();
			Calendar birthDate = addPersonView.getBirthDate();
			Calendar deathDate = addPersonView.getDeathDate();
			City birthCity = addPersonView.getBirthCity();//TODO: this may come from the AddPersonSelectListener instead somehow
			
			if(deathDate != null)
			{
				model.getPeopleList().addPerson(personName, birthDate, birthCity, deathDate);
			}
			else
			{
				model.getPeopleList().addPerson(personName, birthDate, birthCity);
			}
			
			
		}
	}
	
	//TODO version differences
	public class AddPersonSelectListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//needs to create a City Selection screen
			//hopefully it will return the created city too
		}
		
	}
	/**
	 * 
	 */
	public class EditPeopleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test9");
		}
	}
	/**
	 * 
	 */
	public class DeletePeopleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (model == null)
				return;

			// Get the index of the selected item.
			int index = mainView.getplacesList().getSelectedIndex();

			// Update the sublist, add the selected contact to the sublist.
			if (index > -1)

				model.deletePlace(index);
			System.out.println("test6");
		}
	}
	/**
	 * 
	 */
	public class AddTeamListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test11");
		}
	}
	/**
	 * 
	 */
	public class EditTeamListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test12");
		}
	}
	/**
	 * 
	 */
	public class RemoveTeamListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test13");
		}
	}
	public void setModel(TeamMateModel model) {
      this.model = model;		
	}
	public void setView(MainView masterView) {
		this.mainView = masterView;
		this.mainView.addAddPlaceListener(new AddPlaceListener());
		this.mainView.addLoadListener(new LoadListener());
		this.mainView.addEditPlaceListener(new EditPlaceListener());
		this.mainView.addDeletePlaceListener(new DeletePeopleListener());
		this.mainView.addAddPeopleListener(new AddPeopleListener());
		
		
		
	}

}
