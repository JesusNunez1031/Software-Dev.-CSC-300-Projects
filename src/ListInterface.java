public interface ListInterface<E> 
{
	void add(int index, E x);
	// inserts x into position index
	void add(E x);
	// adds x to the end of the list
	void clear();
	// removes all objects from the list
	boolean contains (E x);
	// returns true if x is a member of the list
	E get(int index);
	// returns the Object at position index
	boolean isEmpty();
	// returns true if the list has no elements
	boolean remove (E x);
	// if x is a member of the list, removes the first occurrence of x from the list,  
	// shifts all elements position, and returns true; otherwise returns false.
	E remove (int index);
	// removes and returns the object x at position index; // shifts all elements following x down one position
	E set (int index, E x);
	// replaces the object at index index with x; returns the replaced object.
	int size();
	// returns the number of objects currently in the list
	boolean hasNext();
	// returns true if a call to next() will be successful
	E next(); 
	// returns data of current node and moves current to the next node
}