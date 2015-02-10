import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class GeneralizedMatrioshkas {

	static Stack<Integer> stack;
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = in.readLine())!=null && !line.equals("")){
			sb.append(isMatrioshkable(line)? ":-) Matrioshka!" :":-( Try again.").append("\n");
		}
		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}
	
	public static boolean isMatrioshkable(String line){
		stack = new Stack<Integer>();
		Stack<Integer> sumas = new Stack<Integer>();
		StringTokenizer tokenizer = new StringTokenizer(line);		
		int sum = 0;
		while(tokenizer.hasMoreTokens()){
			int toy = Integer.parseInt(tokenizer.nextToken());			
			if(stack.isEmpty()){
				stack.push(toy);
				sumas.push(Math.abs(toy));
				continue;
			}
			int top = stack.peek();
			if(toy < 0 && Math.abs(top) < Math.abs(toy)){
				return false;
			}else if(toy < 0 && Math.abs(top) > Math.abs(toy)){
				stack.push(toy);	
				sumas.push(Math.abs(toy));
			}
			if(toy > 0 && Math.abs(top) != Math.abs(toy)){
				return false;
			}else if(toy > 0 && Math.abs(top) == Math.abs(toy)){
				stack.pop();						
			}
			
		}
		return true && stack.empty();
	}
}
