package studentskills.mytree;

import studentskills.operation.Operation;

import javax.print.DocFlavor;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Helper {
	TreeHelper tree = new TreeHelper();



	/**
	 * Helper is a utility that performs the operations for adding, removing videos calculating metrics and comsiders ad_requests
	 *
	 * @author Krupa Sawant
	 */



		public Helper(){

		}

		static {

		}
		/**
		 * printOutput matches an enum for required operation and processes the request
		 * @exception VideoAlreadyExistsException if video exists, cannot add the same video
		 * @exception VideoNotFoundException if video not found, cannot remove or ad requests for it
		 * @exception SecurityException On not having necessary read permissions to the input file.
		 * @exception FileNotFoundException On input file not found.
		 * @exception IOException On any I/O errors while reading lines from input file.
		 */

		public void printOutput(String inputLine, String operationString) throws IOException {

			Operation operation = Operation.valueOf(operationString);


			switch (operation) {
				case INSERT:
					insertInTree(inputLine);
					break;
				case MODIFY:
					//modifyTree(inputs[1]);
					break;
				/*case AD_REQUEST:
					String values[] = inputs[1].split("=");
					try{
						int length = Integer.parseInt(values[1]);
						adRequest(length);
						break;
					}catch(NumberFormatException ex) {
						throw new NumberFormatException("enter an integer value");


					}
				case METRICS:
					String[] params = inputs[1].substring(1, inputs[1].length() -1 ).split(",");
					updateMetrics(operationParams[1], params);
					break;
*/
				default:
					throw new IllegalArgumentException("invalid input format or file is empty");

			}

		}
		/**
		 * calculates metrics for every video based on given likes, views and dislikes
		 */

		public void insertInTree(String inputLine) throws IOException {

			StringBuilder result = new StringBuilder();
			String newLine = System.getProperty("line.separator");
			try {
				Set<String> hash_Set
						= new HashSet<String>();
				String[] inputs = inputLine.split(":");
				int bnumber= Integer.parseInt(inputs[0]);
				System.out.println(bnumber);
				String fname = (inputs[1].split(",")[0]);
				System.out.println(fname);
				String lname = (inputs[1].split(",")[1]);
				System.out.println(lname);
				String gpastr= (inputs[1].split(",")[2]);
				double gpa= Double.parseDouble(gpastr);
				System.out.println(gpa);
				String major=(inputs[1].split(",")[3]);
				for(int i=4; i<9;i++){
					hash_Set.add(inputs[1].split(",")[i]);

				}
				System.out.println(hash_Set);
				StudentRecord record= new StudentRecord(bnumber,fname,lname,gpa,major,hash_Set);
				tree.insert(record);
				tree.inorder();
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

		/*public void adRequest(int length) throws IOException {
			StringBuilder result = new StringBuilder();
			String newLine = System.getProperty("line.separator");
			StateName prevState = context.getCurrentState();
			String status = context.addRequest(length) ? "APPROVED" : "REJECTED";
			//System.out.println(prevState + "_AD_REQUEST::" + status);
			result.append(prevState);
			result.append( "__AD_REQUEST::" );
			result.append(status);
			result.append(newLine);
			resultw.store(result);
		}*/
		/**
		 * removes given video by it's name
		 */

		/*public void removeVideo(String videoName) throws IOException, VideoNotFoundException {

			StringBuilder result = new StringBuilder();
			String newLine = System.getProperty("line.separator");
			StateName prevState = context.getCurrentState();
			context = context.removeVideo(videoName);
			//System.out.println(prevState + "_VIDEO_REMOVED::" + videoName);
			result.append(prevState);
			result.append( "__VIDEO_REMOVED::" );
			result.append(videoName);
			result.append(newLine);
			resultw.store(result);
		}*/
		/**
		 * adds given video by it's name
		 */

		/*public void addVideo(String videoName) throws IOException, VideoAlreadyExistsException {
			Results results=new Results();
			StringBuilder result = new StringBuilder();
			String newLine = System.getProperty("line.separator");
			StateName prevState = context.getCurrentState();
			context = context.addVideo(videoName);
			//System.out.println(prevState + "_ADD_VIDEO::" + videoName);
			result.append(prevState);
			result.append( "__VIDEO_ADDED::" );
			result.append(videoName);
			result.append(newLine);
			resultw.store(result);
		}*/

		@Override
		public String toString() {
			return "Helper{" +

					'}';
		}
	}

