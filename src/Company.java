
public class Company {
	static String name;

	Company (String name) {
		System.out.println("UNIMPLEMENTED");
	}

	public static void main(String[] args) {

	}

	public static String getName () {
		System.out.println("UNIMPLEMENTED");
		return null;
	}

	public static Worker[] getAvailableWorkers () {
		System.out.println("UNIMPLEMENTED");
		return null;
	}

	public static Worker[] getAssignedWorkers () {
		System.out.println("UNIMPLEMENTED");
		return null;
	}

	public static Worker[] getUnassignedWorkers () {
		System.out.println("UNIMPLEMENTED");
		return null;
	}

	public static boolean equals () {
		System.out.println("UNIMPLEMENTED");
		return false;
	}

	@Override
	public String toString () {
		System.out.println("UNIMPLEMENTED");
		return null;
	}

	public static void addToAvailableWorkerPool (Worker w) {
		System.out.println("UNIMPLEMENTED");
	}

	public static void assign (Worker w, Project p) {
		System.out.println("UNIMPLEMENTED");
	}

	public static void unassign (Worker w, Project p) {
		System.out.println("UNIMPLEMENTED");
	}

	public static void unnasign (Worker w) {
		System.out.println("UNIMPLEMENTED");
	}

	public static void start (Project p) {
		System.out.println("UNIMPLEMENTED");
	}

	public static void finish (Project p) {
		System.out.println("UNIMPLEMENTED");
	}

	public static void createProject (String n, Qualification[] qs, ProjectSize size) {
		System.out.println("UNIMPLEMENTED");
	}
}
