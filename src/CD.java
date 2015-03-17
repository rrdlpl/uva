import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class CD {
	static int Time, nTracks;
	static int [] Tracks;	
	static ArrayList<Integer> solution;
	
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder sb = new StringBuilder();
		while((line = in.readLine()) != null && !line.equals("")){
			StringTokenizer tokenizer = new StringTokenizer(line);
			Time = Integer.parseInt(tokenizer.nextToken());
			nTracks = Integer.parseInt(tokenizer.nextToken());
			Tracks = new int[nTracks];
			solution = new ArrayList<Integer>();
			for (int i = 0; i < nTracks; i++) {
				Tracks[i] = Integer.parseInt(tokenizer.nextToken());
			}
			int sum = solve(0);
			System.out.println(sum);
		}
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}
	
	static int solve(int i){
		int sum = 0;		
		for (int k = i; k < Tracks.length; k++) {
			int t = Tracks[k];
			sum +=t;
			if(sum > Time) continue;
			if(sum == Time){
				solution.add(t);
				
				return sum;				
			}
		}
		return sum;
	}

}
