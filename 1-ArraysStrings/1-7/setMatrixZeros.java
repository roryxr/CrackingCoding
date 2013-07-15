import java.io.*;
class setMatrixZeros
{
	public static void main(String[] args){		
		Matrix m = new Matrix(5, 3);
		m.display();
		setZeros(m);
		m.display();
	}

	public static void setZeros(Matrix matrix){
		int[][] mat = matrix.getMatrix();
		int m = mat.length;
		int n = mat[0].length;
		int row=0, col=0;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(mat[i][j] == 0){
					row |= 1 << i;
					col |= 1 << j;
				}
			}
		}

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if((row & 1<<i) >0 || (col & 1<<j) >0){
					mat[i][j] = 0;
				}
			}		
		}
	}
}

class Matrix
{
	private int[][] mat;
	private int m;
	private int n;
	public Matrix(int a, int b){
		m=a;
		n=b;
		mat = new int[m][n];
		try{
			BufferedReader br = new BufferedReader(new FileReader("input"));
			String s = br.readLine();
			String[] ss = s.split(" ");
			for(int i=0; i<a; i++)
				for(int j=0; j<b; j++)
					mat[i][j] = Integer.parseInt(ss[i*b+j]);
		} catch(IOException e){
			e.toString();
		}
	}

	public void display(){
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public int[][] getMatrix(){
		return mat;
	}
}
