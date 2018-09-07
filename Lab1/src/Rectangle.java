
public class Rectangle extends Shape {
	
	private double width, height; 

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double computeArea() {
		double area = width * height;
		return area;
	}
	
	public boolean equals(Rectangle otherRectangle) {
		if( width == otherRectangle.width && height == otherRectangle.height ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String dimensions = String.format("(%d, %d)", width, height);
		return dimensions;
	}

}