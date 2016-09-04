
public class Worker {
	String name;

	Worker (String name, Qualification[] qs) {
		this.name = name;
	}

	public String getName () {
		return name;
	}

	public static Double getSalary () {
		System.out.println("UNIMPLEMENTED");
		return null;
	}

	public static void setSalary (Double salary) {
		System.out.println("UNIMPLEMENTED");
	}

	public static Qualification[] getQualifications () {
		System.out.println("UNIMPLEMENTED");
		return null;
	}

	public static void addQualification (Qualification q) {
		System.out.println("UNIMPLEMENTED");
	}

	public static boolean equals () {
		System.out.println("UNIMPLEMENTED");
		return false;
	}

	public String toString () {
		return "UNIMPLEMENTED";
	}

	public static boolean willOverload (Project p) {
		System.out.println("UNIMPLEMENTED");
		return false;
	}

}
