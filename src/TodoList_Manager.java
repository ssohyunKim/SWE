import java.util.ArrayList;
import java.util.Scanner;

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
				System.out.print("Number to update: ");
				updateNumber = scanner.nextInt();
				if(updateNumber <= 0 && updateNumber > todolists.size())
					break;
				
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
				delete(todolists);
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
	boolean update(Object todolist, String date, String due, String description) {
		((TodoList)todolist).setDate(date);
		((TodoList)todolist).setDue(due);
		((TodoList)todolist).setDescription(description);

		return isSuccess;
	}

	@Override
	boolean delete(Object ob) {
		System.out.print("Number to delete: ");
		deleteNumber = scanner.nextInt();
		if (deleteNumber > 0 && deleteNumber <= todolists.size()) {
			todolists.remove(deleteNumber - 1);
			deleteNumber = 0;
			System.out.println("Successfully Deleted");
		}
		return isSuccess;
	}

	@Override
	void goHome() {
		System.out.println("GO HOME");
	}

}