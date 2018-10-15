import java.util.Scanner; // Library - allows to capture user input
import java.util.*; // Allows to check for InputMismatchException
import java.io.*; // Allows for system input and output through data streams, serialization and the file system

public class JavaLessonSix {
	static Scanner userInput = new Scanner(System.in);
	
	public static void main (String[] args){
		
		divideByZero(2);

	    System.out.print("How old are you? ");

	    int age = checkValidAge();

	    if (age != 0){
	        System.out.println("You are " + age + " years old");
	    }
	         
	    getAFile("./somestuff.txt");
	         
	}

	public static void divideByZero(int a){
	    
		try {

			// The following throws an error because you can't divide by zero
	        // Exception in thread "main" java.lang.ArithmeticException

	        System.out.println(a/0);

	        }

	        // If the exception ArithmeticException is thrown the following execute

	    catch (ArithmeticException e){

	        // Your custom error message

	        System.out.println("You can't divide by zero");

	        // Java's error message for this exception

	        System.out.println(e.getMessage());

	        // Prints the exception name and error message

            System.out.println(e.toString());

	        // Prints the standard error stack trace

	        e.printStackTrace();

	    }
    }

	public static int checkValidAge(){

	    try {

	        return userInput.nextInt(); // nextInt() receives the user input

	        }

        catch (InputMismatchException e){

	        userInput.next(); // Skips the last user input and waits for the next

	        System.out.println("That isn't a whole number");
			

	        return 0;

	    }

	}
	
	 /* If you prefer to throw an exception to the calling method you use throw
	 * public static void getAFile(String fileName) throws IOException, FileNotFoundException
	     * {
	     * FileInputStream file = new FileInputStream(fileName);
	     * }
	     *
	     * If main called this method, main would have to handle the exception
	     *
	     * public static void main(String[] args) {
	     *      try {
	     *          getAFile("./somestuff.txt");
	     *      }
		 
	     *      catch(IOException e) {
	     *          System.out.println("An unknown IO Error Occured");
	     *      }
	     */
	     
	public static void getAFile(String fileName){
        try {
	        /* If do this without providing for an exception-
	        * the error Unhandled Exception Type FileNotFoundException
	        
			* A checked exception is an exception the compiler forces you to protect against
	        */
	        FileInputStream file = new FileInputStream(fileName);
	    }
	         
	    catch (FileNotFoundException e){
            System.out.println("Sorry I couldn't find that file");
        }

		// You can catch numerous exceptions (List most specific first

	    // catch (IOException e) // Catches any IO Exception
		// {
			// System.out.println("An unknown IO Error Occured");

	    // }

		/* To ignore an exception do this

		* catch (ClassNotFoundException e)
        * {}

	    */
        /* Java 7 allows you to catch multiple exceptions at once

        * catch (FileNotFoundException | IOException e)
	    * {}

	    */
        // This will catch any exception (This should always be last)
        catch (Exception e){
            System.out.println("I catch every exception");
        }

		// If used finally is always executed whether there was an exception or not
        // It is used for clean up work like closing files and database connections
        finally {
            System.out.println("");
        }

    }
}
		
	