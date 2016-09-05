import java.util.ArrayList;

public class Project {
	String name;
	ProjectSize size;
	ProjectStatus status;
	Company company;
	ArrayList<Worker> workers = new ArrayList<Worker>();
	ArrayList<Qualification> requires = new ArrayList<Qualification>();

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
		return name + ":" + workers.size() + ":" + status;
	}

	public ArrayList<Qualification> missingQualifications () {
		ArrayList<Qualification> requirements = new ArrayList<Qualification> (this.requires);
		ArrayList<Qualification> workers_qualifications = new ArrayList<Qualification> ();
		for (int i = 0; i < this.workers.size(); i++) {
			workers_qualifications.addAll(this.workers.get(i).getQualifications());
		}
		requirements.removeAll(workers_qualifications);
		return requirements;
	}

	public static boolean isHelpful (Worker w) {
		System.out.println("UNIMPLEMENTED");
		return true;
	}
}
