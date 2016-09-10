package cs414.a1.buehlerj;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		Set<Worker> expected_workers = new HashSet<Worker>();
		expected_workers.add(test_worker);
		assertEquals(test_company.getAvailableWorkers(), expected_workers);
	}

	@Test
	public void testAvailableWorkersEmpty() {
		Company test_company = new Company("Test Company");
		Set<Worker> expected_workers = new HashSet<Worker>();
		assertEquals(test_company.getAvailableWorkers(), expected_workers);
	}

	@Test
	public void testAssignedWorkersEmpty() {
		Company test_company = new Company("Test Company");
		Set<Worker> expected_workers = new HashSet<Worker>();
		assertEquals(test_company.getAssignedWorkers(), expected_workers);
	}

	@Test
	public void testAssignStatusIsActive() {
		Company test_company = new Company("Test Company");
		Worker test_worker = new Worker("Test Worker", null);
		Project test_project = new Project("Test Poject", ProjectSize.SMALL, ProjectStatus.ACTIVE);
		test_company.addToAvailableWorkerPool(test_worker);
		int result = test_company.assign(test_worker, test_project);
		assertEquals(test_company.getAvailableWorkers().size(), 1);
		assertEquals(result, -1);
	}

	@Test
	public void testAssignStatusIsFinished() {
		Company test_company = new Company("Test Company");
		Worker test_worker = new Worker("Test Worker", null);
		Project test_project = new Project("Test Poject", ProjectSize.SMALL, ProjectStatus.FINISHED);
		test_company.addToAvailableWorkerPool(test_worker);
		int result = test_company.assign(test_worker, test_project);
		assertEquals(test_company.getAvailableWorkers().size(), 1);
		assertEquals(result, -2);
	}

	@Test
	public void testAssignUnavailableWorker() {
		Company test_company = new Company("Test Company");
		Worker test_worker = new Worker("Test Worker", null);
		Project test_project = new Project("Test Poject", ProjectSize.SMALL, ProjectStatus.PLANNED);
		int result = test_company.assign(test_worker, test_project);
		assertTrue(test_company.getAvailableWorkers().isEmpty());
		assertEquals(result, -3);
	}

	@Test
	public void testUnassignNotAssigned() {
		Company test_company = new Company("Test Company");
		Worker test_worker = new Worker("Test Worker", null);
		Project test_project = new Project("Test Poject", ProjectSize.SMALL, ProjectStatus.PLANNED);
		int result = test_company.unassign(test_worker, test_project);
		assertEquals(result, -1);
	}

	@Test
	public void testUnassignCorrectly() {
		Company test_company = new Company("Test Company");
		Worker test_worker = new Worker("Test Worker", null);
		Project test_project = new Project("Test Poject", ProjectSize.SMALL, ProjectStatus.PLANNED);
		test_company.assign(test_worker, test_project);
		int result = test_company.unassign(test_worker, test_project);
		assertEquals(result, -1);
	}
}
