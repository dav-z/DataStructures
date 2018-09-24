import java.util.Iterator;

public class ForwardIterator<E> implements Iterator<E>{

	Node<E> nextNode;
	
	public ForwardIterator(Node<E> startNode){
		nextNode = startNode;
	}
	
	@Override
	public boolean hasNext() {
		return nextNode != null;
	}

	@Override
	public E next() {
		E element = nextNode.element;
		nextNode = nextNode.next;
		
		return element;
	}

}
