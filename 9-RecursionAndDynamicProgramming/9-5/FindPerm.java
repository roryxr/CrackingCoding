public class FindPerm {
	public static void main(String[] args){
		String s = "abcd";
		char[] a = s.toCharArray();
		findPerm(a, 0);
	}

	public static void findPerm(char[] ch, int k) {
		if(k == ch.length-1){
			System.out.println(new String(ch));
			return;
		};
		for(int i = k; i < ch.length; i++){
			swap(ch, i, k);
			findPerm(ch, k+1);
			swap(ch, i, k);
		} 
	}
	public static void swap(char[] ch, int x, int y) {
		char temp = ch[x];
		ch[x] = ch[y];
		ch[y] = temp;
	}
}
