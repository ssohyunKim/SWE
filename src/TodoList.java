public class TodoList {
	String date;
	String due;
	String description;
	
	TodoList(){
	}
	
	public TodoList(String date, String due, String description) {
		this.date = date;
		 this.due = due;
		 this.description = description;		
	}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDue() {
		return due;
	}
	
	public void setDue(String due) {
		this.due = due;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
/*	
	public TodoList clone() {
		TodoList todoList = new TodoList();
		todoList.date = this.date;
		todoList.due = this.due;
		todoList.description = this.description;
		return todoList;
	}*/
}