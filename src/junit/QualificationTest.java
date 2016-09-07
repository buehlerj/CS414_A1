package junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cs414.a1.buehlerj.*;

public class QualificationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testQualificationConstructor() {
		Qualification test_qualification = new Qualification("Test Qualification");
		assertEquals(test_qualification.getClass(), Qualification.class);
	}

	@Test
	public void testGetName() {
		Qualification test_qualification = new Qualification("Test Qualification");
		assertEquals(test_qualification, Qualification.class);
	}

}
