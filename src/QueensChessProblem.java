import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author R
 *
 */
public class QueensChessProblem {
	
	static int row[];
	static int solNumber, a, b;
	static StringBuilder testSol;
	
		
	public static void main(String []args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = in.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line);
		int T = Integer.parseInt(tokenizer.nextToken());
		for (int t = 0; t < T; t++) {
			in.readLine();
			line = in.readLine();
			if(t>0)
				sb.append("\n");
			tokenizer = new StringTokenizer(line);
			sb.append("SOLN       COLUMN\n");
			sb.append(" #      1 2 3 4 5 6 7 8\n\n");
			a = Integer.parseInt(tokenizer.nextToken())-1;
			b = Integer.parseInt(tokenizer.nextToken())-1;			
			row = new int[8];
			testSol = new  StringBuilder();
			solNumber = 0;
			backtrack(0);
			sb.append(testSol.toString());			
			
		}		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}
	
	static void backtrack(int c){
		
		if(c == 8 && row[b] == a){			
			if(++solNumber<10)
				testSol.append(" ");			
			testSol.append(solNumber).append("     ");
			for (int i = 0; i < row.length; i++) {
				testSol.append(" ").append(row[i]+1);
			}
			testSol.append("\n");
		}
		for (int r = 0; r < row.length; r++) {
			if(c == b && r != a) continue;
			if(canPlace(r,c)){
				row[c] = r;
				backtrack(c+1);
			}
		}
			
	}

	private static boolean canPlace(int r, int c) {
		for (int i = 0; i < c; i++) {
			if(row[i] == r || (Math.abs(row[i]-r)==Math.abs(i-c))){
				//if in same row, column or in diagonal
				return false;
			}				
		}
		return true;
	}

}
