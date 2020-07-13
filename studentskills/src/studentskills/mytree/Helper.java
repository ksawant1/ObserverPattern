package studentskills.mytree;

import studentskills.operation.Operation;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Helper {
	TreeHelper treehelper = new TreeHelper();
	/**
	 * Helper is a utility that performs the operations for inserting, and modifying nodes into tree
	 * @author Krupa Sawant
	 */
		public Helper(){
		}
		static {
		}
	/**
	 *
	 * @param inputLine
	 * @param operationString
	 * @throws IOException
	 * @throws CloneNotSupportedException
	 */
		public void printOutput(String inputLine, String operationString) throws IOException, CloneNotSupportedException {
			Operation operation = Operation.valueOf(operationString);
			switch (operation) {
				case INSERT:
					insertInTree(inputLine,operation);
					break;
				case MODIFY:
					modifyTree(inputLine,operation);
					break;
				default:
					throw new IllegalArgumentException("invalid input format or file is empty");
			}
		}
	/**
	 * @param inputLine
	 * @param operation
	 * @throws IOException
	 */
		public void insertInTree(String inputLine,Operation operation) throws IOException {
			StringBuilder result = new StringBuilder();
			String newLine = System.getProperty("line.separator");
			try {
				Set<String> hash_Set
						= new HashSet<String>();
				String[] inputs = inputLine.split(":");
				int bnumber= Integer.parseInt(inputs[0]);
				String fname = (inputs[1].split(",")[0]);
				String lname = (inputs[1].split(",")[1]);
				String gpastr= (inputs[1].split(",")[2]);
				double gpa= Double.parseDouble(gpastr);
				String major=(inputs[1].split(",")[3]);
				for(int i=4; i<9;i++){
					hash_Set.add(inputs[1].split(",")[i]);
				}
				StudentRecord record= new StudentRecord(bnumber,fname,lname,gpa,major,hash_Set);
				treehelper.insert(record,operation);
				//tree.inorder();
				//System.out.println(prevState + "_POPULARITY_SCORE_UPDATE::" + context.getPopularity());
				//result.append(prevState);
				//result.append( "__POPULARITY_SCORE_UPDATE::" );
				//result.append(context.getPopularity());
				//result.append(newLine);
				//resultw.store(result);
			}catch(NumberFormatException | CloneNotSupportedException ex) {
				throw new NumberFormatException("enter an integer value");
			}
		}
		/**
		 * decides whether the ad should be approved or rejected for every video based on given length
		 */

		public void modifyTree(String inputLine,Operation operation) throws IOException, CloneNotSupportedException {
			//System.out.println(inputLine);
			StringBuilder result = new StringBuilder();
			String newLine = System.getProperty("line.separator");
			String[] inputs = inputLine.split(":");
			int replica_id= Integer.parseInt((inputs[0].split(",")[0]));
			int bnumber = Integer.parseInt(inputs[0].split(",")[1]);
	        String orig_value = (inputs[0].split(",")[2]);
			String new_value= inputs[1];
			treehelper.modify(replica_id,bnumber,orig_value,new_value,operation);

		}

		@Override
		public String toString() {
			return "Helper{" +

					'}';
		}
	}