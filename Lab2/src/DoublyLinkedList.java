import java.util.Iterator;

public class DoublyLinkedList<E> {

	private static final int E = 0;
	int size;
	Node<E> firstNode;
	Node<E> lastNode;
	
	public DoublyLinkedList() {
		size = 0;
		firstNode = null;
		lastNode = null;
	}
	
	// Problem 1 (15 pts)
	// Fill in the method below to add a new node at the given index with the given element.
	// If index is out of bounds, you must throw an IndexOutOfBoundsException.
	// You must appropriately update all next and prev's.
	// You must appropriately update the firstNode and lastNode.
	// Hint: It's recommended that you use if statements to split into four or five different cases.
    public void add(int index, E element) {
    		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		else if(index == 0 && size == 0) {
			firstNode = new Node<E>(element, firstNode, lastNode);
			lastNode = firstNode;
			size++;
		}
		else if(index == 0 && size > 0) {
			firstNode = new Node<E>(element, null, firstNode);
			size++;
		}
		else if(index > 0 && index < size) {
			Node<E> previous = getNode(index - 1);
			previous.next = new Node<E>(element, previous, previous.next);
			size++;
		}
		else if(index == size) {
			Node<E> previous = getNode(index - 1);
			previous.next = new Node<E>(element, lastNode, null);
			lastNode = previous.next;
//			System.out.println(lastNode.next.element);
			size++;
		}
	}
    
    public void add(E element) {
    		add(size, element);
    }
	
    // Problem 2 (15 pts)
 	// Fill in the method below to remove a new node at the given index.
 	// If index is out of bounds, you must throw an IndexOutOfBoundsException.
 	// You must appropriately update all next and prev's.
 	// You must appropriately update the firstNode and lastNode.
 	// Hint: It's recommended that you use if statements to split into four or five different cases.
	public E remove(int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		else if(index == 0) {
			E oldValue = firstNode.element;
			firstNode = firstNode.next;
			size--;
			return oldValue;
		}
		else if(index > 0 && index < size) {
			Node<E> previous = getNode(index - 1);
			E oldValue = previous.next.element;
			previous.next = previous.next.next;
			size--;
			return oldValue;
		}
		else {
			Node<E> previous = getNode(index - 1);
			E oldValue = previous.next.element;
			previous.next = lastNode;
			size--;
			return oldValue;
		}
	}
	
	public E get(int index) {
		return getNode(index).element;
	}
	
	public E set(int index, E element) {
		Node<E> tempNode = getNode(index);
		E oldValue = tempNode.element;
		tempNode.element = element;
		return oldValue;
	}
	
	// Problem 3 (10 pts)
	// Fill in the getNode, getNodeFromFront, and getNodeFromBack methods below to return the node at the given index.
	// The getNodeFromFront method starts from firstNode going forward.
	// The getNodeFromBack method starts from the lastNode going backwards.
	// The getNode method calls the getNodeFromFront method if index < size / 2 and it calls the getNodeFromBack method otherwise.
	// If index is out of bounds, you must throw an IndexOutOfBoundsException.
	public Node<E> getNode(int index){
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		else if(index < 2) {
			return getNodeFromFront(index);
		}
		else {
			return getNodeFromBack(index);
		}
	}

	private Node<E> getNodeFromFront(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		else {
			Node<E> current = firstNode;
			for(int i = 0; i < index; i++) {
				current = current.next;
			}
			return current;
		}
	}
	
	private Node<E> getNodeFromBack(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		else {
			Node<E> current = lastNode;
			for(int i = size - 1; i > index + 1; i--) {
				current = current.prev;
			}
			
			return current;
		}
	}
	
	// Problem 4 (5 pts)
	// Fill in the frontIsValid and backIsValid methods below to further test that you implemented your DoublyLinkedList properly.
	// The frontIsValid method checks that if you go backwards through the DoublyLinkedList, then you will eventually end with firstNode's element.
	// The frontIsValid method must use the backwardIterator to iterate going backward over the elements in the list.
	// The backIsValid method checks that if you go forwards through the DoublyLinkedList, then you will eventually end with lastNode's element.
	// The backIsValid method must use the forwardIterator to iterate going forward over the elements in the list.
	// Both methods return true if size == 0.
	public boolean frontIsValid() {
		Node<E> current = lastNode;
		int size = this.size();
		BackwardIterator test = new BackwardIterator(current);
		while(test.hasNext()) {
			size--;
			test.next();
		}
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean backIsValid() {
		Node<E> current = firstNode;
		int size = this.size();
		ForwardIterator<E> test = new ForwardIterator(current);
		while(test.hasNext()) {
			size--;	
			test.next();
		}
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	// helper methods
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("start");
		Node<E> currentNode = firstNode;
		for(int i = 0; i < size; i++) {
			builder.append(" <-> [");
			builder.append(currentNode.element);
			builder.append("]");
			currentNode = currentNode.next;
		}
		builder.append(" <-> end");
		
		return builder.toString();
	}
	
	// methods to add, get, and remove from front and back
	public void addToFront(E element) {
		add(0, element);
	}
	
	public void addToBack(E element) {
		add(size, element);
	}
	
	public E getFront() {
		return get(0);
	}
	
	public E getBack() {
		return get(size - 1);
	}
	
	public E removeFromFront() {
		return remove(0);
	}
	
	public E removeFromBack() {
		return remove(size - 1);
	}

	// get forward and backward iterators
	public Iterator<E> forwardIterator(){
		return new ForwardIterator<E>(firstNode);
	}
	
	public Iterator<E> backwardIterator(){
		return new BackwardIterator<E>(lastNode);
	}
	
}
