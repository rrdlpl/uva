import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 11933 - Splitting Numbers
 * @author R
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3084
 */

public class SplittingNumbers {


	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
		for (int s = Integer.parseInt(in.readLine()); s > 0 ; s = Integer.parseInt(in.readLine())){
			int a=0, b=0;
			while(s!=0){
				a |= (s&(-s)); //turn on in a lsb
				s =   s&(s-1); //turn off lsb in s
				b |= (s&(-s)); //turn on in b lsb
				s = s&(s-1);   //turn off lsb in s
			}
			sb.append(a+" "+b+"\n");			
	    }
		System.out.print(sb.toString());
	}
}
	
