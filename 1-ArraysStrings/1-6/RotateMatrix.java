import java.io.*;
class RotateMatrix
{
	public static void main(String[] args){
		Matrix m = new Matrix(5);
		m.display();
		rotate(m.getMatrix(), m.getSize());
		m.display();
	}

	// Time complexity is in O(n^2) which is already the best case since its an N*N matrix. Space can be saved using this method with variable named 'top'
	public static void rotate(int m[][], int size){
		for(int layer=0; layer<size/2; ++layer){
				int first = layer;
				int last = size-layer-1;
			for(int i=first; i<last; ++i){
				int top = m[layer][i];
				int offset = i-first;
				m[first][i] = m[last-offset][first]; // left to top
				m[last-offset][first] = m[last][last-offset]; // bot to left
				m[last][last-offset] = m[i][last]; // right to bot
				m[i][last] = top; // top to right
			}
		}
	}
}

class Matrix
{
	private int[][] mat;
	private int size;
	public Matrix(int size){
		mat = new int[size][size];
		this.size = size;
		getData(this.size);
	}

	public void getData(int size){
		try{
			BufferedReader br = new BufferedReader(new FileReader("input"));
			String s = br.readLine();
			String[] ss = s.split(" ");
			for(int i=0; i < size*size; i++){
				mat[i/size][i%size] = Integer.parseInt(ss[i]);
			}
		} catch(IOException e) {
			e.toString();
		}
	}

	public void display(){
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++)
				System.out.print(mat[i][j]+" ");
			System.out.println();
		}
			System.out.println();
	}
	public int[][] getMatrix(){
		return mat;
	}
	public int getSize(){
		return size;
	}
}
