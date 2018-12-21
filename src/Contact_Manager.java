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
			Asset_Manager assetManager = new Contact_Manager();
			assetManager.showSubMenu();
			subMenuChoice = scanner.nextInt();
			Contact contact = new Contact();

			if (subMenuChoice == CREATE) {
				System.out.print("Name: ");
				String name = scanner.next();
				scanner.nextLine();
				System.out.print("Phone: ");
				String phone = scanner.next();
				scanner.nextLine();
				System.out.print("Email: ");
				String email = scanner.nextLine();
				create(name, phone, email);
			} else if (subMenuChoice == VIEW) {
				view();
			} else if (subMenuChoice == UPDATE) {
				System.out.print("Number to update: ");
				updateNumber = scanner.nextInt();
				if(updateNumber <= 0 && updateNumber > contacts.size())
					break;
				
				contact  = contacts.get(updateNumber - 1);
					
				System.out.print("Name: ");
				String new_name = scanner.next();
				scanner.nextLine();
				System.out.print("Phone: ");
				String new_phone = scanner.next();
				scanner.nextLine();
				System.out.print("E-mail: ");
				String new_email = scanner.nextLine();
					
				update(contact, new_name, new_phone, new_email);
				
			} else if (subMenuChoice == DELETE) {
				System.out.print("Number to delete: ");
				int deleteNumber = scanner.nextInt();
				scanner.nextLine();
				delete(deleteNumber);
			} else if (subMenuChoice == GOHOME) {
				goHome();
				break;
			} else {
				System.out.println("Choose valid submenu!");
			}
		}
	}
	
	@Override
	boolean create(String name, String phone, String email) {
		Contact contact = new Contact();
		contact.setName(name);
		contact.setPhone(phone);
		contact.setEmail(email);
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
	boolean update(Object contact, String name, String phone, String email) {
		((Contact)contact).setName(name);
		((Contact)contact).setPhone(phone);
		((Contact)contact).setEmail(email);
		
		return isSuccess;
	}

	@Override
	boolean delete(int delete_no) {
		if(delete_no <=0 || delete_no > contacts.size()) {
			System.out.println("Don't exist!!");
			return false;
		}
		Contact contact = contacts.get(delete_no - 1);
		contacts.remove(contact);
		System.out.println("Successfully deleted!!");
		return isSuccess;
	}

	@Override
	void goHome() {
		System.out.println("Go to previous menu!!\n");
	}

}
