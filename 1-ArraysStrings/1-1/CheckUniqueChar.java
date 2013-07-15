class CheckUniqueChar
{
  // Takes n steps to scan the string and at most 256 steps to check unique, O(n) time required
	// However using an extra character array
	public static boolean check1(String s){
		if(s.length() > 256) return false;
		boolean[]  char_set= new boolean[256];
		for(int i = 0; i<s.length(); i++ ){
				if(char_set[s.charAt(i)]){
					System.out.println(s+": Not Unique");
					return false;
				}
				char_set[s.charAt(i)] = true;
		}
		System.out.println(s+": Unique");
		return true;
	}

  // Takes 1+2+3+...+n-1 = n*(n-1)/2 steps to compare, O(n^2) time required, without using extra character array
	public static boolean check2(String s){
		for(int i=1; i<s.length(); i++){
			for(int j=0; j<i; j++){
				if(s.charAt(i) == s.charAt(j)){
					System.out.println(s+": Not Unique");
					return false;
				}
			}
		}
		System.out.println(s+": Unique");
		return true;
	}

	// Time complexity is same as check1(), which is O(n), n = length of the string, Space complexity is reduced by a factor of 8 assuming characters are from a to z
	public static boolean check3(String s){
		if(s.length() > 26){
			System.out.println(s + ": Not Unique");
			return false;
		}
		int checker = 0;
		for(int i=0; i<s.length(); i++){
			int val = s.charAt(i) - 'a';
			if((checker & (1 << val)) >0){
				System.out.println(s+": Not Unique");
				return false;
			}
			checker |= 1 << val;
		}
		System.out.println(s+": Unique");
		return true;
	}
	
	public static void main(String[] args){
		check1("at");
		check1("att");
		check1("abcdefhlk");
		check1("kjhsgadcs");
		check2("at");
		check2("att");
		check2("abcdefhlk");
		check2("kjhsgadcs");
		check3("at");
		check3("att");
		check3("abcdefhlk");
		check3("kjhsgadcs");
	}
}
