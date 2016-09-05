import java.util.ArrayList;

public class Company {
	String name;
	ArrayList<Worker> availableWorkerPool = new ArrayList<Worker>();
	ArrayList<Worker> assignedWorkerPool = new ArrayList<Worker>();
	ArrayList<Project> workingOn = new ArrayList<Project>();

	Company (String name) {
		this.name = name;
	}

	public String getName () {
		return name;
	}

	public ArrayList<Worker> getAvailableWorkers () {
		return availableWorkerPool;
	}

	public ArrayList<Worker> getAssignedWorkers () {
		return assignedWorkerPool;
	}

	public Worker[] getUnassignedWorkers () {
		System.out.println("UNIMPLEMENTED");
		return null;
	}

	public boolean equals () {
		System.out.println("UNIMPLEMENTED");
		return false;
	}

	@Override
	public String toString () {
		return name + ":" + getAvailableWorkers().size() + ":" + workingOn.size();
	}

	public void addToAvailableWorkerPool (Worker w) {
		availableWorkerPool.add(w);
	}

	public void assign (Worker w, Project p) {
		System.out.println("UNIMPLEMENTED");
	}

	public void unassign (Worker w, Project p) {
		if (!p.workers.contains(w))
			System.out.println("Worker not assigned to this project and will not be removed.");
		else {
			p.workers.remove(w);
			if (w.projectsAssignedTo.isEmpty()) {
				assignedWorkerPool.remove(w);
			}
			// TODO: If the qualification requirements of an ACTIVE project are no longer met, that project is marked SUSPENDED. A PLANNED OR SUSPENDED project remains in that state.
		}
	}

	public void unnasignAll (Worker w) {
		for (int i = 0; i < w.projectsAssignedTo.size(); i++) {
			Project project = w.projectsAssignedTo.get(i);
			// TODO: Change the state of the affected projects as needed
		}
		w.projectsAssignedTo.clear();
		assignedWorkerPool.remove(w);
		availableWorkerPool.add(w);
	}

	public void start (Project p) {
		System.out.println("UNIMPLEMENTED");
	}

	public void finish (Project p) {
		System.out.println("UNIMPLEMENTED");
	}

	public void createProject (String n, Qualification[] qs, ProjectSize size) {
		System.out.println("UNIMPLEMENTED");
	}
}
