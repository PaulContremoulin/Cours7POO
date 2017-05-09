import java.util.Scanner;
import java.io.Console;  // Console is in the java.io library

public class DataCheck {
  static public void main(String args[]) {
    Scanner lineTokenizer;

    String input_line;
    Console console = System.console();
    // I'm just going to exit if the console is not provided
    if (console == null) {
       System.err.println("No console.");
       System.exit(1);
    }
    // you cannot use the C/C++ idiom of
    //   while (input_line = input_reader.readLine())
    // because the test expects a boolean and the above assignment returns
    // a String reference. In C/C++ the return of null would be interpreted
    // as false, but no so in Java. Hence the infinite loop that I have written
    // with a break statement for when readLine returns null
    while(true) {

      input_line = console.readLine();
      if (input_line == null) break;
      lineTokenizer = new Scanner(input_line);

      int lineNum = 0;
      lineNum++;

      // determine if the line has a name field
      if (lineTokenizer.hasNext()) {
	lineTokenizer.next();  // consume the valid token
      }
      else {
	console.printf("Line %d: line must have the format 'name age singleness'\n", lineNum);
	continue;  // proceed to the next line of input
      }
      // determine if the line has a second field, and if so, whether that
      // field is an integer
      if (lineTokenizer.hasNext()) {
	if (lineTokenizer.hasNextInt()) {
	  lineTokenizer.nextInt(); // consume the valid token
	}
	else
	  console.printf("line %d - %s: age should be an integer\n", 
			    lineNum, lineTokenizer.next());
      }
      else {
	console.printf("line %d: must have fields for age and singleness\n",
			  lineNum);
	continue; // proceed to the next line of input
      }
      // determine if the line has a third field, and if so, whether that
      // field is a boolean
      if (lineTokenizer.hasNext()) {
	if (lineTokenizer.hasNextBoolean())
	  lineTokenizer.nextBoolean(); // consume the valid token
	else {
	  console.printf("line %d - %s: singleness should be a boolean\n", 
			    lineNum, lineTokenizer.next());
	  continue; // proceed to the next line of input
	}
      }
      else {
	console.printf("line %d: must have a field for singleness\n", lineNum);
	continue; // proceed to the next line of input
      }
      lineTokenizer.close(); // discard this line
    }
  }
}
