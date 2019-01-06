/**
 * 
 */
package toDoList.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * in this class we will store and read data from a file 
 *
 */
public class TodoData {
		public static TodoData instance = new TodoData();
		private final String filename="todolistdata.txt";
		
		private List<TodoItems> todoItems;
		private  DateTimeFormatter formatter;
		public static TodoData getInstance() {
			return instance;
		}
		
		private TodoData() {
			formatter= DateTimeFormatter.ofPattern("dd-mm-yyyy");
		}

		public List<TodoItems> getTodoItems() {
			return todoItems;
		}

		public void setTodoItems(List<TodoItems> todoItems) {
			this.todoItems = todoItems;
		}
		// to load data 
		public void loadItems() throws IOException {
			todoItems = FXCollections.observableArrayList();
			Path path = Paths.get(filename);
			BufferedReader br = Files.newBufferedReader(path);
			
			String input;
			
			try {
				while((input=br.readLine()) != null){
					String[] items = input.split("\n");
					
					String description = items[0];
					String details =items[1];
					String dateS = items[2];
					
					LocalDate date= LocalDate.parse(dateS, formatter);
					
					TodoItems todoItem = new TodoItems(description, details, date);
					todoItems.add((TodoItems) todoItems);
				}
				
			}finally {
				if(br != null) {
					br.close();
				}
			}
			
		}
		
		public static void setInstance(TodoData instance) {
			TodoData.instance = instance;
		}
		
		public DateTimeFormatter getFormatter() {
			return formatter;
		}

		public void setFormatter(DateTimeFormatter formatter) {
			this.formatter = formatter;
		}

		public String getFilename() {
			return filename;
		}

		public void storeItems() throws IOException {
			Path path = Paths.get(filename);
			BufferedWriter bw = Files.newBufferedWriter(path);
			
			try {
				Iterator<TodoItems> iter = todoItems.iterator();
				while(iter.hasNext()) {
					TodoItems item =iter.next();
					bw.write(String.format("%s%s%s",
							item.getDescription(),item.getDetails(),item.getDeadline().format(formatter)
							));
					bw.newLine();
				}
			}finally {
				if(bw != null) {
					bw.close();
				}
			}
		}
		
}
