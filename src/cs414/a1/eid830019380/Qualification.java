package cs414.a1.eid830019380;
import java.util.ArrayList;

public class Qualification {
	String description;
	ArrayList<Worker> peopleWithQualification = new ArrayList<Worker>();
	ArrayList<Project> projectWithQualification = new ArrayList<Project>();

	public Qualification (String description) {
		this.description = description;
	}

	public static boolean equals () {
		System.out.println("UNIMPLEMENTED");
		return true;
	}

	@Override
	public String toString () {
		return description;
	}
}
