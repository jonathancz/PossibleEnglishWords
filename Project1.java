import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Project1 {
	
	// Create HashSet that will contain all the words from the dictionary text file
	public static Set<String> dictionary = new HashSet<String>();
	
	// Create a HashSet that will contain all the permutations from the given string
	public static Set<String> checkSet = new HashSet<String>();

	public static void main(String[] args) throws IOException{
		
		// Initializing variables
		// User input
		String input;
		
		// Scanner item for input
		Scanner sc = new Scanner(System.in);
		
		// Scanner item to read the file
		Scanner file = new Scanner(new File("dictionary.txt"));
		
		// Populate the dictionary Set
		while(file.hasNext()) {
			dictionary.add(file.next());
		}
		
		//System.out.println("Set size: " + dictionary.size());
		
		// Ask user for input
		System.out.println("Enter string: ");
		input = sc.next();
		//System.out.println(input);
		System.out.println(" ");
		
		// Remove special characters from user's input
		formatString(input);
		
		// Create permutations
		permutation(input);
		
		
		// Print out results
		System.out.println("Possible English words: ");
		// Compare HashSets
		for(String elements : checkSet) {
			if(dictionary.contains(elements)) {
				System.out.println(elements);
			}
		}
		
		// Close scanner items
		sc.close();
		file.close();

	}
	
	// Function that removes special characters from a string
	static String formatString(String a) {
		// Use Regex to remove special characters and whitespace
		a = a.replaceAll("[!@#$%^&*()\\s]","");
		a = a.trim();
		return a;
	}
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	// Generate permutations and add them to the HashSet
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	// Add prefix to the permuation Set
	    	checkSet.add(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}
