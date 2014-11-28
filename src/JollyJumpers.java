import java.io.IOException;
import java.util.Scanner;


public class JollyJumpers {
	
	public static boolean IsJolly(int [] sequence){
		if(sequence.length == 1) return true;
		for(int i=0; i<sequence.length-1;i++){
			int a = sequence[i];
			int b = sequence[i+1];
			if(!IsJolly(sequence.length,a, b))
				return false;
		}
		return true;
	}
	
	public static boolean IsJolly(int n, int a, int b){
		int abs = Math.abs(a-b);
		boolean jolly = abs >= 1 && abs <= (n-1);
		return jolly;
	}
	
	public static void main(String [] args) throws IOException{
		 Scanner in = new Scanner(System.in);		
		 while (in.hasNextInt()) {
			 int n  = in.nextInt();
			 int []  sequence = new int [n];
			 for(int i=0; i<n;i++){
				 sequence[i] = in.nextInt();
			 }
			 System.out.println(IsJolly(sequence)? "Jolly" : "Not jolly");
		 }
		 in.close();
	
	}
}
