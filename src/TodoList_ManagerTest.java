import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TodoList_ManagerTest {
	 static final int CREATE = 1;
	   static final int VIEW = 2;
	   static final int UPDATE = 3;
	   static final int DELETE = 4;
	   static final int GOHOME = 5;
	   static ArrayList<TodoList> todolists = new ArrayList<TodoList>();
	   static TodoList_Manager todolistManager = new TodoList_Manager();
	   static final boolean SUCCESS = true;
	   static final boolean FAIL = false;
	   
	   @BeforeAll
	   static void initAll() {
		   todolists.add(new TodoList("18-12-01","18-12-11","December"));
		   todolists.add(new TodoList("18-12-02","18-12-12","The Last class"));
		   todolists.add(new TodoList("18-12-03","18-12-31","Assignment"));
	   }
	  
	@Test
	void testCreate() {
		TodoList todolist = new TodoList();
		assertTrue(todolistManager.create("18-12-01", "18-12-30", "Software engineering") == SUCCESS);
		assertTrue(todolistManager.create("18-12-07", "18-12-00", "Sookmyung Women's University") == FAIL);
		assertTrue(todolistManager.create("010101", "050605", "check your date please") == FAIL);
	}
	
	@Test
	void testUpdate() {
		TodoList todolist = new TodoList();
		assertTrue(todolistManager.update(todolists.get(0), "18-12-31", "18-12-01", "New Year") == FAIL);
		assertTrue(todolistManager.update(todolists.get(1), "18-12-25", "18-12-31", "Happy New Year") == SUCCESS);
		assertTrue(todolistManager.update(null, "18-11-25", "18-12-25", "merry christmas") == FAIL);
	}

	@Test
	void testDelete() {
		assertTrue(todolistManager.delete(10) == FAIL);
		assertTrue(todolistManager.delete(1) == SUCCESS);
	}
}