import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SpiralTap {

	static int col = -1, row = -1;

	static int [] movesRow = new int[]{-1,0,1,0};//
	static int [] movesCol = new int[]{0,-1,0,1};
	static int [][]grid;// = new int[SZ][SZ];
	
	public static void main(String []args) throws IOException{		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int SZ = Integer.parseInt(tokenizer.nextToken());
		int P = Integer.parseInt(tokenizer.nextToken());
				
		StringBuilder sb = new StringBuilder();
		  
		while(true){
		   
		   grid = new int[SZ][SZ];
		   //fill(SZ-1,SZ-1 ,P, SZ*SZ);
		   fill(SZ,P);
		   sb.append("Line = "+row+", column = "+col+".");
		   tokenizer = new StringTokenizer(in.readLine());
		   SZ = Integer.parseInt(tokenizer.nextToken());
		   P = Integer.parseInt(tokenizer.nextToken());
		   if(SZ==0&&P==0) break;
		   sb.append("\n");
		   
		}
		System.out.print(sb.toString());
		
	}
	
	public static void fill(int sz, int p){	 
	    
		int max  = sz*sz;			
		int i = sz-1,j =sz-1;
		int direction = 0;
		int lasDirection = -1;
		while (canMove(i, j)) {
			if(p==max) {
				row = i+1;
				col = j+1;
				return;
			}
			grid[i][j] = max;			
			int nextRow = i+ movesRow[direction];
			int nextcol = j+ movesCol[direction];
			int tries = 4;
			boolean canMove= canMove(nextRow, nextcol);
			while(!canMove&&tries>0){
				direction++;
				if(direction>3) direction =0;
				tries--;
				nextRow = i+ movesRow[direction];
				nextcol = j+ movesCol[direction];
				canMove = canMove(nextRow, nextcol);
				
			}
			if(canMove){
				i = nextRow;
				j = nextcol;
			}			
			max--;
		}		
	}
	/*
	
	private static void fill(int i, int j, int p, int filler) {
		// TODO Auto-generated method stub
		if(!canMove(i,j))return;
		if(p==filler) {
			row = i+1;
			col= j+1;
			return;
		}
		grid[i][j] = filler;
		filler--;
		for (int k = 0; k < movesRow.length; k++) {			
			fill(i+movesRow[k], j+movesCol[k],p, filler);
		}
	}	*/
	private static boolean canMove(int i, int j) {
		return i >= 0 && i < grid.length && j>=0 && j< grid.length && grid[i][j] == 0;
	}
}
