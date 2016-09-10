package cs414.a1.buehlerj;

import java.util.HashSet;
import java.util.Set;

public class Project {
	String name;
	ProjectSize size;
	ProjectStatus status;
	Company company;
	Set<Worker> workers = new HashSet<Worker>();
	Set<Qualification> requires = new HashSet<Qualification>();

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

	public Set<Qualification> missingQualifications () {
		Set<Qualification> requirements = new HashSet<Qualification> (this.requires);
		Set<Qualification> workers_qualifications = new HashSet<Qualification> ();
		for (Worker worker : this.workers) {
			workers_qualifications.addAll(worker.getQualifications());
		}
		requirements.removeAll(workers_qualifications);
		return requirements;
	}

	public boolean isHelpful (Worker w) {
		if (w.isQualifiedFor == null)
			return false;
		Set<Qualification> qualifications_needed_for_project = missingQualifications();
		for (Qualification qualification : qualifications_needed_for_project ) {
			if (w.isQualifiedFor.contains(qualification)) {
				return true;
			}
		}
		return false;
	}
}
