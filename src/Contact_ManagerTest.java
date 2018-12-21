import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Test;

public class Contact_ManagerTest {
	static final int CREATE = 1;
	static final int VIEW = 2;
	static final int UPDATE = 3;
	static final int DELETE = 4;
	static final int GOHOME = 5;	  
	static ArrayList<Contact> contacts = new ArrayList<Contact>();
    static Contact_Manager contactManager = new Contact_Manager();
	static final boolean SUCCESS = true;
	static final boolean FAIL = false;
	

	@BeforeAll
	static void initAll() {
		contacts.add(new Contact("±è¼ÒÇö","010-9928-6676","blumen122@sookmyung.ac.kr"));
		contacts.add(new Contact("½Å¼ö»ê","010-1234-6676","soosani@sookmyung.ac.kr"));
		contacts.add(new Contact("±èÀÌÁø","010-5678-6676","dlwlsdl@sookmyung.ac.kr"));
	}
	   
	@Test
	public void TestCreate() {
		Contact contact = new Contact();
		assertEquals(true, contactManager.create("±èÁöÇö", "010-5130-6676", "jih1219@naver.com"));
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact();
	    assertTrue(contactManager.update(contacts.get(0), "±è¶¯¶¯", "010-1345-2341", "dlekjp@gmail.com") == SUCCESS);
	}
	
	@Test
	void testDelete() {
	   Contact contact = new Contact();
	   assertTrue(contactManager.delete(4) == FAIL);
	}
	
}
