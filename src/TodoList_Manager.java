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
	
	public void manageTodoList() {
		boolean isSubMenu = true;

		while (isSubMenu) {
			Asset_Manager assetManager = new TodoList_Manager();
			assetManager.showSubMenu();
			subMenuChoice = scanner.nextInt();

			if (subMenuChoice == CREATE) {
				System.out.println("CREATE");
			} else if (subMenuChoice == VIEW) {
				System.out.println("VIEW");
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
		// TODO 자동 생성된 메소드 스텁
		return isSuccess;
	}

	@Override
	void view() {
		// TODO 자동 생성된 메소드 스텁
		
	}

	@Override
	boolean update(Object ob) {
		// TODO 자동 생성된 메소드 스텁
		return isSuccess;
	}

	@Override
	boolean delete(Object ob) {
		// TODO 자동 생성된 메소드 스텁
		return isSuccess;
	}

	@Override
	void goHome() {
		// TODO 자동 생성된 메소드 스텁
		
	}

}
