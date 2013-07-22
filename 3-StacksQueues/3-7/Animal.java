public abstract class Animal
{
	private int order;
	protected String name;
	public Animal(String name){
		this.name = name;
		order = 0;
	}

	public void setOrder(int o){
		order = o;
	}

	public int getOrder(){
		return order;
	}

	public boolean isOlderThan(Animal a){
		return this.order < a.order;
	}
}
