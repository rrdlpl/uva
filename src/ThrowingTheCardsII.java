import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ThrowingTheCardsII {

	public static void main(String []args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;
        boolean first = true;
        while((n = Integer.parseInt(in.readLine())) != 0){
                        int lastcard = getLastCard(n);
                        //if(!first)
                                        
                        sb.append(lastcard == 0 ? n : lastcard);
                        sb.append("\n");
                        first = false;
        }
        System.out.print(sb.toString());                             
	}

	private static int getLastCard(int n) {
		int algo = (int)Math.floor(Math.log10(n)/Math.log10(2));
		int out = (n - (1<<algo))*2;
		return out;
	}
	
	private static int getLastCardB(int n){
		int card = ((~Integer.highestOneBit(n)&n))<<1;	
		return card;
		
	}
	
	
}
