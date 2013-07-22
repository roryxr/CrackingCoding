class AnimalApp
{
	public static void main(String[] args){
		AnimalQueue aq = new AnimalQueue();
		String[] catNames = {"cat1", "cat2", "cat3"};
		String[] dogNames = {"dog1", "dog2", "dog3", "dog4"};
		for(String s : catNames){
			Cat c = new Cat(s);
			aq.enqueue(c);
		}
		for(String s : dogNames){
			Dog d = new Dog(s);
			aq.enqueue(d);
		}
		aq.dequeueDog();
		aq.dequeueAny();
		aq.dequeueAny();
		aq.dequeueDog();
		aq.dequeueCat();
		aq.dequeueAny();
	}
}
