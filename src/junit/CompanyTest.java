package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a1.buehlerj.*;

public class CompanyTest {
	@Before
	public void setUpBefore() throws Exception {
	}

	@After
	public void tearDownAfter() throws Exception {
	}

	@Test
	public void testCompanyConstructor() {
		Company test_company = new Company("Test Company");
		assertEquals(test_company.getClass(), Company.class);
	}

	@Test
	public void testGetName() {
		Company test_company = new Company("Test Company");
		assertEquals(test_company.getName(), "Test Company");
	}

	@Test
	public void testAvailableWorkers() {
		Company test_company = new Company("Test Company");
		Worker test_worker = new Worker("Test Worker", null);
		test_company.addToAvailableWorkerPool(test_worker);
		ArrayList<Worker> expected_workers = new ArrayList<Worker>();
		expected_workers.add(test_worker);
		assertEquals(test_company.getAvailableWorkers(), expected_workers);
	}

	@Test
	public void testAvailableWorkersEmpty() {
		Company test_company = new Company("Test Company");
		ArrayList<Worker> expected_workers = new ArrayList<Worker>();
		assertEquals(test_company.getAvailableWorkers(), expected_workers);
	}

	@Test
	public void testAssignedWorkersEmpty() {
		Company test_company = new Company("Test Company");
		ArrayList<Worker> expected_workers = new ArrayList<Worker>();
		assertEquals(test_company.getAssignedWorkers(), expected_workers);
	}

	@Test
	public void testAssignUnavailableWorker() {
		Company test_company = new Company("Test Company");
		Worker test_worker = new Worker("Test Worker", null);
		Project test_project = new Project("Test Poject", ProjectSize.SMALL, ProjectStatus.PLANNED);
		test_company.assign(test_worker, test_project);
		assertTrue(test_company.getAvailableWorkers().isEmpty());
	}

	@Test
	public void testAssignStatusIsActive() {
		Company test_company = new Company("Test Company");
		Worker test_worker = new Worker("Test Worker", null);
		Project test_project = new Project("Test Poject", ProjectSize.SMALL, ProjectStatus.ACTIVE);
		test_company.addToAvailableWorkerPool(test_worker);
		test_company.assign(test_worker, test_project);
		assertEquals(test_company.getAvailableWorkers().size(), 1);
	}
}
