import java.util.Iterator;

public class BackwardIterator<E> implements Iterator<E>{

	Node<E> nextNode;
	
	public BackwardIterator(Node<E> startNode){
		nextNode = startNode;
	}
	
	@Override
	public boolean hasNext() {
		return nextNode != null;
	}

	@Override
	public E next() {
		E element = nextNode.element;
		nextNode = nextNode.prev;
		
		return element;
	}

}
