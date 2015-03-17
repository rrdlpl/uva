import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class StickerCollectorRobot {
	
	static char [][] grid;
	static char[] directions= {'N','O','S','L'}; // L east, O west
	static int []rows = {-1, 0, 1, 0};
	static int []cols = {0 ,-1, 0, 1};
	static int I, J, dir =-1; // initial position robot;
	static int N, M, S;
	static boolean found; //	
	
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder sb = new StringBuilder();
		while((line = in.readLine()) != null && !line.equals("")){
			StringTokenizer tokenizer = new StringTokenizer(line);
			N = Integer.parseInt(tokenizer.nextToken());
			M = Integer.parseInt(tokenizer.nextToken());
			S = Integer.parseInt(tokenizer.nextToken());
			grid = new char[N][M];
			if(N==0&&M==0&&S==0) break;
			for (int i = 0; i < N; i++){
				grid[i]= in.readLine().toCharArray();
				searchRobot(i);
			}
			String instructions = in.readLine();
			int collectedStickets = CollectStickers(instructions,S);
			sb.append(collectedStickets).append("\n");			
			found = false;
		}
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}

	private static void searchRobot(int i) {
		if(found) return;
		for (int j = 0; j < M; j++) {
			switch(grid[i][j]){
				case 'N':		
					setInitialdir(0, i, j);
					return;
				case 'L':
					setInitialdir(3, i, j);
					return;
				case 'S':
					setInitialdir(2, i, j);
					return;
				case 'O':
					setInitialdir(1, i, j);
					return;					
			}
		}
		
	}
	

	private static void setInitialdir(int k, int i, int j) {
		dir = k;
		I = i;
		J = j;
		found = true;
	}

	private static int CollectStickers(String instructions, int s) {
		int collectedStickers= 0;
		for (int i = 0; i < s; i++) {
			char instruction = instructions.charAt(i);
			switch (instruction) {
				case 'D':
					rotateRight();
					break;
				case 'E':
					rotateLeft();
					break;
				case 'F':
					if(canMove()){
						I = I + rows[dir];
						J = J + cols[dir];	
						char cell = grid[I][J];						
						if(cell == '*'){
							collectedStickers++;
							grid[I][J] = '.';
						}
					}
					break;
				default:
					break;
				}
		}		
		return collectedStickers;
	}

	private static boolean canMove() {
		int nextRow = I + rows[dir];
		int nextCol = J + cols[dir];		
		return nextRow>=0 && nextCol>=0 &&nextCol<M && nextRow < N && grid[nextRow][nextCol]!='#';
	}
	
	static void rotateLeft(){				
		if(++dir>3) dir=0;		
	}
	
	static void rotateRight(){		
		if(--dir<0) dir= 3;		
	}

}
