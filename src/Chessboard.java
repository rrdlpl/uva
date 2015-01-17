
/*SRM 344  

 * */
public class Chessboard {
	
	public static String changeNotation(String cell){
		if(cell.length()>1 && cell.charAt(0) >= 'a' && cell.charAt(0) <= 'h')
			return getCellNumber(cell);
		return getCellMark(cell);
		
	}

	private static String getCellMark(String cellNumber) {
		// TODO Auto-generated method stub
		int row =(int) Math.ceil(Double.valueOf(cellNumber)/8);
		int col = Integer.valueOf(cellNumber)-(row-1)*8-1;
		col = col + 'a';
		char fila = (char)col;
		String r = String.valueOf(fila+String.valueOf(row));
		return r;
	}

	private static String getCellNumber(String cellMark) {
		// TODO Auto-generated method stub
		int j = cellMark.charAt(0) - 'a' ;
		int i = cellMark.charAt(1) - '0';
		return String.valueOf(i*8+j-7);
	}
	/*
	public static void main(String []args){
		//System.out.println(changeNotation("f5"));
		System.out.println(getCellMark("38"));
	}
*/
}
