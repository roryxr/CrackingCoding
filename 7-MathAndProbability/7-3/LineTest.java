class LineTest
{
	public static void main(String[] args){
		Line l1 = new Line(8.33, 4.21);
		Line l2 = new Line(8.33, 23.1);
		Line l3 = new Line(8.23, 20.21);
		Line l4 = new Line(8.33, 4.21);
		if(l1.intersect(l2))System.out.println("l1 intersects l2");
		else System.out.println("l1 does not intersect l2");
		if(l2.intersect(l3))System.out.println("l2 intersects l3");
		else System.out.println("l2 does not intersect l3");
		if(l1.intersect(l3))System.out.println("l1 intersects l3");
		else System.out.println("l1 does not intersect l3");
		if(l1.intersect(l4))System.out.println("l1 intersects l4");
		else System.out.println("l1 does not intersect l4");
	}
}
