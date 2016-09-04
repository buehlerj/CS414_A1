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

	public Worker[] getAvailableWorkers () {
		System.out.println("UNIMPLEMENTED");
		return null;
	}

	public Worker[] getAssignedWorkers () {
		System.out.println("UNIMPLEMENTED");
		return null;
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
		return "UNIMPLEMENTED";
	}

	public void addToAvailableWorkerPool (Worker w) {
		System.out.println("UNIMPLEMENTED");
	}

	public void assign (Worker w, Project p) {
		System.out.println("UNIMPLEMENTED");
	}

	public void unassign (Worker w, Project p) {
		System.out.println("UNIMPLEMENTED");
	}

	public void unnasign (Worker w) {
		System.out.println("UNIMPLEMENTED");
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
