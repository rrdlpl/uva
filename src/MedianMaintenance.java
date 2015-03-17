import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class MedianMaintenance {
	
	static PriorityQueue<Integer> Hlow, Hhigh;
	static int [] medians;
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int median = 1;
		int N = 300;
		String line;
		medians = new int[N+1];
		Hlow= new PriorityQueue<Integer>();
		Hhigh= new PriorityQueue<Integer>();
		while((line = in.readLine()) != null && !line.equals("")){
			int m = Integer.parseInt(line);
			setMedian(m, median++);
		}
		int sum = 0;
		for (int i = 1; i < medians.length; i++) {
			System.out.println(i+ " = "+ medians[i]);
			sum += medians[i];
		}
		System.out.println(sum + " % 10000 = "+ (sum%10000));
		in.close();
		System.exit(0);
	}
	
	//Hlow => extractMax
	//Hhigh => extractMin 
	public static void setMedian(int m, int k){
		if(k == 1){
			Hlow.add(-m);
			medians[k] = m;
			return;
		}
		int slow = Hlow.size();
		int shigh = Hhigh.size();
		Integer topInLow = Math.abs(Hlow.peek());		
		if(m<topInLow){
			Hlow.add(-m);
		}else if(Hhigh.isEmpty() || m>Hhigh.peek()){
			Hhigh.add(m);
		}else{
			if(slow<=shigh)
				Hlow.add(-m);
			else
				Hhigh.add(m);
		}
		rebalance();
		int topLow = Math.abs(Hlow.peek());
		slow = Hlow.size();
		shigh = Hhigh.size();
		if((slow+shigh)%2 == 1){
			if(slow == (k+1)/2)
				medians[k] = topLow; //Hlow.peek();
			else 
				medians[k] = Hhigh.peek();// Hhigh.peek();//(topLow + Hhigh.peek())/2;			
		}else{
			System.out.print(Hlow.size()+" "+ Hhigh.size());
			medians[k] = topLow;
			/*if(slow == (k/2))
				medians[k] = Math.min(topLow, Hhigh.peek());
			else
				medians[k] = Math.min(topLow, Hhigh.peek());*/
		}
		
	}

	private static void rebalance() {
		int slow = Hlow.size();
		int shigh = Hhigh.size();
		int unbalance = slow - shigh;
		if(unbalance == 0) return;
		if(unbalance<0){
			Hlow.add(-Hhigh.poll());
		}else{
			Hhigh.add(-Hlow.poll());
		}	
	}

}
