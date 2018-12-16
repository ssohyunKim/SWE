package test;

import java.util.Scanner;

public class Home_test {

	private static int homeChoice;

	static Scanner scanner = new Scanner(System.in);
	// private static Contact contact;
	 private static TodoList_Manager_test todolist_manager;
	// private static Appointment appointment;

	public static void main(String[] args) {
		selectHomeMenu();
	}

	static void selectHomeMenu() {

		boolean isHomeMenu = true;
		todolist_manager = new TodoList_Manager_test();
		
		while (isHomeMenu) {
			System.out.println("+---------------------+");
			System.out.println(" |  1. Contact                |");
			System.out.println(" |  2. To-do List            |");
			System.out.println(" |  3. Appointment       |");
			System.out.println(" |  4. Quit                      |");
			System.out.println("+---------------------+");

			homeChoice = scanner.nextInt();

			if (homeChoice == 1) {
				// contact
				System.out.println("+------Contact------+");

			} else if (homeChoice == 2) {
				todolist_manager.execute();
				System.out.println("+-----To-do List-----+");

			} else if (homeChoice == 3) {
				// appointment
				System.out.println("+---Appointment---+");

			} else if (homeChoice == 4) {
				System.out.println("***Thank You! Bye!***");
				isHomeMenu = false;
			}
		}
	}
}