import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SCC {	
	static boolean []visited;
	static int []finishingTimes;
	static long s;
	static int time;
	static int N;
	static ArrayList<Integer> [] graph;
	static ArrayList<Integer> [] graphReversed;
	static long [] array = new long[5];
	static TreeSet<Long> tree = new TreeSet<Long>();
	
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Users\\R\\Downloads\\SCC\\SCC.txt")));		
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		N++;
		init();		
		initGraphs(in);		
		DFSLoop();		
		initVisited();
		for (int i = N-1; i >= 1; i--) {
			if(!visited[finishingTimes[i]]){
				s = 0;
				countSize(finishingTimes[i]);
				tree.add(s);
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(tree.pollLast()+",");
		}
		in.close();
		System.exit(0);
	}
	
	
	private static void countSize(int i) {
		visited[i] = true;		
		for (int ady : graphReversed[i]) {
			if(!visited[ady])
				countSize(ady);
		}
		s++;
	}

	private static void initGraphs(BufferedReader in) throws IOException {
		StringTokenizer tokenizer;
		String line;
		while ((line = in.readLine())!= null && !line.equals("")) {
			tokenizer = new StringTokenizer(line);
			int u = Integer.parseInt(tokenizer.nextToken());
			int v = Integer.parseInt(tokenizer.nextToken());					
			graph[u].add(v);
			graphReversed[v].add(u);
		}
	}
	
	static void init(){		
		finishingTimes = new int[N];
		initVisited();
		graph = new ArrayList[N];
		graphReversed = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
			graphReversed[i] = new ArrayList<Integer>();
		}
	}

	private static void initVisited() {
		visited = new boolean[N];
	}
	
	static void DFSLoop(){
		for (int i = N-1; i >= 1; i--) {
			if(!visited[i]){
				s= i;
				DFS(i);
			}			
		}	
	}
	
	static void DFS(int i){
		visited[i] = true;		
		for (int ady : graph[i]) {
			if(!visited[ady])
				DFS(ady);
		}
		finishingTimes[++time] = i;
	}

}
