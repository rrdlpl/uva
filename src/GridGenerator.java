
public class GridGenerator {
	
	static int [] movesRow = new int[]{0,-1,-1};
	static int [] movesCol = new int[]{-1,0,-1};
	
	public static int generate(int[] row, int[] col){
		int [][]grid = new int [row.length][row.length];
		for (int i = 0; i < row.length; i++) {
			grid[i][0] = col[i];
			grid[0][i] = row[i];					
		}
		
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid.length; j++) {
				for (int k = 0; k < movesRow.length; k++) {
					int val = grid[i+movesRow[k]][j+movesCol[k]];
					grid[i][j]+= val;
				}
			}
		}
		
		return grid[row.length-1][row.length-1];
	}
	
	/*public static void main(String [] args){
		int[] a = new int[]{9,9,9,9,9,9,9,9,9,9}
;
		int[] b = new int[]{9,9,9,9,9,9,9,9,9,9}
;
		System.out.println(generate(a, b));
	}*/

}
