class BitManipulation
{
	public static final int ORGIN = 13948;
	public static void main(String[] args){
		System.out.println("Original binary number: " + getBitString(ORGIN));
		System.out.println("Next binary number: " + getBitString(getNext(ORGIN)));
		System.out.println("Prev binary number: " + getBitString(getPrev(ORGIN)));
		
	}
	
	public static String getBitString(int a){
		StringBuilder sb = new StringBuilder();
		if(a < 0) return "ERROR";
		while(a > 0){
			if((a & 1) == 1)
				sb.insert(0, "1");
			else
				sb.insert(0, "0");
			a >>= 1;
		}
		return sb.toString();
	}
	
	// Arithmetic approach
	public static int getNext(int a){
		int c = a, c0 = 0, c1 = 0;
		while((c & 1) == 0 && c != 0){
			c >>= 1;
			c0++;
		}
		while((c & 1) == 1){
			c >>= 1;
			c1++;
		}
		if(c1 + c0 == 31 || c0 + c1 == 0) return -1;
		int p = c0 + c1;
		return a + (1 << c0) + (1 << (c1-1)) - 1;
	}

	public static int getPrev(int a){
		int c = a, c0 = 0, c1 = 0;
		while((c & 1) == 1){
			c >>= 1;
			c1++;
		}
		while((c & 1) == 0 && c != 0){
			c >>= 1;
			c0++;
		}

		if(c0 + c1 == 31 || c0 + c1 == 0){
			return -1;
		}

		int p = c0 + c1;
		return a - (1 << c1) +1 - (1 << (c0 - 1));
	}
}
