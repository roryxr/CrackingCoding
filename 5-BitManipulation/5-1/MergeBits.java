class MergeBits
{
	public static void main(String[] args){
		int m = 19, n = 1024, i = 2, j = 6;
		printBits(m);
		printBits(n);
		System.out.print("Result = ");
		printBits(mergeBits(m,n,i,j));
	}

	public static int mergeBits(int m, int n, int i, int j){
		int mask = 1 << (j-i+1) - 1;
		mask = mask << i;
		n = n & ~mask;
		n = n | (m << i);
		return n;
	}

	public static void printBits(int val){
		int len = getBitLength(val);
		int mask = 1 << len-1;
		for(int i = 0; i<len; i++){
			if((val & mask) == 0)
				System.out.print("0");
			else
				System.out.print("1");
			val = val << 1;
		}
		System.out.println();
	}

	public static int getBitLength(int val){
		int cnt = 0;
		while(val > 0){
			val = val >> 1;
			cnt++;
		}
		return cnt;
	}
}
