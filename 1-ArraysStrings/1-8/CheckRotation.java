import java.io.*;
class CheckRotation
{
	public static void main(String[] args){
		System.out.print("Input the first string: ");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s1 = br.readLine();
			System.out.print("Input the second string: ");
			String s2 = br.readLine();
			if (isSubstring(s1, s2)) System.out.println(s2 +" is a substring of "+s1);
			else System.out.println(s2 + " is not a substring of " + s1);
			if (isRotation(s1, s2)) System.out.println(s2 +" is rotation of "+s1);
			else System.out.println(s2 + " is not rotation of " + s1);
		} catch (IOException e){
			e.toString();
		}
	}	

	public static boolean	isSubstring(String s1, String s2){
		int l1 = s1.length();
		int l2 = s2.length();
		if(l1<l2) return false;
		int x=0;
		int y=0;
		while(x < l1){
			if(s1.charAt(x) != s2.charAt(y)){
				if(y != 0) y = 0;
				else x++;
				if(l2 > l1-x) return false;
			} else {
				x++;
				y++;
				if(y == l2) return true;
			}
		}
		return false;
	}

	public static boolean isRotation(String s1, String s2){
		int l1 = s1.length();
		int l2 = s2.length();
		if(l1 != l2 || l1 == 0) return false;
		String ss = s1+s1;
		if(isSubstring(ss, s2)) return true;
		else return false;
	}
}
