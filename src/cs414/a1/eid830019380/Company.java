package cs414.a1.eid830019380;
import java.util.ArrayList;

public class Company {
	String name;
	ArrayList<Worker> availableWorkerPool = new ArrayList<Worker>();
	ArrayList<Worker> assignedWorkerPool = new ArrayList<Worker>();
	ArrayList<Project> workingOn = new ArrayList<Project>();

	public Company (String name) {
		this.name = name;
	}

	public String getName () { //
		return name;
	}

	public ArrayList<Worker> getAvailableWorkers () { //
		return availableWorkerPool;
	}

	public ArrayList<Worker> getAssignedWorkers () {
		return assignedWorkerPool;
	}

	public ArrayList<Worker> getUnassignedWorkers () {
		ArrayList<Worker> unassigned_workers = new ArrayList<Worker> (availableWorkerPool);
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
		if (!availableWorkerPool.contains(w)) {
			System.out.println("Worker not available");
			return -1;
		}
		else if (p.getStatus() != ProjectStatus.ACTIVE || p.getStatus() != ProjectStatus.FINISHED) {
			System.out.println("This project is already " + p.getStatus());
			return -2;
		}
		else if (w.willOverload(p)) {
			System.out.println("This project will overload this poor worker.");
			return -3;
		}
		else if (p.isHelpful(w)) {
			if (!assignedWorkerPool.contains(w))
				assignedWorkerPool.add(w);
			p.workers.add(w);
			return 1;
		}
		else {
			System.out.println("Well, I don't know what to do for you. Sorry!");
			return -4;
		}
	}

	public void unassign (Worker w, Project p) {
		if (!p.workers.contains(w))
			System.out.println("This Worker is not assigned to this project and will not be removed.");
		else {
			p.workers.remove(w);
			if (w.projectsAssignedTo.isEmpty()) {
				assignedWorkerPool.remove(w);
			}
			if (p.getStatus() == ProjectStatus.ACTIVE && !p.missingQualifications().isEmpty()) {
				p.setStatus(ProjectStatus.SUSPENDED);
			}
		}
	}

	public void unassignAll (Worker w) {
		ArrayList<Project> former_projects = new ArrayList<Project> (w.projectsAssignedTo);
		w.projectsAssignedTo.clear();
		assignedWorkerPool.remove(w);
		for (int i = 0; i < former_projects.size(); i++) {
			if (former_projects.get(i).getStatus() == ProjectStatus.ACTIVE && !former_projects.get(i).missingQualifications().isEmpty()) {
				former_projects.get(i).setStatus(ProjectStatus.SUSPENDED);
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
			for (int i = 0; i < p.workers.size(); i++) {
				if (p.workers.get(i).projectsAssignedTo.size() <= 1) {
					assignedWorkerPool.remove(p.workers.get(i));
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

	public void createProject (String n, ArrayList<Qualification> qs, ProjectSize size) {
		Project created_project = new Project(n, size, ProjectStatus.PLANNED);
		for (int i = 0; i < qs.size(); i++) {
			created_project.requires.add(qs.get(i));
		}
		workingOn.add(created_project);
	}
}
