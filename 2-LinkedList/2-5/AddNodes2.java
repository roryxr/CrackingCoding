import java.lang.Math;
class AddNodes2
{
	public static void main(String [] args){
		int[] a = {6,1,7};
		int[] b = {2,3,9,5};
		SList l1 = new SList();
		SList l2 = new SList();
		for(int i : a) l1.add(i);
		for(int j : b) l2.add(j);
		l1.display();
		l2.display();
		SNode n = addNodes2(l1.head, l2.head);
		SList l = new SList();
		l.head = n;
		l.display();
	}

	public static SNode addNodes2(SNode n1, SNode n2){
		int len1 = length(n1);
		int len2 = length(n2);
		int numDigits;

		if(len1 > len2){
			n2 = padList(n2, len1-len2);
			numDigits = len1;
		} else if(len2 > len1){
			n1 = padList(n1, len2-len1);
			numDigits = len2;
		} else {
			numDigits = len1;
		}
		SList l = new SList();
		int val1=0;
		int val2=0;
		for(int i=0; i<numDigits; i++){
			val1 += n1.key*Math.pow(10, numDigits-i-1);
			val2 += n2.key*Math.pow(10, numDigits-i-1);
			n1 = n1.next;
			n2 = n2.next;
		}
		int result = val1+val2;
		if(result/ (int) Math.pow(10, numDigits) > 0){
			l.add(1);
			result -= (int)Math.pow(10, numDigits);
		}
		for(int i=numDigits-1; i>=0; i--){
			int digit = result/ (int)Math.pow(10, i);
			l.add(digit);
			result -= digit*Math.pow(10,i);
		}
		return l.head;
	}

	public static int length(SNode n){
		int len=0;
		while(n != null){
			len++;
			n = n.next;
		}
		return len;
	}

	public static SNode padList(SNode n, int len){
		for(int i=0; i<len; i++){
			SNode s = new SNode(0);
			s.next = n;
			n = s;
		}
		return n;
	}
}
