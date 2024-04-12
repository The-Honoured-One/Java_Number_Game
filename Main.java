import java.util.Random;
import java.util.Scanner;


public class Main {
	
	static int remaining_tries = 3;
	static Random randobj = new Random();
	static Scanner sc = new Scanner(System.in);
	
	public static void display_win () {
		if (remaining_tries > 1) {
			System.out.println("Congratulations, you won with " + remaining_tries + " guesses remaining");
		}
		else {
			System.out.println("Congratulations, you won with " + remaining_tries + " guess remaining");
		}
	}
	
	public static void choice() {
		System.out.println("Play Again ? (Y/N)");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Y")) {
			remaining_tries = 3;
			main(null);
		}
		else {
			System.out.println("Thank You For Playing !");
			sc.close();
			System.exit(0);
		}
		
	}
	
	public static void display_number_of_tries() {
		if (remaining_tries > 1) {
			System.out.println("You have " + remaining_tries + " guesses remaining");
		}
		else {
			System.out.println("You have 1 guess remaining");
		}
	}
	
	public static int check_and_validate() {
		System.out.println("Enter your guess");
		try {
			String guess1 = sc.nextLine();
			int guess = Integer.parseInt(guess1);
			if(guess > 10 || guess < 1) {
				System.out.println("Enter a number between 1 and 10");
				check_and_validate();
			}
			return guess;
		}
		catch(Exception e) {
			System.out.println("Please Enter Integer value");
		}
		
		check_and_validate();
		
		return 0;
		
	}

	public static void main(String[] args) {
		int target = randobj.nextInt(10) + 1;
		System.out.println("Welcome To The Number Guessing Game");
		System.out.println("You Have 3 Tries To Guess The Number");
		System.out.println("The Number is between 1 and 10, Good Luck!");
		while (remaining_tries > 0) {
			int guess = check_and_validate();
			if(guess == target) {
				display_win();
				choice();
			}
			else {
				remaining_tries -= 1;
				if(remaining_tries == 0) {
					break;
				}
				System.out.println("Try Again!");
				display_number_of_tries();
			}
		}
		
		System.out.println("Oops, better luck next time! ");
		choice();
	}

}
