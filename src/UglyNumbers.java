import java.util.TreeSet;
/***
 * 
 * @author R
 *
 */

public class UglyNumbers {
	
	public static void main(String []args){
		Long lastUgly = (long) 1;
		TreeSet<Long> tree = new TreeSet<Long>();
		tree.add(lastUgly);
		calculateUglyNumbers(tree, 1,1500);
		lastUgly = tree.first();		
		System.out.println("The 1500'th ugly number is "+lastUgly+".");
	}

	private static void calculateUglyNumbers(TreeSet<Long> tree, long s, int n) {
		tree.add(s);
		for (int i = 1; i < n; i++) {
			long lastUgly = tree.pollFirst();
			tree.add(lastUgly*2);
			tree.add(lastUgly*3);
			tree.add(lastUgly*5);
		}
	}
	
}
