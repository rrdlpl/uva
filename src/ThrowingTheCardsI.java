import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class ThrowingTheCardsI {
	
	public static void main(String []args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//int n = Integer.parseInt(in.readLine());
		int n;
		boolean first= true;		
		while((n = Integer.parseInt(in.readLine())) != 0){
			if(n==1){
				sb.append("Discarded cards:\nRemaining card: 1\n");
				continue;
			}
			LinkedList<Integer> list = new LinkedList<Integer>();			
				
			for (int i = n; i >= 1; i--) {
				list.addLast(i);
			}
			
			sb.append("Discarded cards:");
			while(list.size() > 2){
				int last = list.getLast();
				sb.append(" "+last+",");
				list.removeLast();
				last = list.getLast();
				list.removeLast();
				list.addFirst(last);
				//list.addLast(first);
			}	
			sb.append(" "+list.getLast());
			sb.append("\nRemaining card: "+list.getFirst()+"\n");
			first = false;
		}
		System.out.print(sb.toString());		
	}

}
