package cs414.a1.buehlerj;

import java.util.HashSet;
import java.util.Set;

public class Qualification {
	String description;
	Set<Worker> peopleWithQualification = new HashSet<Worker>();
	Set<Project> projectWithQualification = new HashSet<Project>();

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
