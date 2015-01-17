import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

/***
 * 11340 - Newspaper
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2315
 * @author R
 *
 */
public class Newspaper {

	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int  t = Integer.parseInt(in.readLine());
		
		
		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(in.readLine());			
			HashMap<Character, Integer> paidCharacters = new HashMap<Character, Integer>();
			int price = 0; 
			for (int j = 0; j < k; j++) {
				StringTokenizer tokenizer = new StringTokenizer(in.readLine());
				char c =  tokenizer.nextToken().charAt(0);
				int value = Integer.parseInt(tokenizer.nextToken());
				paidCharacters.put(c, value);
			}
			int m = Integer.parseInt(in.readLine());
			for (int l = 0; l < m; l++) {
				char [] line = in.readLine().toCharArray();
				for (int j = 0; j < line.length; j++) {
					if(!paidCharacters.containsKey(line[j])) continue;
					price += paidCharacters.get(line[j]); 
				}
			}
			
			//double p =(Double.valueOf(price)/100);
			//sb.append(String.valueOf(p)+"$\n");
			System.out.printf(Locale.ENGLISH,"%1.2f$\n",(price)/100.0);
			
		}
		in.close();
		System.exit(0);
		//System.out.print(sb.toString());
	}
}
