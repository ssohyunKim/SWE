abstract class Asset_Manager {
	abstract boolean create(String parm1, String parm2, String parm3);
	abstract void view();
	abstract boolean update(String parm1, String parm2, String parm3);
	abstract boolean delete(Object ob);
	abstract void goHome();
	
	void showSubMenu() {
		System.out.println("+------ Sub Menu -----+");
		System.out.println("|   1. Create         |");
		System.out.println("|   2. View           |");
		System.out.println("|   3. Update         |");
		System.out.println("|   4. Delete         |");
		System.out.println("|   5. Home           |");
		System.out.println("+---------------------+");
//		System.out.println("+--------------------------Sub Menu--------------------------+");
//		System.out.println("| 1) Create | 2) View  | 3) Update | 4) Delete | 5) Go Home  |");
//		System.out.println("+------------------------------------------------------------+");
	}
}
