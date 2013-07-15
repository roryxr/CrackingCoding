class StringCompression
{
	public static String count1(String s){
		char last = s.charAt(0);
		int count = 1;
		StringBuffer sb = new StringBuffer();
		sb.append(last);
		for(int i=1; i<s.length(); i++){
			if(s.charAt(i) == last){
				count++;
			} else {
				last = s.charAt(i);
				sb.append(String.valueOf(count));
				count = 1;
				sb.append(last);
			}
		}
		sb.append(count);
		String s1 = sb.toString();
		if(s1.length() >= s.length()) return s;
		else return s1;
	}

	public static void main(String[] args){
		String s1 = "aabcccccaaa";
		String s2 = "aaaaaaaaaaaaacdeaaffffaassddd";
		System.out.println(count1(s1));
		System.out.println(count1(s2));
	}
}
