import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Rails {

	static int[] coaches = new int[1001];
	public static void initialize(){
		for (int i = 1; i < coaches.length; i++) {
			coaches[i] = i;
		}
	}
	static int i = 1;
	
	static Stack<Integer> station;
	public static void main(String [] args) throws IOException{
		initialize();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line);
		StringBuilder sb = new StringBuilder();
		boolean ans = true;
		while(n != 0){			
			while ((line= in.readLine())!=null && !line.equals("0")){
				station = new Stack<Integer>();
				StringTokenizer tokenizer = new StringTokenizer(line);
				for (int j = 0; j < n; j++) {
					int coach = Integer.parseInt(tokenizer.nextToken());
					if(!canOrder(coach)){
						ans = false;
						break;
					}					
				}
				sb.append(ans? "Yes" : "No").append("\n");
				i = 1;
				ans = true;
			}
			n = Integer.parseInt(in.readLine());
		}
		
		in.close();
		System.exit(0);
	}
	private static boolean canOrder(int coach) {
		if(!station.isEmpty() && station.peek()> coach){
			return false;
		}else{
			if(station.peek() == coach){
				station.pop();
				return true;
			}
			for (; i <= coach ; i++) {
				station.push(coaches[i]);
			}
			station.pop();
			//i++;
		}
		return true;
	}
}
