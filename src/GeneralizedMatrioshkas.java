import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
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
		StringTokenizer tokenizer = new StringTokenizer(line);                 
		HashMap<Integer, Integer> sumas = new HashMap<Integer, Integer>();                            
		while(tokenizer.hasMoreTokens()){
			int toy = Integer.parseInt(tokenizer.nextToken());                                         
			int toyAbs = Math.abs(toy);
			if(stack.isEmpty()){
				stack.push(toy);
				sumas.put(toyAbs,0);
				continue;
			}
			int top = stack.peek();
			int topAbs = Math.abs(top);
			if(toy < 0 && sumas.get(topAbs)+toyAbs>=topAbs){
				return false;
			}                             
			else if(toy < 0 && topAbs > toyAbs){
				stack.push(toy);
				sumas.put(topAbs, sumas.get(topAbs)+toyAbs);
				sumas.put(toyAbs,0);


			}
			if(toy > 0 && topAbs != toyAbs){
				return false;
			}else if(toy > 0 && topAbs == toyAbs){
				stack.pop();       
				sumas.remove(toyAbs);
			}

		}
		return true && stack.empty();
	}
}