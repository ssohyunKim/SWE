import java.util.ArrayList;
import java.util.Scanner;

public class Contact_Manager extends Asset_Manager{
	private Scanner scanner = new Scanner(System.in);
	private static int subMenuChoice = 0;
	static final int CREATE = 1;
	static final int VIEW = 2;
	static final int UPDATE = 3;
	static final int DELETE = 4;
	static final int GOHOME = 5;
	boolean isSuccess = true;
	protected ArrayList<Contact> contacts = new ArrayList<Contact>();
	private int deleteNumber;
	private String modifiedValue;
	private int number;
	int updateNumber;
	
	public void manageContact() {
		boolean isSubMenu = true;

		while (isSubMenu) {
			Asset_Manager assetManager = new TodoList_Manager();
			assetManager.showSubMenu();
			subMenuChoice = scanner.nextInt();

			if (subMenuChoice == CREATE) {
				create(contacts);
			} else if (subMenuChoice == VIEW) {
				view();
			} else if (subMenuChoice == UPDATE) {
				update(contacts);
			} else if (subMenuChoice == DELETE) {
				delete(contacts);
			} else if (subMenuChoice == GOHOME) {
				goHome();
				break;
			} else {
				System.out.println("Choose valid submenu!");
			}
		}
	}
	
	@Override
	boolean create(Object ob) {
		Contact contact = new Contact();
		System.out.print("Name: ");
		contact.setName(scanner.next());
		scanner.nextLine();
		System.out.print("Phone: ");
		contact.setPhone(scanner.next());
		scanner.nextLine();
		System.out.print("Email: ");
		contact.setEmail(scanner.nextLine());
		contacts.add(contact);
		System.out.println("Successfully Created!!\n");
		return isSuccess;
	}

	@Override
	void view() {
		System.out.printf("%1$-3s %2$10s %3$15s %4$30s\n", "No.", "Name", "Phone", "E-mail");
		System.out.println("----------------------------------------------------------------------");
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
		}
		int number = 1;
		if(contacts.size()==0) {
			System.out.println("EMPTY!!");
		}
		for (Contact contact : contacts) {
			System.out.printf("%1$3d/ %2$10s/ %3$15s/ %4$30s\n", number++, contact.getName(), contact.getPhone(), contact.getEmail());
		}
		
	}

	@Override
	boolean update(Object ob) {
		System.out.print("Number to update: ");
		updateNumber = scanner.nextInt();
		if (updateNumber > 0 && updateNumber <= contacts.size()) {
			Contact contact = contacts.get(updateNumber - 1);
			System.out.print("Name: ");
			modifiedValue = scanner.next();
			if (modifiedValue.length() > 0) {
				contact.setName(modifiedValue);
			}
			scanner.nextLine();
			System.out.print("Phone: ");
			modifiedValue = scanner.next();
			if (modifiedValue.length() > 0) {
				contact.setPhone(modifiedValue);
			}
			scanner.nextLine();
			System.out.print("E-mail: ");
			modifiedValue = scanner.nextLine();
			if (modifiedValue.length() > 0) {
				contact.setEmail(modifiedValue);
			}
			System.out.println("Successfully Modified!!\n");
		}
		return isSuccess;
	}

	@Override
	boolean delete(Object ob) {
		System.out.print("Number to delete: ");
		deleteNumber = scanner.nextInt();
		if (deleteNumber > 0 && deleteNumber <= contacts.size()) {
			contacts.remove(deleteNumber - 1);
			deleteNumber = 0;
			System.out.println("Successfully Deleted!!\n");
		}
		return isSuccess;
	}

	@Override
	void goHome() {

		System.out.println("Go to previous menu!!\n");
		
	}

}