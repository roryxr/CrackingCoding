class ReplaceString
{
	public static String replace(String s){
		String[] ss = s.split(" ");
		String str = "";
		for(int i=0; i<ss.length-1; i++){
			str += ss[i] + "%20";
		}
		str += ss[ss.length-1];
		return str;
	}

	public static String replace2(String s, int length){
		char[] charA = s.toCharArray();
		int count = 0, newlen, len = length;
		for(char c : charA)
			if(c == ' ') count++;
		newlen = len + count*2;
		char[] newCharA = new char[newlen+1];
		newCharA[newlen] = '\0';
		for(int i=len-1; i>=0; i--){
			if(charA[i] == ' '){
				newCharA[newlen-1] = '0';
				newCharA[newlen-2] = '2';
				newCharA[newlen-3] = '%';
				newlen -= 3;
			} else {
				newCharA[newlen-1] = charA[i];
				newlen--;
			}
		}
		return new String(newCharA);
	}
	
	public static void main(String [] args){
		String s = "Mr John Smith    ";
		String s2 = replace(s);
		System.out.println(s+"-->\n"+s2);
		String s3 = replace2(s, 17);
		System.out.println(s+"-->\n"+s3);
	}
}
