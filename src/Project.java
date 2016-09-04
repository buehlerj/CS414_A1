
public class Project {
	String name;
	ProjectSize size;
	ProjectStatus status;

	Project (String name, ProjectSize size, ProjectStatus status) {
		this.name = name;
		this.size = size;
		this.status = status;
	}

	public String getName () {
		return name;
	}

	public ProjectSize getSize () {
		return size;
	}

	public ProjectStatus getStatus () {
		return status;
	}

	public void setStatus (ProjectStatus status) {
		this.status = status;
	}

	public static boolean equals () {
		System.out.println("UNIMPLEMENTED");
		return false;
	}

	public String toString () {
		return "UNIMPLEMENTED";
	}

	public static Qualification[] missingQualifications () {
		System.out.println("UNIMPLEMENTED");
		return null;
	}

	public static boolean isHelpful (Worker w) {
		System.out.println("UNIMPLEMENTED");
		return true;
	}
}
