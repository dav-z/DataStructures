import java.util.ArrayList;
import java.util.List;

public class TreeNode<E> {

	public E element;
	public TreeNode<E> parent;
	public List<TreeNode<E>> children;
	
	public TreeNode(E element, TreeNode<E> parent) {
		this.element = element;
		children = new ArrayList<TreeNode<E>>();
	}
	
	public TreeNode(E element) {
		this(element, null);
	}
	
	public void addChild(TreeNode<E> node) {
		this.children.add(node);
		node.parent = this;
	}
	
	public String toString() {
		return element.toString();
	}
	
}
