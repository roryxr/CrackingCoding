import java.util.ArrayList;
public class EightQueen {
	public static int GRID_SIZE = 8;
	public static void main(String[] args) {
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] columns = new Integer[GRID_SIZE];
		setMap(0, columns, results);
		System.out.println("total number of possibilities: " + results.size());
	}

	public static void setMap(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if(row == GRID_SIZE){
			results.add(columns.clone());
		}
		for(int i = 0; i < GRID_SIZE; i++) {
			if(isValid(row, i, columns)) {
				columns[row] = i;
				setMap(row + 1, columns, results);
			}
		}
	}

	public static boolean isValid(int row, int i, Integer[] columns) {
		for(int row2 = 0; row2 < row; row2++) {
			if(i == columns[row2]) return false;
			if(row - row2 == Math.abs(columns[row2] - i)) return false;
		}
		return true;
	}
}
