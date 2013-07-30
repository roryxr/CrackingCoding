import java.util.ArrayList;
class FindMissing
{
	public static void main(String[] args){
		ArrayList<BitInteger> array = new ArrayList<BitInteger>();
		for(int i=0; i<54; i++){
			BitInteger b = new BitInteger(i);
			array.add(b);
		}
		for(int i=55; i<72; i++){
			BitInteger b = new BitInteger(i);
			array.add(b);
		}
		System.out.println("Missing value is " + findMissing(array));
	}

	public static int findMissing(ArrayList<BitInteger> input){
		return findMissing(input, BitInteger.INTEGER_SIZE-1);
	}

	public static int findMissing(ArrayList<BitInteger> input, int column){
		if(column < 0) return 0;
		ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input.size() / 2);
		ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(input.size() / 2);
		for(BitInteger t : input){
			if(t.fetch(column) == 0) zeroBits.add(t);
			else oneBits.add(t);
		}

		if(zeroBits.size() <= oneBits.size()){
			int v = findMissing(zeroBits, column-1);
			return (v << 1) | 0;
		} else {
			int v = findMissing(oneBits, column-1);
			return (v << 1) | 1;
		}
	}
}


