import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
 
public class F91 {
 
    public static void main(String []args) throws NumberFormatException, IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n;
        StringBuilder sb = new StringBuilder();
       
        while((n = Integer.parseInt(in.readLine())) != 0){
            sb.append("f91(").append(n).append(") = ");
            if(n<=100)
            	sb.append("91");
            else
                sb.append(n-10);
            //if((n = Integer.parseInt(in.readLine())) == 0) break;
            sb.append("\n");
        }
        System.out.print(sb.toString());                               
    }
}