import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ProfessorLazy {
	
	
	public static void main(String []args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();				
		while(true)
		{
			StringTokenizer tokenizer = new  StringTokenizer(in.readLine());
			long alpha = Long.parseLong(tokenizer.nextToken());
			long beta = Long.parseLong(tokenizer.nextToken());
			long n = Long.parseLong(tokenizer.nextToken());
			if(n==0&&alpha==0&&beta==0)break;
			sb.append(getQn(n, alpha, beta)).append("\n");
			
		}				
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
		
	}
	
	public static long getQn(long n, long alpha, long beta)
	{	
		switch ((int)  (n %5)) {
		case 0:
			return alpha;
		case 1:
			return beta;
		case 2:
			return (beta+1)/alpha;
		case 3:
			return (alpha+beta+1)/(alpha*beta);
		case 4:
			return (alpha+1)/beta;		
		}
		return -1;
	}
}
