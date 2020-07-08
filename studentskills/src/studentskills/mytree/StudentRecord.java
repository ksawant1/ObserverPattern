package studentskills.mytree;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class StudentRecord extends Subject implements Cloneable, Observer {
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

	 int bnumber;
	String firstname, lastname;
	 double gpa;
	 String major;
	Set<String> skills;

	public StudentRecord(int bnumber, String firstname, String lastname, double gpa, String major, String... skills) {
		this(bnumber, firstname, lastname, gpa, major, new LinkedHashSet<String>(Arrays.asList(skills)));
	}

	public StudentRecord(int bnumber, String firstname, String lastname, double gpa, String major, Set<String> skills) {
		this.bnumber = bnumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gpa = gpa;
		this.major = major;
		this.skills = skills;
	}

	public int getBnumber() {
		return bnumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public double getGpa() {
		return gpa;
	}

	public String getMajor() {
		return major;
	}

	public Set<String> getSkills() {
		return skills;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new StudentRecord(bnumber, firstname, lastname, gpa, major, new LinkedHashSet<String>(skills));
	}

	@Override
	public String toString() {
		return "StudentRecord{" +
				"bnumber=" + bnumber +
				", fname='" + firstname + '\'' +
				", lname='" + lastname + '\'' +
				", gpa=" + gpa +
				", major='" + major + '\'' +
				", skills=" + skills +
				'}';
	}

	@Override
	public void update() {

	}
}