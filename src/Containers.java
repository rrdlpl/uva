import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Containers {

	//static Stack<Integer> [] containers = new Stack<Integer>;
	
	static ArrayList<Stack<Character>> containers;
	
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		String line;
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (!(line = in.readLine()).equals("end")){
			char [] cargo = line.toCharArray();	
			containers =new ArrayList<Stack<Character>>();
			containers.add(new Stack<Character>());
			for (int i = 0; i < cargo.length; i++) {
				pushCargo(cargo[i]);
			}
			sb.append("Case ").append(t).append(": ").append(containers.size()).append("\n");
			t++;
		}		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
		
	}

	private static void pushCargo(char c) {
		int index = -1;
		int min, max = Integer.MAX_VALUE;
		for (int i = 0; i < containers.size(); i++) {
			if(containers.get(i).isEmpty()){
				index = i;
				break;
			}	
			min = containers.get(i).peek() - c; 
			if(min>=0 && min < max){
				max = min;
				index = i;
			}
		}
		if(index == -1){
			Stack<Character> container = new Stack<Character>();
			container.push(c);
			containers.add(container);
			return;
		}
		containers.get(index).push(c);
	}
}
