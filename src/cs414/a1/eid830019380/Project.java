package cs414.a1.eid830019380;
import java.util.ArrayList;

public class Project {
	String name;
	ProjectSize size;
	ProjectStatus status;
	Company company;
	ArrayList<Worker> workers = new ArrayList<Worker>();
	ArrayList<Qualification> requires = new ArrayList<Qualification>();

	public Project (String name, ProjectSize size, ProjectStatus status) {
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

	@Override
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

	public boolean isHelpful (Worker w) {
		if (w.isQualifiedFor == null)
			return false;
		ArrayList<Qualification> qualities_needed_for_project = missingQualifications();
		for (int i = 0; i < qualities_needed_for_project.size(); i++) {
			if (w.isQualifiedFor.contains(qualities_needed_for_project.get(i))) {
				return true;
			}
		}
		return false;
	}
}
