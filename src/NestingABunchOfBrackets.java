import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;


public class NestingABunchOfBrackets {

	static Stack<Character> stack;   
	static HashMap<Character, Character> popable;
	
	/*(   )
	[   ]
	{   }
	<   >
	(*   *)*/
	static void init(){
		popable = new HashMap<Character, Character>();		
		popable.put(')', '(');
		popable.put(']', '[');
		popable.put('}', '{');
		popable.put('>', '<');
		
	}

	public static void main(String []args) throws IOException{            
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		init();
		while((line = in.readLine())!= null && !line.equals("")){
			sb.append(match(line)).append("\n");
		}                             
		System.out.print(sb.toString());               
		in.close();
		System.exit(0);
	}

	static String match(String line){
		stack = new Stack<Character>();
		char [] input = line.toCharArray();
		int k = 1;		
		boolean ans = true;
		for (int i = 0; i < input.length && ans; i++) {
			char c = input[i];
			char c2;
			if(i+1 < input.length){
				c2 = input[i+1];				
			}
			else{
				c2 =' ';
				k--;
			}
			
			if(isPopableSpecial(c, c2)){				
				char top = 0;				
				while(!stack.isEmpty()){
					int ini = stack.size();
					while(!stack.isEmpty() && (top = stack.pop())!= '*'){
						k--;
						if(popable.containsValue(top)){
							k+=1;
							ans = false;
							break;
						}
					}
					k += ini - stack.size();
					if(top != '*' || stack.isEmpty()){
						k-=2;
						ans = false;
						break;
					}
					if(stack.peek() == '(') break;
					
					
				}				
				
			}else if(popable.containsKey(c)){				
				char p = popable.get(c);
				char top = ' ';
				int ini  = stack.size();
				while(!stack.isEmpty()&& (top = stack.pop())!= p){
					k--;
				}
				//poped++;
				k += (ini - stack.size()); 
				if(p != top){					
					ans = false;
					break;
				}
				
			}else{
				k++;
				stack.push(c);
			}
		}

		return ans  ? "YES" : "NO "+(k);
	}

	private static boolean isPopableSpecial(char c, char c2) {
		return c == '*' && c2 ==')';
	}
	
    private static boolean isStackableSpecial(char c, char c2) {
        return c=='('&&c2=='*';
    }
	


}