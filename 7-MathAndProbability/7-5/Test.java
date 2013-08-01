class Test{
	public static void main(String[] args){
		Square s1 = new Square(3.5, 4.2, 2);
		Square s2 = new Square(5.2, 2.1, 3);
		Line l = s1.getMiddleLine(s2);
		System.out.println(l.isVertical());
		l.displayLine();
	}
}
