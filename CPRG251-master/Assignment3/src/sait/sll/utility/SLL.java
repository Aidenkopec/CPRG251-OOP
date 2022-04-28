package sait.sll.utility;

import java.io.Serializable;

/**
 * Class for creating and managing singly linked lists
 *
 * @author Allyssa Preece
 * @author Aiden Kopec
 * @author Anusone Soula
 * @version April 5, 2022
 */

public class SLL implements LinkedListADT, Serializable {
    private static final long serialVersionUID = -2816622779771728878L;
    private Node head;
    private Node tail;

    private int size = 0;

    /**
     * Creates an SLL object
     */
    public SLL() {
        head = tail = null;
    }

    /**
     * Gets the node at the head position of the SLL
     * @return node at the head position
     */
    public Node getHead() { return head;}

    /**
     * Sets the node at the first position of the SLL
     * @param head node at the first position
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Gets the node at the end of the SLL
     * @return node at the end of the SLL
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Sets the node at the end of the SLL
     * @param tail node at the end of the SLL
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * Gets the size of the SLL
     * @return size of the SLL
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the SLL
     * @param size size of the SLL
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Tests if the SLL is empty
     * @return false if the SLL is not empty and true if it is empty
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Clears the elements and next node for each node in the SLL
     */
    @Override
    public void clear() {
        try {
            Node current = head;
            Node temp;
            for (int i = 0; i < size; i++) {
                current.setElement(null);
                temp = current.getNext();
                current.setNext(null);
                current = temp;
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Adds a new node ot the end of the SLL
     * @param data Data to append.
     */
    @Override
    public void append(Object data) {
        if (tail == null) {
            head = tail = new Node(data);
        } else {
            tail.setNext(new Node(data));
            tail = tail.getNext();
        }
        size++;
    }

    /**
     * Adds a new node to the beginning of the SLL
     * @param data Data to add to the first node.
     */
    @Override
    public void prepend(Object data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    /**
     * Inserts a new node at a specified index in the list
     * @param data Data that element is to contain.
     * @param index Index to add new element at.
     * @throws NullPointerException if the node is null
     */
    @Override
    public void insert(Object data, int index) throws NullPointerException {
        try {
            if (index == 0) {
                prepend(data);
            } else if (index >= size) {
                append(data);
            } else {
                Node current = head;
                for (int i = 0; i <= index; i++) {
                    if (i == index) {
                        current = current.getNext();
                        Node temp = current.getNext();
                        current.setNext(new Node(data));
                        (current.getNext()).setNext(temp);
                    }
                }
            }
            setSize(getSize() + 1);
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Replaces the data of a node at a specified index
     * @param data Data to replace.
     * @param index Index of element to replace.
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public void replace(Object data, int index) throws IndexOutOfBoundsException {
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            } else {
                int i = 0;
                for (Node current = head; current != null; current = current.getNext()) {
                    if (i == index) {
                        current.setElement(data);
                    }
                    i++;
                }
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Gets the size of the SLL
     * @return size of the SLL
     */
    @Override
    public int size() {
        return getSize();
    }

    /**
     * Deletes a node at the specified index in the list
     * @param index Index of element to remove.
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            int i = 0;

            for (Node tempNode = head; tempNode != null; tempNode = tempNode.getNext()) {
                if (i == index - 1) {
                    tempNode.setNext(tempNode.getNext().getNext());
                }
                i++;
            }
            size--;
        } catch (IndexOutOfBoundsException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Retrieves the data contained in a node at a specified index
     * @param index Index of element to get.
     * @return the content of the node at the index
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
        Object found = null;
        try {
            int i = 0;
            for (Node tempNode = head; tempNode != null; tempNode = tempNode.getNext()) {
                if (i == index) {
                    found = tempNode.getElement();
                }
                i++;
            }

        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
        return found;
    }

    /**
     * Gets the index of the node that contains the data
     * @param data Data object to find the first index of.
     * @return index of the node that contains the specified data
     */
    @Override
    public int indexOf(Object data) {
        int index = 0;
        int foundIndex = 1000000000;
        for (Node tempNode = head; tempNode != null; tempNode = tempNode.getNext()) {
            if (tempNode.getElement() == data) {
                foundIndex = index;
            } else {
                index++;
            }
        }
        return foundIndex;
    }

    /**
     * Checks if the SLL contains a node with the data specified by the user
     * @param data Data object to search for.
     * @return boolean if the data is found or not
     */
    @Override
    public boolean contains(Object data) {
        boolean found = false;
        for (Node tempNode = head; tempNode != null; tempNode = tempNode.getNext()) {
            if (tempNode.getElement().toString().contains(data.toString())) {
                found = true;
            }
        }
        return found;
    }
}
