package rory.findsubstring;

public class FindSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("This is a nice day!");
		String substr = new String("y!");
		if(isSubstring(str, substr))
			System.out.println("The substring exists.");
		else
			System.out.println("The substring does not exist.");
	}
	
	public static boolean isSubstring(String str, String substr){
		int i=0;
		int j=0;
		while(i<str.length()){
			if(str.charAt(i) == substr.charAt(j)){
				j++;
				if(j == substr.length()) return true;
			} else {
				j = 0;
				if(str.charAt(i) == substr.charAt(j))j++;
			}
			i++;
		}
		return false;
	}
}
