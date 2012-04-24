import org.junit.*;
import java.util.*;

import play.test.*;
import models.*;

public class UserTest extends UnitTest {
	
	@Before
	public void setup() {
		Fixtures.deleteDatabase();
		Fixtures.loadModels("data.yml");
	}
	
	@Test
	public void retrieveUser() {
	    User diego = User.find("byEmail", "daniel@gmail.com").first();
	    
	    assertNotNull(diego);
	    assertEquals("Daniel", diego.firstname);
	}
	
	@Test
	public void connectAsUser() {
	    assertNotNull(User.connect("daniel@gmail.com", "secret"));
	    assertNull(User.connect("daniel@gmail.com", "badpassword"));
	    assertNull(User.connect("tom@gmail.com", "secret"));
	}
	
//	@Test
//	public void useTheLocationsRelation() {
//	    User daniel = User.find("byEmail", "daniel@gmail.com").first();
//	    
//	    daniel.addLocation(daniel, "gua", "bugaMbilia", null, "Guatemala", "Guatemala", "009823", "Guatemala", "5024447856");   
//	    List<Location> danielLocations = Location.find("byUser", daniel).fetch();
//	    
//	    assertEquals(1,danielLocations.size());
//	}

	@After
	public void cleanup() {
//		User daniel = User.find("byEmail", "daniel@gmail.com").first();
		
//		List<Location> danielLocations = Location.find("byUser", daniel).fetch();
//		
//		// drop locations
//		Iterator<Location> it = danielLocations.iterator();
//		while(it.hasNext()) {
//			it.next().delete();
//		}
		
		// drop user
//		daniel.delete();
		
	}

}
