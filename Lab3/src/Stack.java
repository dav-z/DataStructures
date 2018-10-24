import java.util.List;

public interface Stack<E> {

	public void push(E element);
	public E pop();
	public E peek();
	public boolean isEmpty();
	public int size();
	public List<E> toList();
	
}
