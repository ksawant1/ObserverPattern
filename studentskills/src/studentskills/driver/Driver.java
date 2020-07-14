package studentskills.driver;

import studentskills.exceptions.InputFileEmpty;
import studentskills.exceptions.MissingLineException;
import studentskills.mytree.Helper;
import studentskills.util.FileProcessor;
import studentskills.mytree.TreeHelper;
import studentskills.util.Results;
import java.io.File;

/**
 * @author Krupa Sawant
 */
public class Driver {
	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 2;

	public static void main(String[] args) throws Exception, InputFileEmpty, MissingLineException {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 6) || (args[0].equals("${input}")) || (args[1].equals("${modify}")) || (args[2].equals("${out1}")) || (args[3].equals("${out2}")) || (args[4].equals("${out3}")) || (args[5].equals("${error}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
		}
		//creates result instances for to write in evry file
		Results output0= new Results();
		Results output1= new Results();
		Results output2= new Results();
		Results error= new Results();

		//inputs a string linen from input.txt and passes it to helper class

		TreeHelper tree = new TreeHelper();
		FileProcessor fpinput = new FileProcessor(args[0]);
		File file = new File(args[0]);
		Results resultw= new Results();
		Helper helper = new Helper(resultw,output0,output1,output2,error);
		try{
		String line = fpinput.poll();
		//check if line is missing
			if(line.isEmpty()) {
				error.store("missing line in input file");
				error.writeToFile(args[5]);
			}
         //check if input file empty
			else if (line == null) {
				throw new InputFileEmpty("input file empty");
			}
			//to insert
			while(line != null) {
				String operation = "INSERT";
				helper.printOutput(line, operation);
				line = fpinput.poll();
			}
		}catch(IllegalArgumentException ex){
			throw new MissingLineException("missing line in input file");}

		//inputs a string line from modify.txt and passes it to helper class

		FileProcessor fpmodify = new FileProcessor(args[1]);
		File file1 = new File(args[1]);
		try{
		String line1 = fpmodify.poll();

			if (line1 == null) {
				error.store("modify file is empty");
				error.writeToFile(args[5]);
			}

			while (line1 != null) {
				String operation = "MODIFY";
				helper.printOutput(line1, operation);
				line1 = fpmodify.poll();

			}

		}catch(IllegalArgumentException ex){
			throw new IllegalArgumentException("invalid input format");
		}

		//prints results to writetofile or writetoStdout
			helper.getTreeAsString(0);
			output0.writeToFile(args[2]);
			output0.writeToStdout();
			helper.getTreeAsString(1);
			output1.writeToFile(args[3]);
			helper.getTreeAsString(2);
			output2.writeToFile(args[4]);


	}



}



