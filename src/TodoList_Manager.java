import java.text.*;
import java.util.*;

public class TodoList_Manager extends Asset_Manager {
	private Scanner scanner = new Scanner(System.in);
	private static int subMenuChoice = 0;
	static final int CREATE = 1;
	static final int VIEW = 2;
	static final int UPDATE = 3;
	static final int DELETE = 4;
	static final int GOHOME = 5;
	boolean isSuccess = true;
	protected ArrayList<TodoList> todolists = new ArrayList<TodoList>();
	private int deleteNumber;
	int updateNumber;
	private String modifiedValue;

	public void manageTodoList() {
		boolean isSubMenu = true;

		while (isSubMenu) {
			Asset_Manager assetManager = new TodoList_Manager();
			assetManager.showSubMenu();
			subMenuChoice = scanner.nextInt();
			TodoList todolist = new TodoList();

			if (subMenuChoice == CREATE) {
				System.out.print("Date(yy-mm-dd): ");
				String date = scanner.next();
				scanner.nextLine();
				System.out.print("Due(yy-mm-dd): ");
				String due = scanner.next();
				scanner.nextLine();
				System.out.print("Description: ");
				String description = scanner.nextLine();
				create(date, due, description);
			} else if (subMenuChoice == VIEW) {
				view();
			} else if (subMenuChoice == UPDATE) {
				if (todolists.size() == 0) {
					System.out.println("Don't exist!!");
					return;
				}
				System.out.print("Number to update: ");
				updateNumber = scanner.nextInt();
				if (updateNumber <= 0 && updateNumber > todolists.size())
					break;
				if(updateNumber <=0 || updateNumber > todolists.size() ) {
					System.out.println("Invalid Number");
					break;
				}
				todolist = todolists.get(updateNumber - 1);
				System.out.print("Date(yy-mm-dd): ");
				String new_date = scanner.next();
				scanner.nextLine();
				System.out.print("Due(yy-mm-dd): ");
				String new_due = scanner.next();
				scanner.nextLine();
				System.out.print("Desciption: ");
				String new_description = scanner.nextLine();

				update(todolist, new_date, new_due, new_description);

			} else if (subMenuChoice == DELETE) {
				System.out.print("Number to delete: ");
				int deleteNumber = scanner.nextInt();
				scanner.nextLine();
				delete(deleteNumber);
			} else if (subMenuChoice == GOHOME) {
				goHome();
				break;
			} else {
				System.out.println("Choose valid sub menu!");
			}
		}
	}

	@Override
	boolean create(String date, String due, String description) {

		try {
			DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
			dateFormat.setLenient(false);
			Date inputDate = dateFormat.parse(date);
			Date dueDate = dateFormat.parse(due);
			long calDate = inputDate.getTime() - dueDate.getTime();
			long calDateDays = calDate / (24*60*60*1000);
			if(calDateDays > 0) {
				System.out.println("Your Due date should be after Date.");
				return false;
			}
		} catch (ParseException e) {
			System.out.println("Date format Error!! (yy-MM-dd)");
			return false;
		}
		TodoList todolist = new TodoList();
		todolist.setDate(date);
		todolist.setDue(due);
		todolist.setDescription(description);
		todolists.add(todolist);
		System.out.println("Successfully Created!!");
		return isSuccess;
	}

	@Override
	void view() {
		System.out.printf("%1$3s %2$10s %3$15s %4$30s\n", "No.", "Date", "Due", "Description");
		System.out.println("----------------------------------------------------------------------");
		for (int i = 0; i < todolists.size(); i++) {
			TodoList todolist = todolists.get(i);
		}
		int number = 1;
		if (todolists.size() == 0)
			System.out.println("EMPTY!!");
		for (TodoList todolist : todolists) {
			System.out.printf("%1$3d %2$10s %3$15s %4$30s\n", number++, todolist.getDate(), todolist.getDue(),
					todolist.getDescription());
		}
	}

	@Override
	boolean update(Object todolist, String newDate, String newDue, String description) {
		if (todolist == null) {
			System.out.println("Empty");
			return false;
		}		
		try {
			DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
			dateFormat.setLenient(false);
			Date inputDate = dateFormat.parse(newDate);
			Date dueDate = dateFormat.parse(newDue);
			long calDate = inputDate.getTime() - dueDate.getTime();
			long calDateDays = calDate / (24*60*60*1000);
			if(calDateDays > 0) {
				System.out.println("Your Due date should be after register date.");
				return false;
			}
				
		} catch (ParseException e) {
			System.out.println("Date Format Error!! (yy-mm-dd)");
			return false;
		}
		((TodoList) todolist).setDate(newDate);
		((TodoList) todolist).setDue(newDue);
		((TodoList) todolist).setDescription(description);

		return isSuccess;
	}

	@Override
	boolean delete(int deleteNumber) {
		if (deleteNumber <= 0 || deleteNumber > todolists.size()) {
			System.out.println("Invalid");
			return false;
		}
		TodoList todolist = todolists.get(deleteNumber - 1);
		todolists.remove(todolist);
		System.out.println("Successfully Deleted");
		return true;
	}

	@Override
	void goHome() {
		System.out.println("GO HOME");
	}
}