/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ArmyBuddies {

	static final int DEAD = 1;
	static final int ALIVE= 0;
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int s = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		int []soldiers = new int[s];
		StringBuilder sb = new StringBuilder();
		while(!(s==0&&b==0)){
			for (int i = 0; i < b; i++) {
				tokenizer = new StringTokenizer(in.readLine());
				int l = Integer.parseInt(tokenizer.nextToken()) -1;
				int r = Integer.parseInt(tokenizer.nextToken()) -1;
				for (int j = l; j <= r; j++) {
					soldiers[j] = DEAD;
				}
				int rightSoldier = -1;
				for (int j = r+1; j < soldiers.length&& rightSoldier==-1; j++) {
					if(soldiers[j] == ALIVE) 
						rightSoldier = j+1;
				}
				int leftSoldier = -1;
				for (int j = l-1; j >= 0&& leftSoldier==-1 ; j--) {
					if(soldiers[j] == ALIVE)
						leftSoldier = j+1;
				}
				String ans = String.format("%s %s\n", leftSoldier == -1? "*": leftSoldier,rightSoldier == -1? "*": rightSoldier);
				sb.append(ans);
			}
			sb.append("-\n");	
			tokenizer = new StringTokenizer(in.readLine());
			s = Integer.parseInt(tokenizer.nextToken());
			b = Integer.parseInt(tokenizer.nextToken());
			soldiers = new int[s];
		}
		in.close();
		System.out.print(sb.toString());
		System.exit(0);
	}
	
}*/
