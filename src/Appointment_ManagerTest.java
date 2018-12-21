import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Appointment_ManagerTest {
	static final int CREATE = 1;
	static final int VIEW = 2;
	static final int UPDATE = 3;
	static final int DELETE = 4;
	static final int GOHOME = 5;
	static ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	static Appointment_Manager appointmentManager = new Appointment_Manager();
	static final boolean SUCCESS = true;
	static final boolean FAIL = false;
	
	@BeforeAll
	static void initAll() {
		appointments.add(new Appointment("18-12-20","�Ľ���ġ","������"));
		appointments.add(new Appointment("18-12-21","�ұ�","Todd"));
		appointments.add(new Appointment("18-12-22","����","�ڿ���"));
	}
	
	@Test
	void testCreate() {
		assertTrue(appointmentManager.create("18-12-21","��","�ż���") == SUCCESS);
		assertTrue(appointmentManager.create("181221","��","�ż���") == FAIL);
		assertTrue(appointmentManager.create("18-12-50","��","�ż���") == FAIL);
	}

	@Test
	void testUpdate() {
		assertTrue(appointmentManager.update(appointments.get(0), "", "", "") == FAIL);
		assertTrue(appointmentManager.update(appointments.get(0), "18-12-24", "������", "����") == SUCCESS);
		assertTrue(appointmentManager.update(null, "18-12-24", "������", "����") == FAIL);
	}

	@Test
	void testDelete() {
		assertTrue(appointmentManager.delete(5) == FAIL);
		assertTrue(appointmentManager.delete(1) == SUCCESS);
	}

}
