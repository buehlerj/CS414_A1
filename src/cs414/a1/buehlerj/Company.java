package cs414.a1.buehlerj;

import java.util.HashSet;
import java.util.Set;

public class Company {
	String name;
	Set<Worker> availableWorkerPool = new HashSet<Worker>();
	Set<Worker> assignedWorkerPool = new HashSet<Worker>();
	Set<Project> workingOn = new HashSet<Project>();

	public Company (String name) {
		this.name = name;
	}

	public String getName () { //
		return name;
	}

	public Set<Worker> getAvailableWorkers () { //
		return availableWorkerPool;
	}

	public Set<Worker> getAssignedWorkers () {
		return assignedWorkerPool;
	}

	public Set<Worker> getUnassignedWorkers () {
		Set<Worker> unassigned_workers = new HashSet<Worker> (availableWorkerPool);
		unassigned_workers.removeAll(assignedWorkerPool);
		return unassigned_workers;
	}

	public boolean equals () {
		System.out.println("UNIMPLEMENTED");
		return true;
	}

	@Override
	public String toString () {
		return name + ":" + getAvailableWorkers().size() + ":" + workingOn.size();
	}

	public void addToAvailableWorkerPool (Worker w) {
		availableWorkerPool.add(w);
	}

	public int assign (Worker w, Project p) {
		if (p.getStatus() == ProjectStatus.ACTIVE) {
			System.out.println("This project is already " + p.getStatus());
			return -1;
		}
		if (p.getStatus() == ProjectStatus.FINISHED) {
			System.out.println("This project is already " + p.getStatus());
			return -2;
		}
		if (!availableWorkerPool.contains(w)) {
			System.out.println("Worker not available");
			return -3;
		}
		if (w.willOverload(p)) {
			System.out.println("This project will overload this poor worker.");
			return -4;
		}
		if (p.isHelpful(w)) {
			if (!assignedWorkerPool.contains(w))
				assignedWorkerPool.add(w);
			p.workers.add(w);
			w.projectsAssignedTo.add(p);
			return 0;
		}
		System.out.println("Worker is not helpful.");
		return -5;
	}

	public int unassign (Worker w, Project p) {
		if (!p.workers.contains(w)) {
			System.out.println("This Worker is not assigned to this project and will not be removed.");
			return -1;
		}
		else {
			p.workers.remove(w);
			if (w.projectsAssignedTo.isEmpty()) {
				assignedWorkerPool.remove(w);
			}
			if (p.getStatus() == ProjectStatus.ACTIVE && !p.missingQualifications().isEmpty()) {
				p.setStatus(ProjectStatus.SUSPENDED);
			}
			return 0;
		}
	}

	public void unassignAll (Worker w) {
		Set<Project> former_projects = new HashSet<Project> (w.projectsAssignedTo);
		w.projectsAssignedTo.clear();
		assignedWorkerPool.remove(w);
		for (Project project : former_projects) {
			if (project.getStatus() == ProjectStatus.ACTIVE && !project.missingQualifications().isEmpty()) {
				project.setStatus(ProjectStatus.SUSPENDED);
			}
		}
	}

	public void start (Project p) {
		switch (p.getStatus()) {
		case PLANNED:
		case SUSPENDED:
			if (p.missingQualifications().isEmpty())
				p.setStatus(ProjectStatus.ACTIVE);
			else
				System.out.println("Qualifications not met and project will not be started.");
			break;
		default:
			System.out.println("Project already ACTIVE or FINISHED and cannot start.");
			break;
		}
	}

	public void finish (Project p) {
		switch (p.getStatus()) {
		case ACTIVE:
			p.setStatus(ProjectStatus.FINISHED);
			for (Worker worker : p.workers) {
				if (worker.projectsAssignedTo.size() <= 1) {
					assignedWorkerPool.remove(worker);
				}
			}
			p.workers.clear();
			break;
		case FINISHED:
			System.out.println("Project already marked as FINISHED.");
			break;
		default:
			System.out.println("Project SUSPENDED or PLANNED and is not ready to be finished.");
			break;
		}
	}

	public Project createProject (String n, Set<Qualification> qs, ProjectSize size) {
		Project created_project = new Project(n, size, ProjectStatus.PLANNED);
		for (Qualification qualification : qs) {
			created_project.requires.add(qualification);
		}
		workingOn.add(created_project);
		return created_project;
	}
}
