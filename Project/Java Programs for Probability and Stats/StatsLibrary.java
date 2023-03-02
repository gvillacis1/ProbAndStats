import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * This class is a statistics library that can be used to make various calculations, such as:
 * Finding the union of two arrays,
 * Finding the intersection of two arrays,
 * Finding the complement of one array when compared to another,
 * Calculating the mean, median, and mode,
 * Calculating the factorial of a number,
 * Calculating Combinations and Permutations.
 * 
 * @author galovillacis
 *
 */

public class StatsLibrary {

	public StatsLibrary() {
		
	}
	
	/**
	 * 
	 * Method to find the Union between two arrays using two array lists and a set. referenced https://www.youtube.com/watch?v=C2IpK2cgULw 
	 * @param a
	 * @param b
	 * @param list
	 */
	public void findUnion(int [] a, int [] b, Set<Integer> list) {
		
		int i = 0;
		int j = 0;
		
		while(i<a.length) {
			list.add(a[i++]);
	}
		
		while(j < b.length) {
			list.add(b[j++]);
		}
	}
	
	/**
	 * 
	 * Method to find intersection of two arrays, referenced https://www.youtube.com/watch?v=w5mBjxL1pok
	 * @param a
	 * @param b
	 * @return
	 */
		public int[] findIntersection(int [] a, int [] b) {
			
			 HashSet<Integer> list = new HashSet<>();
			 HashSet<Integer> intersect = new HashSet<>();
			 
			for(Integer i : a) {
				list.add(i);
			}
			for(Integer i : b) {
				if(list.contains(i)) {
					intersect.add(i);
				}
			}
			
			int size = intersect.size();
			int [] newArr = new int[size];
			int index = 0;
			
			for(Integer i : intersect) {
				newArr[index++] = i;
			}
			return newArr;
	}
		/**
		 * Method to calculate the complement of an array when compared to another array, referenced the same material as findIntersection
		 * 
		 * @param a
		 * @param b
		 * @return
		 */
		public int[] findComplement(int [] a, int [] b) {
			
			 HashSet<Integer> list = new HashSet<>();
			 HashSet<Integer> complement = new HashSet<>();
			 
			for(Integer i : a) { 
				list.add(i); //adds value to list from array 1
			}
			for(Integer i : b) {
				if(list.contains(i)) {
					complement.remove(i); //removes value if it was found in array 1
				} else {
					complement.add(i); //adds value to complement list if it wasn't found in list 1
				}
			}
			int size = complement.size(); //Create new list
			int [] newArr = new int[size];
			int index = 0;
			
			for(Integer i : complement) {
				newArr[index++] = i;
			}
			return newArr;
	}
		/**
		 * Method to calculate the mean of an array list, referenced https://www.youtube.com/watch?v=IPeZL2ucK2k
		 * @param a
		 * @return
		 */
		public double calculateMean(ArrayList<Integer> a) {
			double total = 0;
			for(int i : a) {
				total += i;
			}
			return total / a.size();	
			
		}
		/**
		 * Method to calculate the median of an array list, referenced https://www.youtube.com/watch?v=xKR3uA-Ytno
		 * referenced https://www.geeksforgeeks.org/collections-sort-java-examples/
		 * 
		 * @param a
		 * @return
		 */
		public double calculateMedian(ArrayList<Integer> a) {
			
			Collections.sort(a);
			
			double median = a.size() / 2;
			
			if(a.size() % 2 == 1) {
				median = ((a.get(a.size() / 2) + a.get(a.size()/2)) / 2);
				System.out.println("The median of the array list is: " + median );
			} else {
				median = a.get(a.size() / 2 - 1);
				System.out.println("The median is of the array list is:  " + median);
			}
			return median;
		}
		
		/**
		 * Method to calculate mode of an array list https://www.youtube.com/watch?v=xKR3uA-Ytno
		 * @param a
		 */
		public void calculateMode(ArrayList<Integer> a) {
			
			int maxNumber = -1;
			int maxAppearances = -1;
			
			for(int i = 0; i < a.size(); i++) {
				int count = 0;
				
				for(int j = 0; j < a.size(); j++) {
				if(a.get(i) == a.get(j)) {
					count++;
				}
				
			if(count > maxAppearances) {
				maxNumber = a.get(i);
				maxAppearances = count;
				}
			}
		}
			System.out.println("The mode of the data set is : " + maxNumber);
	}
		
		/**
		 * Method to calculate the Standard Deviation of an array list, referenced https://www. youtube.com/watch?v=R5PUMfVtY0w
		 * @param a
		 * @return
		 */
		public double calculateStandardDeviation(ArrayList<Integer> a) {
			
			double m = calculateMean(a);
			double sum = 0;
			List<Double> listOfDifferences = new ArrayList<Double>();
			
			for(double number : a) {
				sum += number;
			}
			
			for (double number : a) {
				double difference = number - m;
				listOfDifferences.add(difference);
			}
			
			List<Double> squares = new ArrayList<Double>();
			
			for(double difference : listOfDifferences) {
				double square = difference * difference;
				squares.add(square);
				
			}
			
			sum = 0;
			
			for(double number : squares) {
				sum += number;

			}
			
			double result = sum / (a.size() - 1);	
			
			double standardDeviation = Math.sqrt(result);
			
			return standardDeviation;
		}
		
		/**
		 * Calculate factorial of a number, referenced https://www.youtube.com/watch?v=0VoHk8a6F6E
		 * @param n
		 * @return
		 */
		public static BigInteger factorial(int n) {
			BigInteger factorial = BigInteger.ONE;
			
			for(int i = n; i > 0; i--) {
				factorial = factorial.multiply(BigInteger.valueOf(i));
			}
			return factorial;
		}
		
		/**
		 * Method to calculate permutations, referenced: https://www.tutorialspoint.com/multiply-one-biginteger-to-another-biginteger-in-java#:~:text=To%20multiply%20one%20BigInteger%20to,the%20BigInteger%20multiply()%20method.
		 * and https://www.geeksforgeeks.org/biginteger-divide-method-in-java-with-examples/
		 * @param n
		 * @param r
		 * @return
		 */
		public BigInteger calculatePermutations(int n, int r) {
			
			BigInteger denominator = factorial(n-r);
			BigInteger permutation = factorial(n).divide(denominator);
			
			return permutation;
		}
		
		/**
		 * Method to calculate combinations, referenced the same material as calculatePermutations(int n, int r) 
		 * @param n
		 * @param r
		 * @return
		 */
		public BigInteger calculateCombinations(int n, int r) {
			
			BigInteger denominator = factorial(r).multiply(factorial(n-r));
			BigInteger combination = factorial(n).divide(denominator);
			
			return combination;
		}	
}
