import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RootedTree {

	private final String PADDING_STRING = "0-";
	public TreeNode<String> root = null;
	
	public RootedTree(TreeNode<String> node) {
		this();
		root = node;
		node.parent = null;
	}
	
	public RootedTree(String filename) throws IOException {
		this();
		load(filename);
	}
	
	public RootedTree() {
		
	}
	
	public void save(String filename) throws IOException {
		LineWriter writer = new LineWriter();
		writer.open(filename);
		recursiveSave(writer, "", root);
		writer.close();
	}
	
	private void recursiveSave(LineWriter writer, String padding, TreeNode<String> current) {
		if(current != null) {
			writer.println(padding + current.element.toString());
			for(TreeNode<String> child : current.children) {
				recursiveSave(writer, padding + PADDING_STRING, child);
			}
		}
	}
	
	public void load(String filename) throws IOException {
		LineReader reader = new LineReader();
		reader.open(filename);
		root = new TreeNode<String>(reader.next());
		loadRecursively(reader, root, 0);
		reader.close();
	}
	
	private void loadRecursively(LineReader reader, TreeNode<String> current, int level) throws IOException {
		while(reader.hasNext()) {
			String line = reader.peek();
			
			String[] split = line.split(PADDING_STRING);
			int newLevel = split.length - 1;
			String newString = split[newLevel];
			
			if(newLevel > level + 1 || newLevel <= 0) {
				throw new IOException("Invalid data format.");
			}
			else if(newLevel == level + 1) {
				TreeNode<String> node = new TreeNode<String>(newString);
				current.addChild(node);
				reader.next();
				loadRecursively(reader, node, newLevel);
			}
			else {
				return;
			}
		}
	}
	
	// Problem 2 (15 pts): Fill in the getLeafNodes method.  This method should return
	// a list consisting of all of the leaf nodes in the rooted tree.
	// Note: You are allowed to add helper methods and use recursion.
	
	public void recursiveLeaf(TreeNode<String> current, ArrayList<TreeNode<String>> list) {
		if(current.children.isEmpty()) {
			list.add(current);
		}
		else {
			for(TreeNode<String> child : current.children) {
				recursiveLeaf(child, list);
			}
		}
	}
	
	public List<TreeNode<String>> getLeafNodes(){
		ArrayList<TreeNode<String>> leafList = new ArrayList<TreeNode<String>>();
		recursiveLeaf(this.root, leafList);
		return leafList;
	}
	
	// Problem 3 (20 pts): Fill in the getAncestry method.  This method should return
	// a list that represents a path of nodes from a node whose label is equal to 
	// element to the root node.
	// Note: You are allowed to add helper methods, use recursion, and use the 
	// SimpleStack class.
	
	public void recursiveFind(String element, ArrayList<TreeNode<String>> ancestryList, TreeNode<String> current) {
		if(current.element.equals(element)) {
			ancestryList.add(current);
			while(current.parent != null) {
				ancestryList.add(current.parent);
				current = current.parent;
			}
		}
		else {
			for(TreeNode<String> child : current.children) {
				recursiveFind(element, ancestryList, child);
			}
		}
	}
	
	public List<TreeNode<String>> getAncestry(String element){
		TreeNode<String> current = this.root;
		ArrayList<TreeNode<String>> ancestryList = new ArrayList<TreeNode<String>>();
		recursiveFind(element, ancestryList, current);
		return ancestryList;
	}
	
}
