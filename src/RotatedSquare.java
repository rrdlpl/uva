import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * UVA - 10855
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=1796&mosmsg=Submission+received+with+ID+14818424
 * @author R
 *
 */

public class RotatedSquare {

	
	public static void rotate(char [][]matrix){
		int n = matrix.length;
		char [][] aux = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = n- 1; j >= 0; j--) {		
				aux[j][n-i-1] = matrix[i][j];
			}
		}
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux.length; j++) {
				matrix[i][j] = aux[i][j];
			}
		}		
	}
	
	static void printMatrix(char[][] matrix) {
	    System.out.println("\nMatrix = \n");
	    for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.print("\n");
		}		
	}
	
	public static void main(String []args) throws IOException{
		/*int [][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(matrix);
		rotate(matrix);
		printMatrix(matrix);
		rotate(matrix);
		printMatrix(matrix);
		rotate(matrix);
		printMatrix(matrix);
		rotate(matrix);
		printMatrix(matrix);*/
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		char [][]A = new char[N][N];
		char [][]B = new char[n][n];
		StringBuilder sb = new StringBuilder();
		while(true){
			int [] freq = new int[4];
			for (int i = 0; i < A.length; i++) {
				A[i] = in.readLine().toCharArray();
			}
			for (int i = 0; i < B.length; i++) {
				B[i] = in.readLine().toCharArray();
			}
			for (int f = 0; f < freq.length; f++) {
				for (int i = 0; i <= A.length-B.length; i++) {
					for (int j = 0; j <= A.length-B.length; j++) {
						if(A[i][j] == B[0][0]){
							if(isSquareInside(A,B,i,j)){
								freq[f]++;
							}
						}
					}
				}
				if(f==3){
					sb.append(freq[f]);					
				}
				else{
					sb.append(freq[f]+" ");
					rotate(B);
				}
			}		
			tokenizer = new StringTokenizer(in.readLine());
			N = Integer.parseInt(tokenizer.nextToken());
			n = Integer.parseInt(tokenizer.nextToken());
			if(N==0 && n==0) break;
			sb.append("\n");
			A = new char[N][N];
			B = new char[n][n];
		}
		System.out.println(sb.toString());
		in.close();
		System.exit(0);
		
	}

	private static boolean isSquareInside(char[][] a, char[][] b, int row, int col) {			
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if(a[i+row][col+j] != b[i][j])
					return false;
			}
		}
		return true;
	}

	
}
