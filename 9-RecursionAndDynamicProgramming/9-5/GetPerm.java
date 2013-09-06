import java.util.ArrayList;
public class GetPerm {
	public static void main(String[] args) {
		String s = "abcd";
		ArrayList<String> permutations = getPerms(s);
		printStrings(permutations);
	}

	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		if(s.length() == 0){
			String word = "";
			permutations.add(word);
			return permutations;
		}
		char first = s.charAt(0);
		String remainder = s.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for(String word : words){
			for(int i = 0; i <= word.length(); i++) {
				String str = insertCharAt(word, first, i);
				permutations.add(str);
			}
		}
		return permutations;
	}

	public static String insertCharAt(String word, char first, int pos) {
		String s1 = word.substring(0, pos);
		String s2 = word.substring(pos);
		return s1 + first + s2;
	}

	public static void printStrings(ArrayList<String> perms){
		for(String word : perms){
			System.out.println(word);
		}
	}
}
