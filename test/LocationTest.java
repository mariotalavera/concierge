import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class LocationTest extends UnitTest {
	
	@Before
	public void setup() {
		Fixtures.deleteDatabase();
		Fixtures.loadModels("data.yml");
	}
	
	@Test
	public void createLocations() {

		User diego = User.find("byEmail", "diego@gmail.com").first();

		List<Location> diegoLocations = Location.find("byUser", diego).fetch();

		assertEquals(1, diegoLocations.size());
		
		Location newLocation = diegoLocations.get(0);
		assertNotNull(newLocation);
		assertEquals("4417 Andover Cay",newLocation.addresslineone);
		assertEquals("32825",newLocation.zip);

		Location oldLocation = diegoLocations.get(1);
		assertNotNull(oldLocation);
		assertEquals("4932 Waterside Pointe Circle",oldLocation.addresslineone);
		assertEquals("32829",oldLocation.zip);

	}
	
	@After
	public void cleanup() {

//		User diego = User.find("byEmail", "diego@gmail.com").first();
//		List<Location> diegoLocations = Location.find("byUser", diego).fetch();
//		
//		// drop locations
//		Iterator<Location> it = diegoLocations.iterator();
//		while(it.hasNext()) {
//			it.next().delete();
//		}
//		
//		// drop user
//		diego.delete();
	}

}
