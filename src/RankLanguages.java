import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
/***
 * 
 * @author R
 * 10336 - Rank the Languages
 * http://uva.onlinejudge.org/external/103/10336.html
 */

public class RankLanguages {
	
	public static class LanguageComparator implements Comparator<Character>{

		TreeMap<Character, Integer> languages;
		
		public LanguageComparator(TreeMap<Character, Integer> l){
			languages =l;
		}

		public int compare(Character i, Character j) {
			if(languages.get(i) > languages.get(j))
				return 1;
			else if (languages.get(i) < languages.get(j))
				return -1;
			else if (i > j)
				return 1;
			return -1;
		}
		
	}

	static int [] movesRow = new int[]{1,0,-1,0};//new int[]{1, 1, 0,-1,-1,-1,  0,  1};
	static int [] movesCol = new int[]{0,1,0,-1};//new int[]{0, 1, 1, 1, 0,-1, -1, -1};
	static int Rows, Columns;
	static char [][] map;
	
	public static boolean canMove(int i, int j){
		return !(i<0 || j<0 || i >= Rows|| j >= Columns);
	}
	
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < testCases; t++) {
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			Rows = Integer.parseInt(tokenizer.nextToken()); //Height
			Columns = Integer.parseInt(tokenizer.nextToken()); //Width
			map = new char [Rows][Columns];
			for (int i = 0; i < Rows; i++) {
				map[i] = in.readLine().toCharArray();
			}
			sb.append("World #"+(t+1)+"\n");
			TreeMap<Character, Integer> r = floodFill('.');
			for (Character key : r.keySet()) {
				sb.append(key+": "+r.get(key)+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	
	static TreeMap<Character, Integer>  floodFill(char filler){
		TreeMap<Character, Integer> result = new TreeMap<Character, Integer>();
		for (int i = 0; i < Rows; i++) {
			for (int j = 0; j < Columns; j++) {
				char language = map[i][j];
				if(language != filler){
					if (!result.containsKey(language)) {
						result.put(language, 0);
					}
					int v = result.get(language)+1;
					result.put(language, v);
					floodFill(i,j,language, filler);
				}
			}
		}
		RankLanguages.LanguageComparator languageComparator = new RankLanguages.LanguageComparator(result);
		TreeMap<Character, Integer> sortedResult = new TreeMap<Character, Integer>(languageComparator);
		sortedResult.putAll(result);
		return sortedResult;
	}

	private static void floodFill(int i, int j, char language, char filler) {
		if(!canMove(i, j)) return;
		if(map[i][j] != language ) return; //if not my language or filled e.g visited
		map[i][j] = filler; // mark as filled
		for (int k = 0; k < movesRow.length; k++) 
			floodFill(i+movesRow[k], j + movesCol[k], language, filler);		
	}
	
	
	
}
