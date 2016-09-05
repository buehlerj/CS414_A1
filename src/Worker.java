import java.util.ArrayList;

public class Worker {
	String name;
	Double salary;
	Company companyAvailableTo;
	Company companyAssignedTo;
	ArrayList<Project> projectsAssignedTo = new ArrayList<Project>();
	ArrayList<Qualification> isQualifiedFor = new ArrayList<Qualification>();

	Worker (String name, Qualification[] qs) {
		this.name = name;
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

	public String toString () {
		return name + ":" + projectsAssignedTo.size() + ":" + isQualifiedFor.size() + ":" + salary;
	}

	public boolean willOverload (Project p) {
		ArrayList<Project> projects = this.projectsAssignedTo;
		// TODO: How many big, medium, and small projects is the worker assigned to?
		int number_of_big_projects = 0;
		int number_of_medium_projects = 0;
		int number_of_small_projects = 0;
		if ((3 * number_of_big_projects + 2 * number_of_medium_projects + number_of_small_projects) > 12)
			return true;
		return false;
	}

}
