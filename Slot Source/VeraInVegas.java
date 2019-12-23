import java.text.DecimalFormat;
import java.io.*;

public class VeraInVegas { // Created by Brandon Blake.
	public static double quarters = 100;
	public static int a = 0;
	public static int b = 0; // Multiple class variables to avoid initialization error and to not use an instance variable.
	public static int c = 0;
	public static int total = 0;
	static File file = new File("output.txt");

	
	public static double machine1() throws FileNotFoundException {
		
		a++;
		total++;
		quarters--;
		
			if (a % 33 == 0){ // Every 33 runs the command block runs.
				quarters = quarters + 25;
				double dollars = quarters / 4;
				DecimalFormat df1 = new DecimalFormat("#");
				DecimalFormat df2 = new DecimalFormat("#.00");
				System.out.println("Congratulations, You've won $6.25 on machine 1! You now have " + df1.format(quarters) + 
						" quarters left which equals $" +  df2.format(dollars) + ".");
		}
			return quarters;
	}
	
	public static double machine2() throws FileNotFoundException {
		
		b++;
		total++;
		quarters--;
		
			if (b % 99 == 0){ // Every 99 uses the command block runs.
				quarters = quarters + 75;
				double dollars = quarters / 4;
				DecimalFormat df1 = new DecimalFormat("#");
				DecimalFormat df2 = new DecimalFormat("#.00");
				System.out.println("Congratulations, You've won $18.75 on machine 2! You now have" + df1.format(quarters) + 
						" quarters left which equals $" +  df2.format(dollars) + ".");
		}
			return quarters;
	}
	
	public static double machine3() throws FileNotFoundException {
		
		c++;
		total++;
		quarters--;
		
			if (c % 9 == 0){ // Every 9 uses the command block runs.
				quarters = quarters + 7;
				double dollars = quarters / 4;
				DecimalFormat df1 = new DecimalFormat("#");
				DecimalFormat df2 = new DecimalFormat("#.00");
				System.out.println("Congratulations, You've won $1.75 on machine 3! You now have " + df1.format(quarters) + 
						" quarters left which equals $" +  df2.format(dollars) + ".");
		}
			return quarters;
	}
	
	public static void machines() throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(file); // To have output go to a file.
		PrintStream ps = new PrintStream(fos);
		
		while (quarters > 0) { // To repeatedly run the methods.
			if (quarters > 0) { // If statements so when quarters reaches 0 inside one method it doesn't go to the next and use non-existent quarters.
				System.setOut(ps);
				machine1(); // Wins once here every 97 tries on all machines.
			}
			if (quarters > 0) {
				System.setOut(ps);
				machine2(); // Wins once here every 294 tries on all machines.
			}
			if (quarters > 0) {
				System.setOut(ps);
				machine3(); // Wins once here every 27 tries on all machines.
			}
		}
		System.setOut(ps);
		System.out.println("Vera played the slot machines " + total + " times.");
	}

	public static void main(String[] args) throws FileNotFoundException {
		machines();
	}
	
}
