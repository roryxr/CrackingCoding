class CountBits
{
	public static void main(String[] args){
		int A = 17685;
		int B = 5698;
		System.out.println("A = " + getBitString(A));
		System.out.println("B = " + getBitString(B));
		System.out.println("Count difference: " + countBits(A, B));
	}

	public static String getBitString(int a){
		StringBuilder sb = new StringBuilder();
		while(a > 0){
			if((a & 1) == 1) sb.insert(0, "1");
			else sb.insert(0, "0");
			a >>= 1;
		}
		return sb.toString();
	}

	public static int countBits(int a, int b){
		int cnt = 0;
		for(int i = a^b; i != 0; i = i&(i-1))cnt++;
		return cnt;
	}
}
