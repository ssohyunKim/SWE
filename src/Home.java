
import java.util.Scanner;

public class Home {

	private static int homeChoice;
	
	static Scanner scanner = new Scanner(System.in);
	//private static Contact contact;
	//private static Manage_TodoList todolist;
	//private static Appointment appointment;
	
	public static void main(String[] args) {
		selectHomeMenu();
	}
	
	static void selectHomeMenu() {
		
		boolean flag = true;
		//todolist = new Manage_TodoList();
		
		while(flag) {
			System.out.println("+---------------------+");
			System.out.println(" |  1. Contact              |");
			System.out.println(" |  2. To-do List          |");
			System.out.println(" |  3. Appointment     |");
			System.out.println(" |  4. Quit                   |");
			System.out.println("+---------------------+");

			homeChoice = scanner.nextInt();

			if (homeChoice == 1) {
				//contact
				System.out.println("+------Contact------+");

			} else if (homeChoice == 2) {
				//todolist
				System.out.println("+-----To-do List-----+");
				
			
			} else if (homeChoice == 3) {
				//appointment
				System.out.println("+---Appointment---+");


			} else if (homeChoice == 4) {
				System.out.println("***Thank You! Bye!***");
				flag = false;
			}
		}
	}
}