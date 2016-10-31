package MarkovText;

import java.util.AbstractList;


public class LinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public LinkedList() {

		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) {

		add(size, element);

		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) {

		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}

		LLNode<E> node = head;

		while(index >= 0) {
			node = node.next;
			index -= 1;
		}

		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element) {

		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}

		if(element == null) {
			throw new NullPointerException("Invalid Value");
		}

		if(index == size) {

			LLNode<E> node = new LLNode<E>(element);
			node.next = tail;
			node.prev = tail.prev;
			tail.prev.next = node;
			tail.prev  = node;

			size += 1;
		}

		else if(index < size) {

			LLNode<E> existingNode = head;

			while(index >= 0){
				existingNode = existingNode.next;
				index -= 1;
			}

			LLNode<E> newNode = new LLNode<E>(element);

			newNode.next = existingNode;
			newNode.prev = existingNode.prev;
			newNode.prev.next = newNode;
			existingNode.prev = newNode;

			size += 1;
		}
	}


	/** Return the size of the list */
	public int size() {

		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {

		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}

		LLNode<E> node = head;

		while(index >= 0) {
			node = node.next;
			index -= 1;
		}

		E temp = node.data;

		node.next.prev = node.prev;
		node.prev.next = node.next;

		size -= 1;

		return temp;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {

		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}

		if(element == null) {
			throw new NullPointerException("Invalid Value");
		}

		LLNode<E> node = head;

		while(index >= 0) {
			node = node.next;
			index -= 1;
		}

		E temp = node.data;
		node.data = element;
		return temp;
	}   
}
