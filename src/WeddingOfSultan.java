import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class WeddingOfSultan {
	static int []degrees;
	static boolean []present;
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int i = 1; i <= T; i++) {
			init();
			sb.append("Case ").append(i).append("\n");
			line = in.readLine();
			SetDegree(line);
			line = GetAnswer();
			sb.append(line);
			
		}
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}
	private static void SetDegree(String line) {
		Stack<Character> stack = new Stack<Character>();
		stack.push(line.charAt(0));
		present[line.charAt(0)-'A'] = true;		
		int i = 1;
		while(!stack.isEmpty()){
			char p = stack.pop();
			char c = line.charAt(i);
			if(p == c){
				if(stack.isEmpty()) break;
				degrees[stack.peek()-'A']++;				
			}else{
				stack.push(p);
				stack.push(c);
				present[c-'A'] = true;
				degrees[c-'A']++;
			}
			i++;
			
		}
	}
	static void init(){
		degrees = new int['Z'-'A'+1];
		present = new boolean['Z'-'A'+1];
	}
	
	static String GetAnswer(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < degrees.length; i++) {
			if(present[i]){
				sb.append((char)(i + 'A')).append(" = ").append(degrees[i]).append("\n");
			}
		}
		return sb.toString();
	}

}
