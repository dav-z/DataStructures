import java.util.ArrayList;

public class ShapeList extends ArrayList<Shape> {
	
	public ShapeList largestShapes() {
		return null;
	}
	
	public boolean hasDistintAreas(Shape A, Shape B) {
		if( A.compareTo(B) == 0 ) {
			return false;
		}
		else {
			return true;
		}
	}
	


}