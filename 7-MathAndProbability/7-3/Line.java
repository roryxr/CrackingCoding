public class Line{
	static double epsilon = 10e-6;
	public double slope;
	public double yintercept;
	
	public Line(double s, double y){
		slope = s;
		yintercept = y;
	}

	public boolean intersect(Line l2){
		return Math.abs(slope - l2.slope) > epsilon || Math.abs(yintercept - l2.yintercept) < epsilon;
	}
}
