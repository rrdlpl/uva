import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SymmetricMatrix {
	
	
	
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		int T = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < T ; i++) {
			StringTokenizer tokenizer = new StringTokenizer(in.readLine(),"N = ");
			int N = Integer.parseInt(tokenizer.nextToken());
			long [][]matrix = new long[N][N];
			for (int j = 0; j < matrix.length; j++) {
				tokenizer = new StringTokenizer(in.readLine());
				for (int k = 0; k < matrix.length; k++) {
					matrix[j][k] = Long.parseLong(tokenizer.nextToken());
				}
			}
			sb.append("Test #").append(i+1).append(": ").append(isSymmetric(matrix)? "Symmetric.\n": "Non-symmetric.\n");
			
		}			
		//int [][] matrix = new int[][]{{5,1,3,4},{2,0,2,2},{2,2,0,2},{4,3,1,5}};
		//System.out.println(isSymmetric(matrix));
		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}
	
	public static  boolean isSymmetric(long [][]matrix){
		int N = matrix.length;
		int end = N % 2 == 0 ? N : N/2 +1;
		for (int i = 0; i < end; i++) {
			for (int j = 0; j < N; j++) {
				if(matrix[i][j]<0 || matrix[N-i-1][N-j-1]<0||matrix[N-i-1][N-j-1] != matrix[i][j]) return false;
			}			
		}		
		return true;
	}
}
