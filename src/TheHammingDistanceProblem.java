import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TheHammingDistanceProblem {
	static int N, H, maxSteps;
	
	public static void main(String []args) throws IOException {		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = in.readLine();
		int T = Integer.parseInt(line);		
		for (int i = 0; i < T; i++) {	
			in.readLine();		
			if(i>0)
				sb.append("\n");
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			N = Integer.parseInt(tokenizer.nextToken());
			H = Integer.parseInt(tokenizer.nextToken());	
			maxSteps = getMaxSteps(N,H);
			System.out.println(maxSteps);
			for (int j = (1<<H)-1; j < (1<<N); j++) {
				if(Integer.bitCount(j)==H)
					sb.append(getHammingDistance(j, N)).append("\n");
			}	
		}		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);		
	}
	
	private static int getMaxSteps(int n2, int h2) {
		int sum = n2;
		for(int i = n2-1;i >n2-h2 && i > 0;i--){
			sum *=i; 
		}
		int div = h2;
		for(int i=h2-1; i> 0;i--){
			div *= i;
		}
		return sum/div;
	}
	


	static String getHammingDistance(int i, int n){
		return Integer.toBinaryString(i | (1<<n)).substring(1);
	}
}
