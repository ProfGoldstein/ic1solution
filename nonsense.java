import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * An application that selects a random number of word from
 * the text inputted from standard in and outputs those words
 * on the standard output. 
 * 
 * @author Ira Goldstein
 * @version Spring 2023
 *
 */
 public class nonsense {
	/**
	* main method to process the inputted text.
	*
	* @param args[0] The number of words to be randomly selected.
	*/
    public static void main(String[] args) {
		int wordsNeeded = 0;
		
		// Check for a command line argumemt
		if (args.length == 0) {
			System.out.println("Incorrect number of arguments");
			System.exit(1);
		}
		
		// Grab the first argument and check to see if it is >0
		try {
			wordsNeeded = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException e) {
			System.out.println("Need to specify a positive integer");
			System.exit(1);
		}
			
		if (wordsNeeded < 0) {
			System.out.println("Need to specify a positive integer");
			System.exit(1);
		}
		
		// Create an input scanner from the standard input
        Scanner sc = new Scanner(System.in);
		sc.useDelimiter(System.getProperty("line.separator"));

		// Create a list for the lines being input
        List<String> input = new ArrayList<>();
        while (sc.hasNextLine()) {
            input.add(sc.nextLine());
        }
		
		// Concatenate all of the input lines and then seperate them by non-alphasnumeric
        String[] words = String.join(" ", input).split("\\W+");

        // Create a random object
		Random rand = new Random();
		
		// Display the random sample of words
        for (int i = 0; i < wordsNeeded; i++) {
            int randomIndex = rand.nextInt(words.length);
            System.out.print(words[randomIndex] + " ");
        }
    }
}


