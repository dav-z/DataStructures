import java.util.LinkedList;
import java.util.List;

public class SimpleStack<E> implements Stack<E> {

	LinkedList<E> linkedList = new LinkedList<E>();
	
	@Override
	public void push(E element) {
		linkedList.addFirst(element);
	}

	@Override
	public E pop() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return linkedList.removeFirst();
		}
	}

	@Override
	public E peek() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return linkedList.getFirst();
		}
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	@Override
	public int size() {
		return linkedList.size();
	}

	@Override
	public List<E> toList() {
		return linkedList;
	}

}
