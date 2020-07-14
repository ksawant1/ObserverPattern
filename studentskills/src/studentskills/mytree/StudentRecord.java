package studentskills.mytree;

import studentskills.operation.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * student record acts as a node to insert in tree with field properties
 *
 */
public class StudentRecord implements Cloneable, Observer, SubjectI, Comparable<StudentRecord> {
	//to maintain a list of observers
	private List<Observer> observers = new ArrayList<Observer>();

	int bnumber;
	String firstname, lastname;
	double gpa;
	String major;
	Set<String> skills;

    //constructor
	public StudentRecord(int bnumber, String firstname, String lastname, double gpa, String major, String... skills) {
		this(bnumber, firstname, lastname, gpa, major, new LinkedHashSet<String>(Arrays.asList(skills)));
	}
    //constructor
	public StudentRecord(int bnumber, String firstname, String lastname, double gpa, String major, Set<String> skills) {
		this.bnumber = bnumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gpa = gpa;
		this.major = major;
		this.skills = skills;
	}
    //getter and setter methods for every property
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

	// creates a cloned copy of object
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
    //to update existing values to new values after a state change
	@Override
	public void update(StudentRecord record,Operation operation) {
		if(operation.equals(Operation.INSERT)) {

				this.firstname=record.firstname;
				this.lastname=record.lastname;
				this.major=record.major;
				this.gpa=record.gpa;
				this.getSkills().addAll(record.skills);
				//tree1.inorder();

		}
		if(operation.equals(Operation.MODIFY)) {

			this.firstname=record.firstname;
			this.lastname=record.lastname;
			this.major=record.major;
			this.gpa=record.gpa;
			this.getSkills().addAll(record.skills);
			//tree1.inorder();


		}
		}

	@Override
	public void register(StudentRecord record) {
		try{
			observers.add(record);
		}catch(NullPointerException ex){
			ex.printStackTrace();
		}

	}

	@Override
	public void unregister(StudentRecord record) {

	}

	// in case of state change notify corresponding listeners
	@Override
	public void notifyObserver(StudentRecord record,Operation operation) {


		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update(record, operation);
		}
	}

	@Override
	public int compareTo(StudentRecord o) {
		return 0;
	}
}
