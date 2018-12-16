package test;

import java.util.*;
import java.io.*;

public class TodoList_Manager_test extends Asset_Manager_test {

	boolean isSuccess = true;
	protected Scanner scanner;
	protected ArrayList<TodoList_test> todolists = new ArrayList<TodoList_test>();
	private int number;
	int updateNum;

	@Override
	boolean create(Object ob) {
		TodoList_test todolist = new TodoList_test();

		System.out.print("Date(yy-mm-dd): ");
		todolist.setDate(scanner.nextLine());

		System.out.print("Due(yy-mm-dd): ");
		todolist.setDue(scanner.nextLine());

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
			TodoList_test todolist_test = todolists.get(i);
		}
		int number = 1;
		for (TodoList_test todolist_test : todolists) {
			System.out.printf("%1$3d/ %2$10s/ %3$15s/ %4$30s\n", number++, todolist_test.getDate(),
					todolist_test.getDue(), todolist_test.getDescription());
		}

	}

	@Override
	boolean update(Object ob) {
		System.out.print("몇 번?" + updateNum);
		updateNum = scanner.nextInt();
		if(updateNum > 0 && updateNum <= todolists.size()){
			TodoList_test m = todolists.get(updateNum-1);
			TodoList_test copyList = m.clone();
			System.out.printf("number(%1$d): ", updateNum);
			System.out.printf("Date($s):",m.getDate());
			String value = scanner.nextLine();
			if(value.length() > 0) {
				copyList.setDate(value);
			}
			System.out.printf("Due($s): ",m.getDue());
			value = scanner.nextLine();
			if(value.length() > 0) {
				copyList.setDue(value);
			}
			System.out.printf("Description($s): ",m.getDescription());
			value = scanner.nextLine();
			if(value.length() > 0) {
				copyList.setDescription(value);
			}
			todolists.set(updateNum-1, copyList);
			System.out.println("변경 완료!!");
		
		}
	
		

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

	}

	public void execute() {

		int subChoice = 0;

		System.out.println("<<To-Do List>>");
		while (true) {
			showSubMenu();
			System.out.print(subChoice);
			subChoice = scanner.nextInt();

			if (subChoice == 1) {
				System.out.println("1. Create");
				create(todolists);
			} else if (subChoice == 2) {
				System.out.println("2. View");
				view();
			} else if (subChoice == 3) {
				System.out.println("3. Update");
				update(todolists);
			} else if (subChoice == 4) {
				System.out.println("4. Delete");
				delete(todolists);
			} else if (subChoice == 5) {
				System.out.println("Go Back to Home Menu");
				break;
			} else {
				System.out.println("Input valide subChoice");
			}

		}

	}

}
