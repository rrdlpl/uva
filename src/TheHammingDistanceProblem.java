import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TheHammingDistanceProblem {
	static int N, H, maxSteps;
	static char [] output;
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
			int last  = (1<<H)-1;
			int step = 0;
			sbDistance = new StringBuilder();
			hammingDistance(N, H, last, step);
			sb.append(sbDistance.toString()).append("\n");
			
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
	
	static StringBuilder sbDistance;
	
	private static void hammingDistance(int n, int h , int last, int step){
		if(step == maxSteps){
			return;
		}
		if(Integer.bitCount(last) == h){
			sbDistance.append(getHammingDistance(last, n)).append("\n");
		}else{
			step--;
		}
		hammingDistance(n, h, last+1, step+1);
	}

	static String getHammingDistance(int i, int n){
		return Integer.toBinaryString(i | (1<<n)).substring(1);
	}
}
