import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ArmyBuddiesV2 {
	
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int s = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		int []soldiersRight = new int[100010];
		int []soldiersLeft = new int[100010];
		StringBuilder sb = new StringBuilder();
		while(!(s==0&&b==0)){
			for (int i = 1; i < s+1; i++) {
				soldiersRight[i] = i+1; //Neighbor
				soldiersLeft[i] = i-1;
			}
			
			for (int i = 0; i < b; i++) {
				tokenizer = new StringTokenizer(in.readLine());
				int l = Integer.parseInt(tokenizer.nextToken());
				int r = Integer.parseInt(tokenizer.nextToken());				
				int leftSoldier = soldiersLeft[l];
				int rightSoldier = soldiersRight[r];
				String ans = String.format("%s %s\n", leftSoldier == 0? "*": leftSoldier,rightSoldier == s+1? "*": rightSoldier);
				
				soldiersLeft[rightSoldier] = leftSoldier;
				soldiersRight[leftSoldier] = rightSoldier;
				
				sb.append(ans);
			}
			sb.append("-\n");	
			tokenizer = new StringTokenizer(in.readLine());
			s = Integer.parseInt(tokenizer.nextToken());
			b = Integer.parseInt(tokenizer.nextToken());			
		}
		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}
	
}
