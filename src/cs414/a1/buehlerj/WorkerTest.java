package cs414.a1.buehlerj;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class WorkerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCompanyConstructor() {
		Worker test_worker = new Worker("Test Worker", null);
		assertEquals(test_worker.getClass(), Worker.class);
	}

	@Test
	public void testGetName() {
		Worker test_worker = new Worker("Test Worker", null);
		assertEquals(test_worker.getName(), "Test Worker");
	}

	@Test
	public void testDefaultSalary() {
		Worker test_worker = new Worker("Test Worker", null);
		assertTrue(Math.abs(0.0 - test_worker.getSalary()) == 0.0);
	}

	@Test
	public void testNegativeSalary() {
		Worker test_worker = new Worker("Test Worker", null);
		test_worker.setSalary(-1500.23);
		assertTrue(Math.abs(0.0 - test_worker.getSalary()) == 0.0);
	}

	@Test
	public void testSalary() {
		Worker test_worker = new Worker("Test Worker", null);
		test_worker.setSalary(1500.23);
		assertTrue(Math.abs(1500.23 - test_worker.getSalary()) == 0.0);
	}

	@Test
	public void testGetQualifications() {
		Qualification q1 = new Qualification("Qualification1");
		Set<Qualification> qualifications = new HashSet<Qualification>();
		qualifications.add(q1);
		Worker test_worker = new Worker("Test Worker", qualifications);
		assertEquals(test_worker.getQualifications(), qualifications);
	}

	@Test
	public void testAddQualifications() {
		Qualification q1 = new Qualification("Qualification1");
		Set<Qualification> qualifications = new HashSet<Qualification>();
		qualifications.add(q1);
		Worker test_worker = new Worker("Test Worker", null);
		test_worker.addQualification(q1);
		assertEquals(test_worker.getQualifications(), qualifications);
	}

	@Test
	public void testAddExistingQualification() {
		Qualification q1 = new Qualification("Qualification1");
		Set<Qualification> qualifications = new HashSet<Qualification>();
		qualifications.add(q1);
		Worker test_worker = new Worker("Test Worker", null);
		test_worker.addQualification(q1);
		test_worker.addQualification(q1);
		assertEquals(test_worker.getQualifications(), qualifications);
	}

	@Test
	public void testToStringEmpty() {
		Worker test_worker = new Worker("Test Worker", null);
		assertEquals(test_worker.toString(), "Test Worker:0:0:0.0");
	}

	@Test
	public void testToStringFull() {
		Qualification q1 = new Qualification("Qualification1");
		Set<Qualification> qualifications = new HashSet<Qualification>();
		qualifications.add(q1);
		Worker test_worker = new Worker("Test Worker", qualifications);
		test_worker.setSalary(12.83);
		assertEquals(test_worker.toString(), "Test Worker:0:1:12.83");
	}

	@Test
	public void testWillOverload() {
		Company test_company = new Company("Test Company");
		Qualification q1 = new Qualification("Qualification1");
		Set<Qualification> qualifications = new HashSet<Qualification>();
		qualifications.add(q1);
		Project p1 = test_company.createProject("Test Project 1", qualifications, ProjectSize.BIG);
		Project p2 = test_company.createProject("Test Project 2", qualifications, ProjectSize.BIG);
		Project p3 = test_company.createProject("Test Project 3", qualifications, ProjectSize.BIG);
		Project p4 = test_company.createProject("Test Project 4", qualifications, ProjectSize.BIG);
		Project p5 = test_company.createProject("Test Project 4", qualifications, ProjectSize.SMALL);
		Worker test_worker = new Worker("Test Worker", qualifications);
		test_company.addToAvailableWorkerPool(test_worker);
		assertTrue(!test_worker.willOverload(p1));
		assertEquals(test_company.assign(test_worker, p1), 0);
		assertTrue(!test_worker.willOverload(p2));
		assertEquals(test_company.assign(test_worker, p2), 0);
		assertTrue(!test_worker.willOverload(p3));
		assertEquals(test_company.assign(test_worker, p3), 0);
		assertTrue(!test_worker.willOverload(p4));
		assertEquals(test_company.assign(test_worker, p4), 0);
		assertTrue(test_worker.willOverload(p5));
	}
}
