class StringPerm
{
	public static void main(String[] args){
		String s = "abc";
		char[] ch = s.toCharArray();
		printPerm(ch, 0, ch.length);
	}

	public static void printPerm(char[] ch, int index, int size){
		if(index == size-1){
			display(ch);
			return;
		}
		for(int i= index; i<size; i++){
			swap(ch, index, i);
			printPerm(ch, index+1, size);
			swap(ch, index, i);
		}
	}
	public static void display(char[] ch){
		for(char c : ch){
			System.out.print(c);
		}
		System.out.println();
	}

	public static void swap(char[] ch, int x, int y){
		char temp = ch[x];
		ch[x] = ch[y];
		ch[y] = temp;
	}
}
