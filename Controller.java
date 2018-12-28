package toDoList;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import toDoList.data.*;

public class Controller {

	private List<TodoItems> todoItems;
	
	@FXML
	private ListView list;
	@FXML
	private TextArea itemDetails;
	@FXML
	private Label DeadlineLabel;
	
	public void initialize() {
		TodoItems item1=new TodoItems("Mail to friend","you must send an emaill",LocalDate.of(2018, Month.FEBRUARY	, 21));
		TodoItems item2=new TodoItems("go to swim","you must go to miscine",LocalDate.of(2018, Month.JULY	, 1));
		TodoItems item3=new TodoItems("visit friend","you have a date with friend",LocalDate.of(2018, Month.MARCH	, 2));
		TodoItems item4=new TodoItems("clean the howse ","you must send an emaill",LocalDate.of(2018, Month.FEBRUARY	, 21));
		TodoItems item5=new TodoItems("pick up dry cleaning","Clothes must be ready ",LocalDate.of(2018, Month.APRIL	, 21));
		
		todoItems=new ArrayList<TodoItems>();
		
		todoItems.add(item1);
		todoItems.add(item2);
		todoItems.add(item3);
		todoItems.add(item4);
		todoItems.add(item5);
		
		list.getItems().setAll(todoItems);	
		list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
	
	public void handleClicListView() {
		TodoItems item= (TodoItems) list.getSelectionModel().getSelectedItem();
		System.out.println("Selected the item "+item); 
		itemDetails.setText(item.getDetails());//to show details in the center 
		DeadlineLabel.setText(item.getDeadline().toString());// to show deadline in the bottom
	}
}
