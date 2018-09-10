import java.util.ArrayList;

public class ShapeList extends ArrayList<Shape> {
	
//	ShapeList newList = new ShapeList();
//	public ShapeList() {
//		this.ShapeList = ShapeList;
//	}
	
	public ShapeList largestShapes() {
		ShapeList newList = new ShapeList();
		double largest = this.get(0).computeArea();
		for(Shape x: this) {
			if(largest < x.computeArea()) {
				largest = (int) x.computeArea();
			}
		}
		for(int i = 0; i < this.size(); i++) {
			double area = this.get(i).computeArea();
			if(largest == area) {
				newList.add(this.get(i));
			}
		}
		
		return newList;
		
	}
	
	public boolean hasDistinctAreas() {
		boolean isDistinct = true;
		for(int i = 0; i < this.size() - 1; i++) {
			Shape A = this.get(i);
			for(int j = i + 1; j < this.size(); j++) {
				Shape B = this.get(j);
				if( A.compareTo(B) != 0 ) {
					isDistinct = false;
				}
			}
		}
		return isDistinct;
	}
	
	@Override
	public String toString() {
		String dimensions = "";
		for(int i = 0; i < this.size(); i++) {
			dimensions = dimensions + this.get(i).toString();
		}
		dimensions = dimensions + "\n";
		return dimensions;
	}

}