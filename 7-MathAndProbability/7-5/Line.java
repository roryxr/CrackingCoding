class Line{
	private double slope;
	private boolean vertical;
	private double intercept; // yintercept if slope is not inf, otherwise x intercept
	public Line(boolean inf, double v, double intercept){
		vertical = inf;
		slope = v;
		this.intercept = intercept;
	}	
	public void displayLine(){
		System.out.println("The function of the line is: ");
		if(vertical)System.out.println("x = "+intercept);
		else System.out.println("y = " + slope + "x + " + intercept);
	}
	public boolean isVertical(){
		return vertical;
	}
}
