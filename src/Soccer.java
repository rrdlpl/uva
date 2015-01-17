import java.util.TreeSet;
/***
 * SRM 194  
 * @author R
 *
 */

public class Soccer {
	
	public  int maxPoints(int[] wins, int[] ties){
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for (int i = 0; i < ties.length; i++) {
			tree.add(wins[i]*3+ties[i]);
		}
		return tree.last();
	}
	
	/*public static void main(String []args)
	{
		int[] a = new int[]{13,79,26,73,14,89,71,37,89,71,19,59,39};
		int[] b = new int[]{88,27,5,70,84,94,20,50,2,11,31,22,50};
		System.out.println(maxPoints(a, b));
		
		
	}*/

}
