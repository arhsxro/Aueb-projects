import java.util.NoSuchElementException;

/**
 * Single-link List. Uses {@link Node} for list nodes.
 */
public class List implements ListInterface {

    private Node head = null;
    private Node tail = null;

    /**
     * Default constructor
     */
    public List() {
    }

    /**
     * Determine whether list is empty
     *
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Inserts the data at the front of the list
     *
     * @param data the inserted data
     */


    @Override
    public void insertAtFront(int data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    /**
     * Inserts the data at the end of the list
     *
     * @param data the inserted item
     */
    @Override
    public void insertAtBack(int data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    /**
     * Returns and removes the data from the list head
     *
     * @return the data contained in the list head
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public int removeFromFront() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        int data = head.getData();

        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();

        return data;
    }

    /**
     * Returns and removes the data from the list tail
     *
     * @return the data contained in the list tail
     * @throws java.util.NoSuchElementException if the list is empty
     */
    @Override
    public int removeFromBack() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        int data = tail.getData();

        if (head == tail)
            head = tail = null;
        else {
            Node iterator = head;
            while (iterator.getNext() != tail)
                iterator = iterator.getNext();

            iterator.setNext(null);
            tail = iterator;
        }

        return data;
    }

    /**
     * Returns list as String
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data

        while (current != null) {
            ret.append(current.data);

            if (current.getNext() != null)
                ret.append(" , ");

            current = current.next;
        }


        return ret.toString();
    }

    public int peek(){

        if (isEmpty())
            throw new NoSuchElementException();
        int data = 0;
        Node current = head;
        while (current != null) {
            data += current.getData();
            current = current.next;
        }

        return data;
    }


}