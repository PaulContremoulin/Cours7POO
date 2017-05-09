public class ExceptionDemo {
  public static void main(String[] args) 
      throws Exception {
	java.io.PrintWriter output = null;
	output = new java.io.PrintWriter("sentence.txt");
	output.println("How are you?");
	output.close();
  }
}