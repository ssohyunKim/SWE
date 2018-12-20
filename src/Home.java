import java.util.Scanner;

public class Home {

	private static int homeChoice;
<<<<<<< HEAD
	
	static Scanner scanner = new Scanner(System.in);
	//private static Contact contact;
	//private static Manage_TodoList todolist;
	//private static Appointment appointment;
	static Contact_Manager contactManager;
	static TodoList_Manager todolistManager;

=======
	private static Scanner scanner = new Scanner(System.in);
	/*
	 * static final int CONTACT = 1; static final int TODOLIST = 2; static final int
	 * APPOINTMENT = 3; static final int QUIT = 4;
	 */
	//static Contact_Manager contactManager;
	static TodoList_Manager todolistManager;
	//static Appointment_Manager apointmentManager;
>>>>>>> 00d632f0a8bfc9924376a860cb2f97cd6ec164a2
	
	public static void main(String[] args) {
		selectHomeMenu();
	}
<<<<<<< HEAD
	
	static void selectHomeMenu() {
		
		boolean flag = true;
		//todolist = new Manage_TodoList();
		
		while(flag) {
			System.out.println("+----- Home Menu -----+");
			System.out.println("|   1. Contact        |");
			System.out.println("|   2. To-do List     |");
			System.out.println("|   3. Appointment    |");
			System.out.println("|   4. Quit           |");
			System.out.println("+---------------------+");
=======
>>>>>>> 00d632f0a8bfc9924376a860cb2f97cd6ec164a2

	private static void selectHomeMenu() {
		boolean isHomeMenu = true;

		while (isHomeMenu) {
			showHomeMenu();
			homeChoice = scanner.nextInt();

			if (homeChoice == 1) {
<<<<<<< HEAD
				//contact
				System.out.println("+-------Contact-------+");
				contactManager = new Contact_Manager();
				contactManager.manageContact();
				

			} else if (homeChoice == 2) {
				//todolist
				System.out.println("+------To-do List-----+");
				todolistManager = new TodoList_Manager();
				todolistManager.manageTodoList();		
			
			} else if (homeChoice == 3) {
				//appointment
				System.out.println("+-----Appointment-----+");


			} else if (homeChoice == 4) {
				System.out.println("*** Thank You! Bye! ***");
				flag = false;
=======
				System.out.println("+---------------------------Contact----------------------------+");

			} else if (homeChoice == 2) {
				System.out.println("+---------------------------To-do List--------------------------+");
				todolistManager = new TodoList_Manager();
				todolistManager.manageTodoList();
			} else if (homeChoice == 3) {
				System.out.println("+------------------------Appointment-------------------------+");
			} else if (homeChoice == 4) {
				System.out.println("**********************Thank You! Bye!*************************");
				isHomeMenu = false;
>>>>>>> 00d632f0a8bfc9924376a860cb2f97cd6ec164a2
			}
		}
	}

	private static void showHomeMenu() {
		System.out.println("+-------------------------Home Menu-------------------------+");
		System.out.println("||   [1] Contact    [2] To-do List    [3] Appointment    [4] Quit  ||");
		System.out.println("+----------------------------------------------------------------+");
		System.out.print("Choose Home Menu: ");
	}
}
