package MarkovText;

class LLNode<E>{

	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode(E e){

		this.data = e;
		this.prev = null;
		this.next = null;
	}
}