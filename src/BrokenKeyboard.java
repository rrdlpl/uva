import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class BrokenKeyboard {
	static LinkedList<Character> list;	
	public static void main(String []args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder sb= new StringBuilder();
		
		while((line= in.readLine())!=null && !line.equals("")){
			list = new LinkedList<Character>();
			char [] l = line.toCharArray();
			for (int i = 0; i < l.length; i++) {
				if(l[i]=='['){
					int j = getNext(l,i);
					fill(l, i,j);
					i = j;
				}else if (l[i] != ']'){
					list.addLast(l[i]);
					
				}
			}
			for (char c :list) {
				sb.append(c);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}
	private static void fill(char []l, int i, int j) {
		for (int k = j;  k > i; k--) {
			list.addFirst(l[k]);
		}		
	}
	
	private static int getNext(char[] l, int i) {
		// TODO Auto-generated method stub
		for (int j = i+1; j < l.length; j++) {
			if(l[j]=='['||l[j]==']'){
				return j-1;
			}
		}
		return l.length-1;
	}

}
