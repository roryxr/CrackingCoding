import java.util.HashMap;
import java.util.Iterator;
class FindBestLine{
	public static void main(String[] args){
		double[] x = {4.5, 7.2, 7.5, 4.5, 1.5};
		double[] y = {5.0, 2.5, 12.5, 7.5, 2.5};
		//double[] x = {4.5, 7.5, 4.5, 1.5};
		//double[] y = {5.0, 12.5, 7.5, 2.5};
		Point[] points = new Point[x.length];
		for(int i=0; i<x.length; i++){
			Point p = new Point(x[i], y[i]);
			points[i] = p;
		}
		Line bestline = findBestLine(points);
		bestline.displayLine();
	}

	public static Line findBestLine(Point[] points){
		Line bestline = null;
		HashMap<Line, Integer> lines = new HashMap<Line, Integer>();
		for(int i=0; i<points.length; i++){
			for( int j=i+1; j<points.length; j++){
				Line line = new Line(points[i], points[j]);
				if(!lines.containsKey(line)){
					lines.put(line, 1);
				} else {
					lines.put(line, lines.get(line)+1);
				}
				if(bestline == null || lines.get(line) > lines.get(bestline)) bestline = line;
			}
		}
	/*
		Iterator itr = lines.keySet().iterator();
		while(itr.hasNext()){
			Line curr = (Line) itr.next();
			curr.displayLine();
			System.out.println(lines.get(curr));
		}
	*/
		return bestline;
	}
}
