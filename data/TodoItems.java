/**
 * 
 */
package toDoList.data;

import java.time.LocalDate;

/**
 * @author mehdibalbali
 *
 */
public class TodoItems {
	private String description ;
	private String details;
	private LocalDate deadline;
	public TodoItems(String description, String details, LocalDate localDate) {
		this.description = description;
		this.details = details;
		this.deadline = localDate;
	}
	/**
	 * @param description2
	 * @param details2
	 * @param of
	 */
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return  description;
	}
	

	
	
}
