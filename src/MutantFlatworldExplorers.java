import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MutantFlatworldExplorers {

	static int []y = new int[]{1,0,-1,0};
	static int []x = new int[]{0,1,0,-1};
	static int actualX, actualY;
	static int direction;
	static int X,Y;
	static char[] directions= new char[]{'N','E','S','W'};
	static boolean grid[][] = new boolean[51][51];
	
	public static void main(String []args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		String line = in.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line);
		X = Integer.parseInt(tokenizer.nextToken());
		Y = Integer.parseInt(tokenizer.nextToken());
		while((line = in.readLine()) != null){			
			tokenizer = new StringTokenizer(line);
			actualX = Integer.parseInt(tokenizer.nextToken());
			actualY = Integer.parseInt(tokenizer.nextToken());
			char dir =tokenizer.nextToken().toCharArray()[0];// Character.valueOf();
			setDirection(dir);
			char [] actions = in.readLine().toCharArray();
			boolean lost = false;
			for (int i = 0; i < actions.length && !lost; i++) {				
				switch (actions[i]) {
					case 'L':
						rotateLeft();					
						break;
					case 'R':
						rotateRight();
						break;
					default:					
						if(!(lost = isLost())){
								moveForward();
						}else{
							if(!grid[actualX][actualY])
								grid[actualX][actualY] = true;
							else
								lost = false;
						}
						break;
					}
			}
			
			sb.append(actualX).append(" ")
							  .append(actualY).append(" ").append(directions[direction]).append(lost ? " LOST" : "")
							  .append("\n");			
		
		}
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
		
	}
	
	public static void setDirection(char dir){
		switch (dir) {
		case 'N': direction = 0;			
			break;
		case 'E': direction = 1;
			break;
		case 'S': direction = 2;
			break;
		case 'W': direction = 3;
			break;
		default:
			break;
		}
	}
	
	static void rotateLeft(){				
		if(--direction<0) direction =3;		
	}
	
	static void rotateRight(){		
		if(++direction>3) direction =0;		
	}
	
	static void moveForward(){	
		actualX += x[direction];
		actualY += y[direction];
	}
	
	static boolean isLost(){
		
		return (actualX == 0 && direction ==3) ||
			   (actualY == 0 && direction ==2) ||
			   (actualX == X && direction ==1) ||
			   (actualY == Y && direction ==0);
	}
	
}
