import java.util.ArrayList;
import java.util.Scanner;

public class TodoList_Manager extends Asset_Manager{
	private Scanner scanner = new Scanner(System.in);
	private static int subMenuChoice = 0;
	static final int CREATE = 1;
	static final int VIEW = 2;
	static final int UPDATE = 3;
	static final int DELETE = 4;
	static final int GOHOME = 5;
	boolean isSuccess = true;
	protected ArrayList<TodoList> todolists = new ArrayList<TodoList>();
	private int number;
	int updateNumber;
	
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
				System.out.println("UPDATE");
			} else if (subMenuChoice == DELETE) {
				System.out.println("DELETE");
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
		scanner.nextLine();//이거 안넣으면 잘 안됩니다ㅠㅠ
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
		for (TodoList todolist : todolists) {
			System.out.printf("%1$3d/ %2$10s/ %3$15s/ %4$30s\n", number++, todolist.getDate(),
					todolist.getDue(), todolist.getDescription());
		}
		
	}

	@Override
	boolean update(Object ob) {
		// TODO 자동 생성된 메소드 스텁
		return isSuccess;
	}

	@Override
	boolean delete(Object ob) {
		todolists.remove(number - 1);
		number = 0;
		System.out.println("삭제 완료");

		return isSuccess;
	}

	@Override
	void goHome() {
		// TODO 자동 생성된 메소드 스텁
		
	}

}
