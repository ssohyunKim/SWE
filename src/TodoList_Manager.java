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

			if (subMenuChoice == CREATE) {
				create(todolists);
			} else if (subMenuChoice == VIEW) {
				view();
			} else if (subMenuChoice == UPDATE) {
				update(todolists);
			} else if (subMenuChoice == DELETE) {
				delete(todolists);
			} else if (subMenuChoice == GOHOME) {
				System.out.println("GOHOME");
				break;
			} else {
				System.out.println("Choose valid sub menu!");
			}
		}
	}

	@Override
	boolean create(Object ob) {
		TodoList todolist = new TodoList();
		System.out.print("Date(yy-mm-dd): ");
		todolist.setDate(scanner.next());
		System.out.print("Due(yy-mm-dd): ");
		todolist.setDue(scanner.next());
		scanner.nextLine();
		System.out.print("Description: ");
		todolist.setDescription(scanner.nextLine());
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
			System.out.printf("%1$3d/ %2$10s/ %3$15s/ %4$30s\n", number++, todolist.getDate(), todolist.getDue(),
					todolist.getDescription());
		}

	}

	@Override
	boolean update(Object ob) {
		System.out.print("Number to update: ");
		updateNumber = scanner.nextInt();
		if (updateNumber > 0 && updateNumber <= todolists.size()) {
			TodoList todolist = todolists.get(updateNumber - 1);
			System.out.println("*If you don't want to update, just press enter and skip input.*");
			System.out.print("Date: ");
			modifiedValue = scanner.nextLine();
			if (modifiedValue.length() > 0) {
				todolist.setDate(modifiedValue);
			}
			scanner.nextLine();
			System.out.print("Due: ");
			modifiedValue = scanner.nextLine();
			if (modifiedValue.length() > 0) {
				todolist.setDue(modifiedValue);
			}
			scanner.nextLine();
			System.out.print("Description: ");
			modifiedValue = scanner.nextLine();
			if (modifiedValue.length() > 0) {
				todolist.setDescription(modifiedValue);
			}
			System.out.println("Successfully Modified!!\n");
		}
		return isSuccess;

	}

	@Override
	boolean delete(Object ob) {
		System.out.print("Number to delete: ");
		deleteNumber = scanner.nextInt();
		if (deleteNumber > 0 && deleteNumber <= todolists.size()) {
			// TodoList todolist = todolists.get(deleteNumber - 1);
			todolists.remove(deleteNumber - 1);
			deleteNumber = 0;
			System.out.println("Successfully Deleted");
		}
		return isSuccess;
	}

	@Override
	void goHome() {
		// TODO 자동 생성된 메소드 스텁

	}

}