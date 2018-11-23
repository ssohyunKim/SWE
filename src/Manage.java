
abstract class Manage {
	abstract boolean create(Object ob);
	abstract void view();
	abstract boolean update(Object ob);
	abstract boolean delete(Object ob);
	abstract void goHome();
	
	void subMenu(int subChoice) {
		System.out.println("+-------------------------------------------------------------+");
		System.out.println(" | 1) Create | 2) View | 3) Update | 4) Delete | 5) Go Home |");
		System.out.println("+-------------------------------------------------------------+");
	}
}