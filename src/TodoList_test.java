package test;

public class TodoList_test {
	String date;
	String due;
	String description;

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

	public TodoList_test clone() {
		TodoList_test todolist_test = new TodoList_test();
		todolist_test.date = this.date;
		todolist_test.due = this.due;
		todolist_test.description = this.description;
		
		return todolist_test;
	}
}
