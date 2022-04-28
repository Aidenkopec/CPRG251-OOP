package sait.sll.utility;

import java.io.Serializable;

/**
 * Class that creates and manages Node objects
 */
public class Node implements Serializable {
	private static final long serialVersionUID = -5450893295088323545L;
	private Object element;
    private Node next;

    /**
     * Creates a new Node object
     * @param o data to be contained in the new node
     * @param n next node
     */
    public Node(Object o, Node n){
        this.element = o;
        this.next = n;
    }

    /**
     * Constructs the last node
     * @param o the data to be contained in the new node
     */
    public Node(Object o){
        this.element = o;
        this.next = null;
    }

    /**
     * Gets the data stored in the element of the node
     * @return data stored in the node
     */
    public Object getElement() {
        return element;
    }

    /**
     * Sets the data stored in the node
     * @param element data to be stored in the node
     */
    public void setElement(Object element) {
        this.element = element;
    }

    /**
     * Gets the node that is the next in the linked list
     * @return node that is linked to the current node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the node that is next in the linked list
     * @param next node to be linked to the current node
     */
    public void setNext(Node next) {
        this.next = next;
    }
}

