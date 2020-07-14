package studentskills.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	ArrayList<String> words= new ArrayList<String>();
	ArrayList<Double> metrics= new ArrayList<Double>();
	public Results(){
	}

	/**
	 * writetoFile() prints the array list into the output.txt file
	 */

	public void writeToFile(String filename) throws IOException{
		try{
			FileWriter fileWriter = new FileWriter(filename);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			for (int i=0;i<words.size();i++){
				printWriter.println(words.get(i));

			}
			printWriter.close();
		}catch(IOException ex){
			System.out.println("file not found");
		}
	}
	/**
	 * writeToStdout prints the word array list onto the console.
	 *
	 */
	public void writeToStdout() throws ArrayIndexOutOfBoundsException{
		try{
			for (int i=0;i<words.size();i++){

				System.out.print(words.get(i));
			}

		}catch(ArrayIndexOutOfBoundsException ex){
			throw new ArrayIndexOutOfBoundsException("empty input file");
		}
	}
	/**
	 * stores the tree in arraylist
	 *
	 * @param word string parameter
	 */
	public void store(String word){
		words.add(word);


	}


}


