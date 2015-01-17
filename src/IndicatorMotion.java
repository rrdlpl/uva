


public class IndicatorMotion {
	
	static char[] moves = new char[]{'\\','|','/','-'};
	static int i;
	public static String getMotion(String program, char startState){
		i = getStartPoint(startState);
		String output = String.valueOf(startState);
		for (int j = 0; j < program.length(); j=j+3){
			char action = program.charAt(j);
			String zeit =program.substring(j+1, j+3);
			int time = Integer.parseInt(zeit);
			for (int k = 0; k <time; k++) {
				output += nextMove(action);
			}
		}
		return output;
	}

	private static String nextMove(char action) {
		// TODO Auto-generated method stub
		switch (action) {
		case 'L':
			moveLeft();
			break;
		case 'R':
			moveRight();
			break;
		case 'F':
			moveRight();
			moveRight();
			break;
		}
		return String.valueOf(moves[i]);
	}

	private static void moveRight() {
		// TODO Auto-generated method stub
		i++;
		if(i>=moves.length) i=0;
	}

	private static void moveLeft() {
		i--;
		if(i<0) i = moves.length-1;
		//return  
	}

	private static int getStartPoint(char startState) {
		for (int i = 0; i < moves.length; i++) {
			if(startState == moves[i]) 
				return i;
		}
		return -1;
	}
	
	public static void main(String []args){
		System.out.println(getMotion("F03L02R03S02F04",'-'));
	}

}
