import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;


/**
 * 
 * This class builds the environment necessary to test the birthday paradox over
 * a given amount of trials. 
 * 
 * @author galovillacis
 *
 */

public class Birthday {

	public Birthday() {
		
	}
	
	Random rand = new Random();
	StatsLibrary stat = new StatsLibrary();
	
	/**
	 * Method to generate birthdays between 1-365.
	 * @return
	 */
	public int birthday() {
		int birthday = rand.nextInt(366) + 1;	
		return birthday;
		
	}
	
	/**
	 * Method to create an array list of random birthdays
	 * @param people
	 * @return
	 */
	public ArrayList<Integer> newBirthdaySet(int people) {
		ArrayList<Integer> birthdays = new ArrayList<>();
		for(int i = 0; i < people; i++) {
			birthdays.add(birthday());
		}
		return birthdays;
	}
	
	/**
	 * Method to calculate the probability of the birthday paradox in a given number of trials
	 * and a certain amount of people
	 * 
	 * @param trials -  How many times this simulation will occur
	 * @param people - How many people will be in each trial 
	 * @return
	 */
	public double calculateBirthdayParadox(int trials, int people) {
		
		double count = 0;		
		int start = 0;
		
		while(start<trials) {
			start++;
			
		HashSet<Integer> listOfBirthdays = new HashSet<>();	
		ArrayList<Integer> birthdays = newBirthdaySet(people);
		
		//Finds duplicates in each array list, Referenced https://javarevisited.blogspot.com/2015/06/3-ways-to-find-duplicate-elements-in-array-java.html#axzz7ufoiruO0
		for(int x : birthdays) {
			if(listOfBirthdays.add(x) == false) {
				count++;
				break;
			}
		}
	}

		double success = (count / trials);

		success = success * 100;
		return success;
	}
	/**
	 * Method to take input and put it into the calculateBirthdayParadox method
	 * and also prints out a short description of what the numbers mean.
	 * 
	 * @param input1
	 * @param input2
	 */
	public void simulateBirthdayParadox(int input1, int input2) {
		
		System.out.println("The probability that 2 people have the same birthday in a group of " + input2
				+ " people\nin over " + input1 + " trials is approximately: " + String.format("%.2f",calculateBirthdayParadox(input1, input2)) + "%");
	}
}