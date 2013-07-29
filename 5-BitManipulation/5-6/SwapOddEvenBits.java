class SwapOddEvenBits
{
	public static void main(String[] args){
		int n = 14581;
		System.out.println("Before swap: " + getBitString(n));
		System.out.println("After swap:  " + getBitString(swapOddEvenBits(n)));
	}

	public static int swapOddEvenBits(int n){
		return ((n & 0x55555555) << 1) | ((n & 0xaaaaaaaa) >> 1);
	}

	public static String getBitString(int n){
		StringBuilder sb = new StringBuilder();
		while(n > 0){
			if((n & 1) == 1) sb.insert(0, "1");
			else sb.insert(0, "0");
			n >>= 1;
		}
		return sb.toString();
	}
}
