import java.util.ArrayList;

public class Qualification {
	String description;
	ArrayList<Worker> peopleWithQualification = new ArrayList<Worker>();
	ArrayList<Project> projectWithQualification = new ArrayList<Project>();

	Qualification (String description) {
		this.description = description;
	}

	public static boolean equals () {
		System.out.println("UNIMPLEMENTED");
		return true;
	}

	public String toString () {
		return "UNIMPLEMENTED";
	}
}
