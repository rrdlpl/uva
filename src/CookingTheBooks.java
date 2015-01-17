import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CookingTheBooks {

	public static void main(String []args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCases= Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testCases; i++) {
			String output = getNumbers(i+1,in.readLine());
			
			sb.append(output);
			
		}
		System.out.println(sb.toString());
	}

	private static String getNumbers(int i,String n) {
				
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < n.length(); j++) {
			for (int k = j+1; k < n.length(); k++) {
				char [] number = n.toCharArray();
				if(number[j] > number[k]&& !(j==0&&number[k] == '0')){
					char aux = number[j];
					number[j] = number[k];
					number[k] = aux;
					min = Math.min(min, Integer.parseInt(String.valueOf(number)));
				}
				number = n.toCharArray();
				if(number[k] > number[j]){
					char aux = number[k];
					number[k] = number[j];
					number[j] = aux;
					max = Math.max(max, Integer.parseInt(String.valueOf(number)));
				}
					
			}			
			
		}
		
		return "Case #"+i+": "+Math.min(min, Integer.parseInt(n))+" "+Math.max(max, Integer.parseInt(n))+"\n";
	}
}
