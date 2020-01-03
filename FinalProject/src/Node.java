public class Node<E> {
    private E data;
    private Node next, prev;

    public Node() {
		next = null;
		prev = null;
    }

    public Node(E x, Node n, Node p) {
        data = x;
        next = n;
        prev = p;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setPrevious(Node previous){
    	this.prev = previous;
	}

	public Node getPrevious(){
    	return prev;
	}

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

}
