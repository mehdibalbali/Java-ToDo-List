/**
 * 
 */
package toDoList.data;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author GeekDjerbien
 *
 */
public class TodoData {
		public static TodoData instance = new TodoData();
		private final String filename="todolistdata.txt";
		
		private List<TodoItems> todoItems;
		private  DateTimeFormatter formatter;
		private static TodoData getInstance() {
			return instance;
		}
		
		private TodoData() {
			formatter= DateTimeFormatter.ofPattern("jj-mm-aaaa");
		}

		public List<TodoItems> getTodoItems() {
			return todoItems;
		}

		public void setTodoItems(List<TodoItems> todoItems) {
			this.todoItems = todoItems;
		}
		
		
}
