public class Deque<E> implements DequeInterface<E> {
    public DLList<E> dLList;

    public Deque() {
        dLList = new DLList<>();
    }

    public void addFront(E item) {
        dLList.addAtStart(item);
    }

    public void addBack(E item) {
        dLList.add(item);
    }

    public E removeFront() {
        if (dLList.isEmpty()) {
            return null;
        }
        return dLList.remove(1);
    }

    public E removeBack() {
        if (dLList.isEmpty()) {
            return null;
        }
        return dLList.remove(dLList.size());
    }

    public E peekFront() {
        return dLList.get(0);
    }

    public E peekBack() {
        return dLList.get(dLList.size()-1);
    }

    public int size() {
        return dLList.size();
    }

    public boolean isEmpty() {
        return dLList.isEmpty();
    }

    public void display() {
        dLList.display();
    }
}
