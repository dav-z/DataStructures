import java.io.IOException;

public class Main {

	public static <E> void main(String[] args) throws IOException {
		
		// Get Current Directory
		String currentDirectory = System.getProperty("user.dir") + "/";
		System.out.println("Current Directory: " + currentDirectory);
		
		// Problem 1 (10 pts): Programmatically create your own RootedTree object
		// consisting of at least five nodes.  Then, use the save method to save
		// the tree to a text file named "mytree.txt" within currentDirectory.
		

		TreeNode<String> dogs = new TreeNode<String>("dogs");
		RootedTree dogTypes = new RootedTree(dogs);
		TreeNode<String> pom = new TreeNode<String>("pom", dogs);
		TreeNode<String> golden = new TreeNode<String>("golden", dogs);
		TreeNode<String> bulldog = new TreeNode<String>("bulldog", dogs);
		TreeNode<String> chihuahua = new TreeNode<String>("chihuahua", dogs);
		TreeNode<String> husky = new TreeNode<String>("husky", dogs);
		dogTypes.root.addChild(pom);
		dogTypes.root.addChild(golden);
		dogTypes.root.addChild(bulldog);
		dogTypes.root.addChild(chihuahua);
		dogTypes.root.addChild(husky);
		dogTypes.save(currentDirectory + "mytree.txt");


		
		
		
		// Loading animal classification data from file "animal_classification_tree.txt".
		RootedTree animalClassificationTree = new RootedTree();
		animalClassificationTree.load(currentDirectory + "animal_classification_tree.txt");
		
		// Sanity Check for Problem 2: This is a simple sanity check to
		// help you test and debug your problem 2 solution.
		System.out.print("Sanity Check A passed = ");
		System.out.println(animalClassificationTree.getLeafNodes().toString().equals("[Arachnida, Insecta, Malacostraca, Aves, Chondrichthyes, Osteichthyes, Artiodactyla, Carnivora, Cetacea, Chiroptera, Hyracoidea, Insectivora, Lagomorpha, Perissodactyla, Primates, Proboscidea, Rodentia, Sirenia, Xenarthra, Testudines, Squamata, Crocodilia]"));
		
		// Sanity Checks for Problem 3: These are simple sanity checks to
		// help you test and debug your problem 3 solution.
		System.out.print("Sanity Check B passed = ");
		System.out.println(animalClassificationTree.getAncestry("Animalia").toString().equals("[Animalia]"));
		
		System.out.print("Sanity Check C passed = ");
		System.out.println(animalClassificationTree.getAncestry("asdfghjkl").toString().equals("[]"));
		
		System.out.print("Sanity Check D passed = ");
		System.out.println(animalClassificationTree.getAncestry("Reptilia").toString().equals("[Reptilia, Chordata, Animalia]"));
		
		System.out.print("Sanity Check E passed = ");
		System.out.println(animalClassificationTree.getAncestry("Cetacea").toString().equals("[Cetacea, Mammalia, Chordata, Animalia]"));
		
		System.out.print("Sanity Check F passed = ");
		System.out.println(animalClassificationTree.getAncestry("Crocodilia").toString().equals("[Crocodilia, Reptilia, Chordata, Animalia]"));

		System.out.print("Sanity Check G passed = ");
		System.out.println(animalClassificationTree.getAncestry("Arachnida").toString().equals("[Arachnida, Arthropoda, Animalia]"));
	}

}
