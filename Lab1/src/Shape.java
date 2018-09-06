
public abstract class Shape implements Comparable<Shape> {
	
	public int compareTo(Shape otherShape) {
		double diff = computeArea() - otherShape.computeArea();
		if( diff > 0 ) {
			return 1;
		}
		else if ( diff < 0 ) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public abstract double computeArea();
	public abstract String toString();

}