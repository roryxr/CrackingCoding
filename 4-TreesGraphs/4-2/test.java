class test
{
	public static void main(String[] args){
		Item[] it = new Item[10];
		for(int i=0; i<5; i++){
			it[i] = new Item();
		}
		for(Item k : it){
			if(k != null)
				System.out.print(k.key+" ");
		}
	}
}

class Item {
	public int key = 0;
}
