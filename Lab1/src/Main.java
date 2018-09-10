
public class Main {

	public static void main(String[] args) {
		
		ShapeList newList = new ShapeList();
		Rectangle rec1 = new Rectangle (1, 40);
		newList.add(rec1);
		newList.add(rec1);
		newList.add(rec1);
		newList.add(rec1);
		newList.add(rec1);
		newList.add(new Rectangle(4,10));
		newList.add(new Rectangle(8,5));
		newList.add(new Rectangle(5,8));
		
		System.out.print(newList.largestShapes());
		System.out.print(newList.hasDistinctAreas());

	}


}
