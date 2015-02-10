import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParenthesesBalance {

	static Stack<Character> stack;
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {			
			char [] parenteses = in.readLine().toCharArray();
			sb.append(hasBalance(parenteses) ? "Yes" : "No").append("\n");			
		}
		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}
	
	public static boolean hasBalance(char [] parenteses){
		stack = new Stack<Character>();
		for (int i = 0; i < parenteses.length; i++) {
			if(parenteses[i] == '(' || parenteses[i] == '['){
				stack.push(parenteses[i]);
			}else if(parenteses[i] == ')'){
				if(stack.isEmpty() || stack.pop() != '(')
					return false;
			}
			else if(parenteses[i] == ']'){
				if(stack.isEmpty() || stack.pop() != '[')
					return false;
			}
		}		
		return true && stack.isEmpty();
	}
}
