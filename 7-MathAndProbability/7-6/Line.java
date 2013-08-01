class Line{
	private static double epsilon = 1e-4;
	private double slope;
	private boolean vertical;
	private double intercept; // yintercept if slope is not inf, otherwise x intercept
	public Line(boolean inf, double v, double intercept){
		vertical = inf;
		slope = v;
		this.intercept = intercept;
	}	

	public Line(Point p1, Point p2){
		double x1 = p1.getX(), x2 = p2.getX(), y1 = p1.getY(), y2 = p2.getY();
		if(Math.abs(x1 - x2) < epsilon){
			slope = 0;
			vertical = true;
			intercept = x1;
		} else {
			slope = (y2 - y1) / (x2 - x1);
			intercept = y1 - x1*slope;
			vertical = false;
		}
	}

	public void displayLine(){
		System.out.println("The function of the line is: ");
		if(vertical)System.out.println("x = "+intercept);
		else System.out.println("y = " + slope + "x + " + intercept);
	}
	public boolean isVertical(){
		return vertical;
	}
	public boolean isEqual(double x, double y){
		return (Math.abs(x-y) < epsilon);
	}

	@Override
	public int hashCode(){
		int sl = (int)(slope*1000);
		int in = (int)(intercept*1000);
		return sl | in;
	}

	@Override
	public boolean equals(Object o){
		Line l = (Line) o;
		if(isEqual(l.getSlope(), slope) && isEqual(l.getIntercept(), intercept) && vertical == l.isVertical()){
			return true;
		}
		return false;
	}
	public double getSlope(){
		return slope;
	}

	public double getIntercept(){
		return intercept;
	}
}
