import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ContestScoreboard {
	

	public static class Contestant implements Comparable<Contestant>{
		int teamNumber;
		int[] tries;
		boolean []solved;
		int problemsSolved;
		int timeSpent;
		public Contestant(int t){
			teamNumber = t;
			tries = new int[10];
			solved = new boolean[10];
			timeSpent = 0;
			problemsSolved =0;
		}
		
		public int compareTo(Contestant o) {
			if(this.problemsSolved == o.problemsSolved){
				if(this.timeSpent == o.timeSpent){
					return this.teamNumber- o.teamNumber;
				}
				return this.timeSpent - o.timeSpent;
			}
			return o.problemsSolved - this.problemsSolved;
		}
		
		public void correct(int i, int t){
			if(!solved[i]){
				solved[i]= true;
				problemsSolved++;
				timeSpent +=t+tries[i]*20;
			}
		}
		public void incorrect(int i){
			if(!solved[i]){				
				tries[i]++;
			}
		}
		
	}
	
	static int [] contestants;
	
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		in.readLine();
		for (int i = 0; i < testCases; i++) {
			
			contestants = new int[101];
			ArrayList<Contestant> concursantes = new ArrayList<Contestant>();			
			String line;
			if (i>0)
				sb.append("\n");
			while((line = in.readLine()) != null && !line.equals("")){ 
				StringTokenizer tokenizer = new StringTokenizer(line);
				int c = Integer.parseInt(tokenizer.nextToken());
				Contestant contestant;
				if(contestants[c]==0){
					contestant = new Contestant(c);
					concursantes.add(contestant);
					contestants[c] = concursantes.size()+1;
				}else{
					contestant = concursantes.get(contestants[c]-2);
				}				
				int problem = Integer.parseInt(tokenizer.nextToken());
				int time = Integer.parseInt(tokenizer.nextToken());
				String result = tokenizer.nextToken();
				if(result.equals("C")){
					contestant.correct(problem, time);
				}else if(result.equals("I")){
					contestant.incorrect(problem);
				}				
			}
			Collections.sort(concursantes);
			for (Contestant contestant : concursantes) {
				sb.append(contestant.teamNumber).append(" ")
												.append(contestant.problemsSolved)
												.append(" ")
												.append(contestant.timeSpent)
												.append("\n");
			}
			
		}	
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}

}
