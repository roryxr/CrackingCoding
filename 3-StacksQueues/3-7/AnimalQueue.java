import java.util.LinkedList;
class AnimalQueue
{
	private int order;
	LinkedList<Dog> dogs;
	LinkedList<Cat> cats;
	public AnimalQueue(){
		order = 0;
		dogs = new LinkedList<Dog>();
		cats = new LinkedList<Cat>();
	}
	public void enqueue(Animal a){
		System.out.println("Animal: "+a.name+" gets in the queue");
		a.setOrder(order++);
		if(a instanceof Dog){
			dogs.addLast((Dog)a);
		} else if(a instanceof Cat){
			cats.addLast((Cat)a);
		}
	}

	public Animal dequeueDog(){
		if(!dogs.isEmpty()){
			System.out.println("Animal: "+dogs.peekFirst().name+" leaves in the queue");
			return dogs.pollFirst();
		} else return null;
	}

	public Animal dequeueCat(){
		if(!cats.isEmpty()){
			System.out.println("Animal: "+cats.peekFirst().name+" leaves in the queue");
			return cats.pollFirst();
		} else return null;
	}

	public Animal dequeueAny(){
		if(dogs.isEmpty() && cats.isEmpty()){
			return null;
		}	else if(dogs.isEmpty()){
			return dequeueCat();
		} else if(cats.isEmpty()){
			return dequeueDog();
		} else {
			return (dogs.peekFirst().isOlderThan(cats.peekFirst())?dequeueDog():dequeueCat());
		}
	}
}
