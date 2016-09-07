package cs414.a1.eid830019380;
import java.util.ArrayList;

public class Worker {
	String name;
	Double salary;
	Company companyAvailableTo;
	Company companyAssignedTo;
	ArrayList<Project> projectsAssignedTo = new ArrayList<Project>();
	ArrayList<Qualification> isQualifiedFor = new ArrayList<Qualification>();

	public Worker (String name, ArrayList<Qualification> qs) {
		this.name = name;
		isQualifiedFor = qs;
	}

	public String getName () {
		return name;
	}

	public Double getSalary () {
		return salary;
	}

	public void setSalary (Double salary) {
		this.salary = salary;
	}

	public ArrayList<Qualification> getQualifications () {
		return isQualifiedFor;
	}

	public void addQualification (Qualification q) {
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
		ArrayList<Project> projects = this.projectsAssignedTo;
		projects.add(p);
		for (int i = 0; i < projects.size(); i++) {
			switch(projects.get(i).getSize()) {
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
		if ((3 * number_of_big_projects + 2 * number_of_medium_projects + number_of_small_projects) > 12)
			return true;
		return false;
	}

}
