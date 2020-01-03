/*This generic interface defines the deque abstract data type
A deque is an ordered list with operations that operate at either end of a list
You can add an item, remove an item, or peek at an item either at
the front of the deque or bak of the deque*/

public interface DequeInterface<E> {
    public void addFront(E item);
    //Inserts at from of the dequeue (item 0)

    public void addBack(E item);
    //Inserts at end of the dequeue

    public E removeFront();
    //Remove from the front (item 0) of the deque and return the reference to the oject removed
    //Return null if empty

    public E removeBack();
    //Remove from the back of the deque and return the reference to the object removed
    //Return null if empty

    public E peekFront();
    //Return reference to item at the front of the deque
    //Return null if empty

    public E peekBack();
    //Return reference to item at the back of the deque
    //Return null if empty

    public int size();
    //Returns number of elements in the deque

    public boolean isEmpty();
    //Returns true if the deque has no elements, otherwise false
}
