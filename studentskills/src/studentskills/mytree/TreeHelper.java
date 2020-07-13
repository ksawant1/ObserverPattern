package studentskills.mytree;
import studentskills.operation.Operation;

/**
 * Tree Helper usually calls the Tree methods recursively based op update or insert methods
 */
public class TreeHelper {

	//nodes for every tree
	StudentRecord record0,record1,record2;

	// the three instances of class tree
	Tree<Integer, StudentRecord> tree0,tree1,tree2;


	// Constructor
	public TreeHelper() {
		tree0=new Tree();
		tree1=new Tree();
		tree2=new Tree();

	}

	/**
	 * finds the bnumber in corresponding tree and updates with given values if present
	 * else prepares two copies and inserts in correspondig trees
	 * @param value
	 * @param operation
	 * @throws CloneNotSupportedException
	 * @throws NullPointerException
	 */
	public void insert( StudentRecord value, Operation operation) throws CloneNotSupportedException, NullPointerException {

		    // to find if bnumber exists in tree 0
			if ((tree0.getValue(value.bnumber) != null)) {
				StudentRecord record = tree0.getValue(value.bnumber);
				//updates values in tree 0
				if (record != null) {

					record.firstname=value.firstname;
					record.lastname=value.lastname;
					record.major=value.major;
					record.gpa=value.gpa;
					record.getSkills().addAll(value.skills);


				}

				//notifies tree 1,2
				record0.notifyObserver(value, operation);
			}

			// to find if bnumber exists in tree 1
			else if ((tree1.getValue(value.bnumber) != null)) {
				StudentRecord record = tree1.getValue(value.bnumber);
				//updates values in tree 1
				if (record != null) {

					record.firstname=value.firstname;
					record.lastname=value.lastname;
					record.major=value.major;
					record.gpa=value.gpa;
					record.getSkills().addAll(value.skills);
					//tree1.inorder();


				}
				//notifies tree 0,2
				record1.notifyObserver(value, operation);
			}

			// to find if bnumber exists in tree 2
			else if ((tree2.getValue(value.bnumber) != null)) {
				//finds bnumber
				StudentRecord record = tree2.getValue(value.bnumber);
				//updates values in tree 2
				if (record != null) {

					record.firstname=value.firstname;
					record.lastname=value.lastname;
					record.major=value.major;
					record.gpa=value.gpa;
					record.getSkills().addAll(value.skills);
					tree2.inorder();


				}
				//notifies tree 0,1
				record2.notifyObserver(value, operation);

			}
			else if((tree0.getValue(value.bnumber) == null) && (tree1.getValue(value.bnumber) == null) && (tree2.getValue(value.bnumber) == null)){
				//original node
				record0 = value;

				//clone the original replica twice
				record1 = (StudentRecord) value.clone();
				record2 = (StudentRecord) value.clone();

				//register the listeners for original replica
				record0.register(record1);
				record0.register(record2);

				//register the listeners for replica 1
				record1.register(record0);
				record1.register(record2);

				//register the listeners for replica 2
				record2.register(record0);
				record2.register(record1);

				//insert in every tree
				tree0.insertNode(record0.bnumber, record0);
				tree1.insertNode(record1.bnumber, record1);
				tree2.insertNode(record2.bnumber, record2);



			}

		}


	/**
	 * prints trees in asecnding order of their b-numbers
	 */
	public void printInOrder(){
		tree0.inorder();
		tree1.inorder();
		tree2.inorder();

	}

	/**
	 * finds bnumber in given replica id's tree and updates replaces the old value with the new
	 * notifies other trees to update their values
	 * @param replicaid
	 * @param bnumber
	 * @param oldval
	 * @param newval
	 * @param operation
	 * @throws CloneNotSupportedException
	 * @throws NullPointerException
	 */

	public void modify( int replicaid,int bnumber,String oldval, String newval, Operation operation) throws CloneNotSupportedException, NullPointerException{
		// based on replica id switches case
		switch (replicaid) {
			// find if present in tree and update
	        case 0:
		        System.out.println("hi");
		        System.out.println(tree0.getValue(bnumber));
		        if ((tree0.getValue(bnumber) != null)) {
			        System.out.println("hi");
			        StudentRecord record = tree0.getValue(bnumber);
			        System.out.println(record);
			        if (record.firstname == oldval)
				        record.firstname = newval;
			        else if (record.lastname == oldval)
				        record.lastname = newval;
			        else if (record.major == oldval)
				        record.major = newval;
			        else if (record.skills.contains(oldval)) {
				        record.skills.remove(oldval);
				        record.skills.add(newval);
			        }

		        }
		        tree0.inorder();
		        break;

		        //value.notifyObserver(value, operation);
	        case 1:
		        if ((tree1.getValue(bnumber) != null)) {
			        StudentRecord record = tree1.getValue(bnumber);

			        if (record.firstname == oldval)
				        record.firstname = newval;
			        else if (record.lastname == oldval)
				        record.lastname = newval;
			        else if (record.major == oldval)
				        record.major = newval;
			        else if (record.skills.contains(oldval)) {
				        record.skills.remove(oldval);
				        record.skills.add(newval);
			        }
			        break;

		        }
	        case 2:
		        if ((tree2.getValue(bnumber) != null)) {
			        StudentRecord record = tree2.getValue(bnumber);
			        if (record.firstname == oldval )
				        record.firstname=newval;
			        else if (record.lastname == oldval )
				        record.lastname=newval;
			        else if (record.major == oldval )
				        record.major=newval;
			        else if (record.skills.contains(oldval)) {
				        record.skills.remove(oldval);
				        record.skills.add(newval);
			        }

		        }
		        break;



        }}}
