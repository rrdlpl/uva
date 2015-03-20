import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Continents {
	static int N, M;
	static char [][] map;
	static boolean [][] visited;
	static int [] x = {-1,  0,  1,  0};
	static int [] y = { 0, -1,  0,  1};
	static char land = ' ';
	static int biggestContinent;
	//{1, 1, 0,-1,-1,-1,  0,  1};
	//{0, 1, 1, 1, 0,-1, -1, -1};/

	public static void main(String []args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = in.readLine()) != null && !line.equals("")){
			StringTokenizer tokenizer = new StringTokenizer(line);
			N = Integer.parseInt(tokenizer.nextToken());
			M = Integer.parseInt(tokenizer.nextToken());                                  
			map = new char[M][N];
			visited = new boolean[M][N];
			for (int i = 0; i <M; i++) {
				map[i] = in.readLine().toCharArray();
			}
			tokenizer = new StringTokenizer(in.readLine());
			int i = Integer.parseInt(tokenizer.nextToken());
			int j = Integer.parseInt(tokenizer.nextToken());
			land = map[i][j];
			floodFill(i, j, land);
			biggestContinent = 0;
			floodFill(land);
			sb.append(biggestContinent).append("\n");
			in.readLine();
		}
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}

	private static void floodFill(char land2) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(!visited[i][j] && map[i][j] == land2){
					biggestContinent = Math.max(biggestContinent,floodFill(i, j, land2));
				}
			}
		}                             
	}

	private static int floodFill(int i, int j, char land2) {
		if(canMove(i)&&!visited[i][j]&&map[i][j] == land2){
			visited[i][j] = true;
			int sum = 1;
			for (int k = 0; k < x.length; k++) {
				sum +=floodFill(x[k]+i, getY(k, j), land2);
			}
			return sum;
		}
		return 0;
	}



	private static boolean canMove(int i) {                  
		return i>=0 && i<M;
	}

	private static int getY(int k, int j) {
		int ncol = y[k]+j;
		if(ncol>=N){
			return  0;
		}
		if(ncol<0){
			return N-1;
		}
		return ncol;
	}

}