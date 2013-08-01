public class Square{
	public static double epsilon = 10e-4;
	private double centerX;
	private double centerY;
	private double size;

	public Square(double x, double y, double size){
		centerX = x;
		centerY = y;
		this.size = size;
	}
	public double getX(){
		return centerX;
	}
	public double getY(){
		return centerY;
	}
	public double getSize(){
		return size;
	}
	
	public Line getMiddleLine(Square s2){
		double x1 = centerX, x2 = s2.getX(), y1 = centerY, y2 = s2.getY(), size1 = size, size2 = s2.getSize();
		if(Math.abs(x1-x2) < epsilon) return new Line(true, 0, x1);
		else{
			double slope = (y2 - y1) / (x2 - x1);
			double yintercept = y1 - slope*x1;
			return new Line(false, slope, yintercept);
		}
	}
}
