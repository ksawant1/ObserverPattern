package studentskills.driver;

import studentskills.mytree.Helper;
import studentskills.mytree.StudentRecord;
import studentskills.util.FileProcessor;
import studentskills.mytree.TreeHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Krupa Sawant
 */
public class Driver {
	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 2;

	public static void main(String[] args) throws Exception {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 2) || (args[0].equals("${input}")) || (args[1].equals("${output}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
		}

		//inputs a string line and passes it to helper class

		TreeHelper tree = new TreeHelper();


			System.out.println("Hello World! Lets get started with the assignment");
			FileProcessor fpinput= new FileProcessor(args[0]);
			File file = new File(args[0]);
			//Results resultw= new Results();
			Helper helper= new Helper();
			boolean empty = file.exists() && file.length() == 0;
			if(empty==true)
				System.out.println("emptystring");

			while (true) {
				String line = fpinput.poll();
				String operation="INSERT";

				if (line == null) {

					break;
				}
				if (line != null)
					helper.printOutput(line,operation);

				//resultw.writeToFile();
				//resultw.writeToStdout();
			}


	}

}
