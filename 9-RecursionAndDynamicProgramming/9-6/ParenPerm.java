import java.util.ArrayList;
public class ParenPerm {
	public static void main(String[] args) {
		getParenPerm(4);
	}

	public static void getParenPerm(int count) {
		ArrayList<String> perms = new ArrayList<String>();
		char[] str = new char[count*2];
		calcParenPerm(perms, count, count, str, 0);
		printPerms(perms);
	}

	public static void printPerms(ArrayList<String> words) {
		for(String word : words)
			System.out.println(word);
	}

	public static void calcParenPerm(ArrayList<String> perms, int leftrem, int rightrem, char[] str, int pos) {
		if(leftrem < 0 || leftrem > rightrem) return;
		if(leftrem == 0 && rightrem == 0){
			perms.add(new String(str));
			return;
		}
		if(leftrem > 0){
			str[pos]  = '(';
			calcParenPerm(perms, leftrem-1, rightrem, str, pos + 1);
		}
		if(rightrem > leftrem) {
			str[pos] = ')';
			calcParenPerm(perms, leftrem, rightrem - 1, str, pos + 1);
		}
	}
}
