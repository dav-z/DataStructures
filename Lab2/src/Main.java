
public class Main {

	public static void main(String[] args) {
		DoublyLinkedList<String> animals = new DoublyLinkedList<String>();
		
		// Expected outputs
		String output1 = "start <-> [dog] <-> [cat] <-> [goldfish] <-> [turtle] <-> end";
		String output2 = "start <-> [dog] <-> [cat] <-> [turtle] <-> end";
		String output3 = "start <-> [dog] <-> [hamster] <-> [turtle] <-> end";
		String output4 = "turtle";
		String output5 = "start <-> [frog] <-> [dog] <-> [rabbit] <-> [hamster] <-> [turtle] <-> end";
		String output6 = "start <-> end";
		
		// 1. Testing add method
		animals.add("dog");
		animals.add("cat");
		animals.add("goldfish");
		animals.add("turtle");
		System.out.print("Test 1 Passed == ");
		System.out.println(animals.toString().equals(output1));
		
		// 2. Testing remove method
		animals.remove(2);
		System.out.print("Test 2 Passed == ");
		System.out.println(animals.toString().equals(output2));
		
		// 3. Testing set method
		animals.set(1, "hamster");
		System.out.print("Test 3 Passed == ");
		System.out.println(animals.toString().equals(output3));
		
		// 4. Testing get method
		System.out.print("Test 4 Passed == ");
		System.out.println(animals.get(2).equals(output4));
		
		// 5. More testing for add methods
		animals.add(1, "rabbit");
		animals.addToFront("frog");
		System.out.print("Test 5 Passed == ");
		System.out.println(animals.toString().equals(output5));
		
		// 6. More testing for remove methods
		animals.removeFromFront();
		animals.removeFromFront();
		animals.removeFromBack();
		animals.removeFromBack();
		animals.removeFromBack();
		System.out.print("Test 6 Passed == ");
		System.out.println(animals.toString().equals(output6));
		
		// 7. Check if firstNode and lastNode are valid
		animals.add("dog");
		animals.add("cat");
		animals.add("goldfish");
		animals.add("turtle");
		System.out.print("Test 7 Passed == ");
		System.out.println(animals.frontIsValid() && animals.backIsValid());
		
	}
	
}
