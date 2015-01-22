import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SpiralTap {

	static long col = -1, row = -1;

	static int [] movesRow = new int[]{-1,0,1,0};//
	static int [] movesCol = new int[]{0,-1,0,1};
	static int [][]grid;// = new int[SZ][SZ];
	
	public static void main(String []args) throws IOException{		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		long SZ = Integer.parseInt(tokenizer.nextToken());
		long P = Long.parseLong(tokenizer.nextToken());
				
		StringBuilder sb = new StringBuilder();
		  
		while(true){
		   
		   //grid = new int[SZ][SZ];
		   //fill(SZ-1,SZ-1 ,P, SZ*SZ);
		   fillB(SZ,P);
		   sb.append("Line = "+row+", column = "+col+".");
		   tokenizer = new StringTokenizer(in.readLine());
		   SZ = Long.parseLong(tokenizer.nextToken());
		   P = Long.parseLong(tokenizer.nextToken());
		   if(SZ==0&&P==0) break;
		   sb.append("\n");
		   
		}
		System.out.print(sb.toString());
		
	}
	
	public static void fillB(long sz, long p){
		long max = sz*sz;		
		
		long endX = sz/2+1, endY = sz/2+1;
		
		long x = 1, y = sz;
		row = endX;
		col = endY;
		while(x!=endX&&y!=endY){
			/*if((max-y*4-5)>p){
				max -=y*4-5; 
			}else{*/
				for (long i = y; i >= x; i--) {
					if(max==p){
						row =i;
						col = y;	
						return;
					}
					max--;				
				}
				for (long j = y-1; j>= x; j--) {
					if(max==p){
						row = x;
						col = j;
						return;
					}
					max--;					
				}
				for (long i = x+1; i <= y; i++) {
					if(max==p){
						row=i;
						col =x;
						return;
					}
					max--;
				}
				for (long j = x+1; j <=y-1 ; j++) {
					if(max==p){
						row =y;
						col=j;
						return;
					}
					max--;
				}
			}
			y--;
			x++;			
		//}		
	}
	/*
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
	}*/
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
	/*
	private static boolean canMove(int i, int j) {
		return i >= 0 && i < grid.length && j>=0 && j< grid.length && grid[i][j] == 0;
	}*/
}
