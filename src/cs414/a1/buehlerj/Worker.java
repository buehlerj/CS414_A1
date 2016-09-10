package cs414.a1.buehlerj;
import java.util.HashSet;
import java.util.Set;

public class Worker {
	String name;
	Double salary = 0.0;
	Company companyAvailableTo;
	Company companyAssignedTo;
	Set<Project> projectsAssignedTo = new HashSet<Project>();
	Set<Qualification> isQualifiedFor = new HashSet<Qualification>();

	public Worker (String name, Set<Qualification> qs) {
		this.name = name;
		if (qs != null)
			isQualifiedFor = qs;
	}

	public String getName () {
		return name;
	}

	public Double getSalary () {
		return salary;
	}

	public void setSalary (Double salary) {
		if (salary < 0.0)
			System.out.println("Cannot have a negative salary.");
		else
			this.salary = salary;
	}

	public Set<Qualification> getQualifications () {
		return isQualifiedFor;
	}

	public void addQualification (Qualification q) {
		if (isQualifiedFor.contains(q))
			System.out.println("Worker already has this qualification");
		else
			isQualifiedFor.add(q);
	}

	public boolean equals () {
		System.out.println("UNIMPLEMENTED");
		return false;
	}

	@Override
	public String toString () {
		return name + ":" + projectsAssignedTo.size() + ":" + isQualifiedFor.size() + ":" + salary;
	}

	public boolean willOverload (Project p) {
		int number_of_big_projects = 0;
		int number_of_medium_projects = 0;
		int number_of_small_projects = 0;
		Set<Project> projects = this.projectsAssignedTo;
		if (projects.isEmpty()) {
			return false;
		}
		for (Project project : projects) {
			switch(project.getSize()) {
			case BIG:
				number_of_big_projects += 1;
				break;
			case MEDIUM:
				number_of_medium_projects += 1;
				break;
			case SMALL:
				number_of_small_projects += 1;
				break;
			}
		}
		int new_project_size = 0;
		switch(p.getSize()){
		case BIG:
			new_project_size = 3;
			break;
		case MEDIUM:
			new_project_size = 2;
			break;
		case SMALL:
			new_project_size = 1;
			break;
		}
		if ((3 * number_of_big_projects + 2 * number_of_medium_projects + number_of_small_projects + new_project_size) > 12) {
			return true;
		}
		return false;
	}

}
