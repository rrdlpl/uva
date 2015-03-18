import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TheHammingDistanceProblem {
	
	public static void main(String []args) throws IOException{		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = in.readLine();
		int T = Integer.parseInt(line);		
		for (int i = 0; i < T; i++) {	
			in.readLine();		
			if(i>0)
				sb.append("\n");
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(tokenizer.nextToken());
			int H = Integer.parseInt(tokenizer.nextToken());
			for (int j = (1<<H)-1; j < (1<<N); j++) {
				if(Integer.bitCount(j)==H)
					sb.append(getHammingDistance(j, N)).append("\n");
			}	
		}		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
		
	}
	
	static String getHammingDistance(int i, int n){
		return Integer.toBinaryString(i | (1<<n)).substring(1);
	}
}
