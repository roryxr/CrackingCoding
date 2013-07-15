class CheckPerm
{
	public static String sort(String s){
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
 
  // First check is easy and nice when not considering the efficiency, sorting the string and compare
	public static boolean check1(String s1, String s2){
		if(s1.length() != s2.length()){
			dispFalse(s1, s2);
			return false;
		}
		if(sort(s1).equals(sort(s2))){
			dispTrue(s1, s2);
			return true;
		}	else {
			dispFalse(s1, s2);
			return false;
		}
	}

	// Second check is counting the occurrence of the character

	public static boolean check2(String s1, String s2){
		if(s1.length() != s2.length()){
			dispFalse(s1, s2);
			return false;
		}
		int[] bin = new int[256];
		for(int i=0; i<s1.length(); i++){
			bin[s1.charAt(i)]++;
		}
		for(int i=0; i<s2.length(); i++){
			if(--bin[s2.charAt(i)] < 0 ){
				dispFalse(s1, s2);
				return false;
			}
		}
		dispTrue(s1, s2);
		return true;
	}

	public static void dispFalse(String s1, String s2){
			System.out.println(s1+" is not perm of "+s2);
	}
	public static void dispTrue(String s1, String s2){
			System.out.println(s1+" is perm of "+s2);
	}

	public static void main(String[] args){
		String s1 = "abcdef";
		String s2 = "dcaefb";
		String s3 = "asdf";
		String s4 = "fdda";
		String s5 = "god   ";
		String s6 = "dog";
		check1(s1, s2);
		check1(s3, s4);
		check1(s5, s6);
		check2(s1, s2);
		check2(s3, s4);
		check2(s5, s6);
	}
}
