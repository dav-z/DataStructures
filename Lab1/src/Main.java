
public class Main {

	public static void main(String[] args) {
		
		ShapeList newList = new ShapeList();
		
		newList.add(new Rectangle(1,40));
		newList.add(new Rectangle(40,1));
		newList.add(new Rectangle(20,2));
		newList.add(new Rectangle(2,20));
		newList.add(new Rectangle(10,4));
		newList.add(new Rectangle(4,10));
		newList.add(new Rectangle(8,5));
		newList.add(new Rectangle(5,8));
		
		System.out.print(newList.largestShapes());
		System.out.print(newList.hasDistinctAreas());

	}


}
