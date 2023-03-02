import java.util.Random;

/**
 * 
 * This class simulates the Monte Hall problem in over 10,000 trials
 * to calculate the odds of winning between staying with the same door
 * or choosing a different door.
 * 
 * @author galovillacis
 *
 */

public class MonteHall {

	public MonteHall() {
		
	}
	
	static final int TRIALS = 10000;
	
	/**
	 * Method to simulate the Monte hall problem by comparing the
	 * success rate of either staying with the initial door that is chosen
	 * or switching to a different door.
	 * Referenced: https://www.reddit.com/r/dailyprogrammer/comments/1qdw40/111113_challenge_141_easy_monty_hall_simulation/
	 */

	public void simulateMonteHall() {
		
		Random rand = new Random();
		int prize = 0;
		int choice = 0;
		
		double decision = 0.0;
		double decision2 = 0.0;
		
		for(int r = 0; r < TRIALS; r++) {
			prize = rand.nextInt(3) + 1;
			choice = rand.nextInt(3) + 1;
			
			if(prize != choice) {
				decision2++;
			} else {
				decision++;
			}
		}
		
		double winner1 = (decision/TRIALS) * 100;
		double winner2 = (decision2/TRIALS) * 100;

		System.out.println("Percentage of wins using the same door: " + String.format("%.2f",winner1) + "%");
		System.out.println("Percentage of wins choosing a different door: " + String.format("%.2f",winner2)+ "%");

	}
}
