

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	ManagementCompany company1;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		company1 = new ManagementCompany("SteveNTrev", "19301", 0.10, 0, 0, 10, 10);
		
		//student add three properties, with plots, to mgmt co
		company1.addProperty("Library", "Rockville", 10000, "Montgomery Couny" ); 
		company1.addProperty("Single Family", "Silver Spring", 3000, "Jerry", 8, 8, 2, 2); 
		company1.addProperty("Studio Apartment", "Germantown", 2500, "Juanita", 4, 1, 1, 1); 
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		company1 = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(company1.addProperty("Apartment", "Washington DC", 3000, "Ethan"), -4); 
		//student should add property with 8 args
		assertEquals(company1.addProperty("Single Family", "California", 4000, "Wang", 2, 8, 1,1), 3); 
		assertEquals(company1.addProperty("Ran Out Of Names", "New York", 5000, "Wang", 1, 1, 1, 1), 4); 
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		assertEquals(company1.addProperty("Big Country", "Texas", 700, "Wang", 9, 6, 1, 1), -1); 
	}
 
	@Test
	public void testMaxRentProp() {
		
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(company1.maxRentProp(), 10000, .0001);
	}

	@Test
	public void testTotalRent() {
		
		//student should test if totalRent returns the total rent of properties
		assertEquals(company1.totalRent(), 15500, .0001);
	}

 }