import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.Arrays;

/**
 * 
 * 
 * This class is to test the StatsLibrary class' methods.
 * 
 * @author galovillacis
 *
 */

public class StatsLibraryTester {

	public static void main(String [] args) {
		
		StatsLibrary test = new StatsLibrary();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int [] a = {1,5,7,8};
		int [] b = {5,1,6,2,2,35,6,323,5,7,8};
		Set<Integer> array = new HashSet<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		test.findUnion(a, b, array);
		System.out.println("The union of array a and b is: " + array);
		System.out.println("The intersection of array a and b is: " + Arrays.toString(test.findIntersection(a, b)));
		System.out.println("The complement of array a to array b is: " + Arrays.toString(test.findComplement(a, b)));

		System.out.println("The mean of the array list is: " + test.calculateMean(list));
		test.calculateMedian(list);
		test.calculateMode(list);
		System.out.println("The standard deviation of the array list is: " + String.format("%.2f", test.calculateStandardDeviation(list)) + "%");
		
		System.out.println("Permutation of given numbers: " + test.calculatePermutations(5, 2));
		System.out.println("Combination of given numbers: " + test.calculateCombinations(5, 2));
	}
}


