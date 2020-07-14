package studentskills.mytree;

import studentskills.operation.Operation;
import studentskills.util.Results;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Helper {
	TreeHelper treehelper = new TreeHelper();
	Results resultw,output0,output1,output2,error;

	/**
	 * Helper is a utility that performs the operations for inserting, and modifying nodes into tree
	 *
	 * @author Krupa Sawant
	 */

	public Helper(Results rp, Results out0, Results out1, Results out2, Results err) {
		resultw =rp;
		output0=out0;
		output1=out1;
		output2=out2;
		error=err;
	}
	/**
	 * @param inputLine input lines
	 * @param operationString update or insert operation
	 * @throws IOException
	 * @throws CloneNotSupportedException
	 */
	public void printOutput(String inputLine, String operationString) throws IOException, CloneNotSupportedException {
		Operation operation = Operation.valueOf(operationString);
		switch (operation) {
			case INSERT:
				insertInTree(inputLine, operation);
				break;
			case MODIFY:
				modifyTree(inputLine, operation);
				break;
			default:
				throw new IllegalArgumentException("invalid input format or file is empty");
		}
	}

	/**
	 * to insert into tree after converting line into proper form
	 * @param inputLine
	 * @param operation
	 * @throws IOException
	 */
	public void insertInTree(String inputLine, Operation operation) throws IOException {
		StringBuilder result = new StringBuilder();
		try {
			Set<String> hash_Set
					= new HashSet<String>();
			String[] inputs = inputLine.split(",");
			String[] recordInfo = inputs[0].split(":");
			int bnumber = Integer.parseInt(recordInfo[0]);
			int length = String.valueOf(bnumber).length();
			if((bnumber<0) && (length>4)){
				error.store("bnumber is negative or greater than 4 digits");
				error.writeToFile("");
			}
			String fname = recordInfo[1];
			String lname = inputs[1];
			double gpa = Double.parseDouble(inputs[2]);
			String major = inputs[3];
			for (int i = 4; i < inputs.length; i++) {
				hash_Set.add(inputs[i]);
			}
			StudentRecord record = new StudentRecord(bnumber, fname, lname, gpa, major, hash_Set);
			treehelper.insert(record, operation);
		} catch (NumberFormatException | CloneNotSupportedException ex) {
			throw new NumberFormatException("enter integer value");
		}
	}

	/**
	 * decides whether the ad should be approved or rejected for every video based on given length
	 */

	public void modifyTree(String inputLine, Operation operation) throws IOException, CloneNotSupportedException {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		String[] inputs = inputLine.split(":");
		int replica_id = Integer.parseInt((inputs[0].split(",")[0]));
		int bnumber = Integer.parseInt(inputs[0].split(",")[1]);
		String orig_value = (inputs[0].split(",")[2]);
		String new_value = inputs[1];
		treehelper.modify(replica_id, bnumber, orig_value, new_value, operation);

	}

	public void getTreeAsString(int index) {

		String tree=treehelper.getTreeAsString(index);
		if(index==0)
			output0.store(tree);
		if(index==1)
			output1.store(tree);
		if(index==2)
			output2.store(tree);
	}

	@Override
	public String toString() {
		return "Helper{" +

				'}';
	}
}